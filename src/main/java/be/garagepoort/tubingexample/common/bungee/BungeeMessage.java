package be.garagepoort.tubingexample.common.bungee;

public class BungeeMessage {

    private Long timestamp;

    public BungeeMessage() {
        this.timestamp = System.currentTimeMillis();
    }

    public Long getTimestamp() {
        return timestamp;
    }

}
