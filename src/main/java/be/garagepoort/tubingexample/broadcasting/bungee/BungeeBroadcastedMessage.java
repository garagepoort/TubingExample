package be.garagepoort.tubingexample.broadcasting.bungee;

import be.garagepoort.tubingexample.broadcasting.BroadcastedMessage;
import be.garagepoort.tubingexample.common.bungee.BungeeMessage;

public class BungeeBroadcastedMessage extends BungeeMessage {

    private final BroadcastedMessage broadcastedMessage;

    public BungeeBroadcastedMessage(BroadcastedMessage broadcastedMessage) {
        super();
        this.broadcastedMessage = broadcastedMessage;
    }

    public BroadcastedMessage getBroadcastedMessage() {
        return broadcastedMessage;
    }
}
