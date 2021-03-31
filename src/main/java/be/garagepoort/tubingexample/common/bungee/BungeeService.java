package be.garagepoort.tubingexample.common.bungee;

import be.garagepoort.mcioc.IocBean;
import com.google.common.io.ByteArrayDataInput;
import com.google.common.io.ByteArrayDataOutput;
import com.google.common.io.ByteStreams;
import com.google.gson.Gson;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import be.garagepoort.tubingexample.TubingExample;

import java.io.*;
import java.util.Optional;

import static be.garagepoort.tubingexample.common.Constants.BUNGEE_CORD_CHANNEL;

@IocBean
public class BungeeService {

    public BungeeService() {
        Bukkit.getServer().getMessenger().registerOutgoingPluginChannel(TubingExample.get(), BUNGEE_CORD_CHANNEL);
    }

    public void sendMessage(Player player, String channel, Object event) {
        if (player == null) {
            return;
        }
        try {
            ByteArrayDataOutput out = ByteStreams.newDataOutput();
            out.writeUTF("Forward");
            out.writeUTF("ALL");
            out.writeUTF(channel);
            ByteArrayOutputStream msgbytes = new ByteArrayOutputStream();
            DataOutputStream msgout = new DataOutputStream(msgbytes);
            msgout.writeUTF(new Gson().toJson(event));

            out.writeShort(msgbytes.toByteArray().length);
            out.write(msgbytes.toByteArray());

            player.sendPluginMessage(TubingExample.get(), BUNGEE_CORD_CHANNEL, out.toByteArray());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public <T> Optional<T> handleReceived(String channel, String subChannel, byte[] message, Class<? extends BungeeMessage> classOf) {
        if (!channel.equals(BUNGEE_CORD_CHANNEL)) {
            return Optional.empty();
        }
        try {
            ByteArrayDataInput in = ByteStreams.newDataInput(message);
            String subchannel = in.readUTF();
            if (subchannel.equals(subChannel)) {
                short len = in.readShort();
                byte[] msgbytes = new byte[len];
                in.readFully(msgbytes);

                DataInputStream msgin = new DataInputStream(new ByteArrayInputStream(msgbytes));
                String data = msgin.readUTF();
                BungeeMessage bungeeMessage = new Gson().fromJson(data, classOf);
                if (getDuration(bungeeMessage) > 10) {
                    return Optional.empty();
                }
                return (Optional<T>) Optional.of(bungeeMessage);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return Optional.empty();
    }

    private long getDuration(BungeeMessage bungeeMessage) {
        long now = System.currentTimeMillis();
        return (now - bungeeMessage.getTimestamp()) / 1000;
    }
}
