package be.garagepoort.tubingexample.broadcasting;

import java.util.UUID;

public class BroadcastedMessage {

    private final UUID playerUuid;
    private final String playerName;
    private final String message;

    public BroadcastedMessage(UUID playerUuid, String playerName, String message) {
        this.playerUuid = playerUuid;
        this.playerName = playerName;
        this.message = message;
    }

    public UUID getPlayerUuid() {
        return playerUuid;
    }

    public String getPlayerName() {
        return playerName;
    }

    public String getMessage() {
        return message;
    }
}
