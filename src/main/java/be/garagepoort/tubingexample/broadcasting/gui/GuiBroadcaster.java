package be.garagepoort.tubingexample.broadcasting.gui;

import be.garagepoort.mcioc.tubingbukkit.annotations.IocBukkitListener;
import be.garagepoort.mcioc.tubingbukkit.messaging.Messages;
import be.garagepoort.tubingexample.broadcasting.BroadcastedMessage;
import be.garagepoort.tubingexample.broadcasting.MessageBroadcastedEvent;
import be.garagepoort.tubingexample.broadcasting.bungee.BroadcastedMessageReceivedBungeeEvent;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

@IocBukkitListener
public class GuiBroadcaster implements Listener {

    private final Messages messages;

    public GuiBroadcaster(Messages messages) {
        this.messages = messages;
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
        messages.broadcast(message);
    }
}
