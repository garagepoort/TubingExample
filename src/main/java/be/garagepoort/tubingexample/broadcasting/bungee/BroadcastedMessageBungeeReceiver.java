package be.garagepoort.tubingexample.broadcasting.bungee;

import be.garagepoort.mcioc.IocBean;
import be.garagepoort.mcioc.IocMessageListener;
import be.garagepoort.tubingexample.common.Constants;
import be.garagepoort.tubingexample.common.bungee.BungeeService;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.plugin.messaging.PluginMessageListener;

import java.util.Optional;

import static be.garagepoort.tubingexample.common.Constants.BUNGEE_REPORT_MESSAGE_BROADCAST_CHANNEL;

@IocBean(conditionalOnProperty = "tubing-example.broadcast-on-bungee=true")
@IocMessageListener(channel = Constants.BUNGEE_CORD_CHANNEL)
public class BroadcastedMessageBungeeReceiver implements PluginMessageListener {

    private final BungeeService bungeeService;

    public BroadcastedMessageBungeeReceiver(BungeeService bungeeService) {
        this.bungeeService = bungeeService;
    }

    @Override
    public void onPluginMessageReceived(String channel, Player player, byte[] message) {
        Optional<BungeeBroadcastedMessage> bungeeMessage = bungeeService.handleReceived(channel, BUNGEE_REPORT_MESSAGE_BROADCAST_CHANNEL, message, BungeeBroadcastedMessage.class);
        bungeeMessage.map(BungeeBroadcastedMessage::getBroadcastedMessage).ifPresent(b -> Bukkit.getPluginManager().callEvent(new BroadcastedMessageReceivedBungeeEvent(b)));
    }
}
