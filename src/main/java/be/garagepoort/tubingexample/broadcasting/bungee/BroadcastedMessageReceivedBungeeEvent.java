package be.garagepoort.tubingexample.broadcasting.bungee;

import be.garagepoort.tubingexample.broadcasting.BroadcastedMessage;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

public class BroadcastedMessageReceivedBungeeEvent extends Event {

    private static final HandlerList HANDLERS = new HandlerList();
    private final BroadcastedMessage broadcastedMessage;

    public BroadcastedMessageReceivedBungeeEvent(BroadcastedMessage broadcastedMessage) {
        this.broadcastedMessage = broadcastedMessage;
    }

    public BroadcastedMessage getBroadcastedMessage() {
        return broadcastedMessage;
    }

    @Override
    public HandlerList getHandlers() {
        return HANDLERS;
    }

    public static HandlerList getHandlerList() {
        return HANDLERS;
    }

}
