package be.garagepoort.tubingexample.broadcasting.gui;

import be.garagepoort.mcioc.IocBean;
import be.garagepoort.mcioc.IocListener;
import be.garagepoort.tubingexample.broadcasting.BroadcastedMessage;
import be.garagepoort.tubingexample.broadcasting.MessageBroadcastedEvent;
import be.garagepoort.tubingexample.broadcasting.bungee.BroadcastedMessageReceivedBungeeEvent;
import be.garagepoort.tubingexample.common.Configuration;
import be.garagepoort.tubingexample.common.MessageService;
import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

@IocBean
@IocListener
public class GuiBroadcaster implements Listener {

    private final MessageService messageService;
    private final Configuration configuration;

    public GuiBroadcaster(MessageService messageService, Configuration configuration) {
        this.messageService = messageService;
        this.configuration = configuration;
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
        Bukkit.getOnlinePlayers().forEach(p -> messageService.sendMessage(p, configuration.getBroadcastPrefix() + message));
    }

}
