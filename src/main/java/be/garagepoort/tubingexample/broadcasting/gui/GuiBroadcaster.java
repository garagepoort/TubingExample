package be.garagepoort.tubingexample.broadcasting.gui;

import be.garagepoort.mcioc.configuration.ConfigProperty;
import be.garagepoort.mcioc.tubingbukkit.annotations.IocBukkitListener;
import be.garagepoort.tubingexample.broadcasting.BroadcastedMessage;
import be.garagepoort.tubingexample.broadcasting.MessageBroadcastedEvent;
import be.garagepoort.tubingexample.broadcasting.bungee.BroadcastedMessageReceivedBungeeEvent;
import be.garagepoort.tubingexample.common.MessageService;
import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

@IocBukkitListener
public class GuiBroadcaster implements Listener {

    @ConfigProperty("tubing-example.broadcast-prefix")
    private String broadcastPrefix;

    private final MessageService messageService;

    public GuiBroadcaster(MessageService messageService) {
        this.messageService = messageService;
    }

    @EventHandler
    public void handleBroadcastEvent(MessageBroadcastedEvent messageBroadcastedEvent) {
        broadcastMessage(messageBroadcastedEvent.getBroadcastedMessage());
    }

    @EventHandler
    public void handleBungeeBroadcastEvent(BroadcastedMessageReceivedBungeeEvent messageBroadcastedEvent) {
        broadcastMessage(messageBroadcastedEvent.getBroadcastedMessage());
    }

    private void broadcastMessage(BroadcastedMessage broadcastedMessage) {
        String message = broadcastedMessage.getMessage();
        Bukkit.getOnlinePlayers().forEach(p -> messageService.sendMessage(p, broadcastPrefix + message));
    }
}
