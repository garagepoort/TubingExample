package be.garagepoort.tubingexample.broadcasting.bungee;

import be.garagepoort.tubingexample.broadcasting.BroadcastedMessage;
import be.garagepoort.tubingexample.common.bungee.BungeeMessage;

public class BungeeBroadcastMessage extends BungeeMessage {

    private final BroadcastedMessage broadcastedMessage;

    public BungeeBroadcastMessage(BroadcastedMessage broadcastedMessage) {
        super();
        this.broadcastedMessage = broadcastedMessage;
    }

    public BroadcastedMessage getBroadcastedMessage() {
        return broadcastedMessage;
    }
}
