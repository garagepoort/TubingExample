package be.garagepoort.tubingexample.broadcasting.bungee;

import be.garagepoort.mcioc.tubingbukkit.annotations.IocBukkitListener;
import be.garagepoort.tubingexample.broadcasting.MessageBroadcastedEvent;
import be.garagepoort.tubingexample.common.Constants;
import be.garagepoort.tubingexample.common.bungee.BungeeService;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

@IocBukkitListener(conditionalOnProperty = "tubing-example.broadcast-on-bungee=true")
public class BroadcastedMessageBungeeSender implements Listener {

    private final BungeeService bungeeService;

    public BroadcastedMessageBungeeSender(BungeeService bungeeService) {
        this.bungeeService = bungeeService;
    }

    @EventHandler
    public void onBroadcast(MessageBroadcastedEvent messageBroadcastedEvent) {
        Player player = Bukkit.getOnlinePlayers().iterator().next();
        bungeeService.sendMessage(player, Constants.BUNGEE_REPORT_MESSAGE_BROADCAST_CHANNEL, new BungeeBroadcastedMessage(messageBroadcastedEvent.getBroadcastedMessage()));
    }
}
