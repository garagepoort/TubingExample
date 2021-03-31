package be.garagepoort.tubingexample.config;

import be.garagepoort.mcioc.IocBean;
import org.bukkit.configuration.file.FileConfiguration;
import be.garagepoort.tubingexample.TubingExample;

@IocBean
public class Configuration {

    private String broadcastPrefix;

    public Configuration() {
        load(TubingExample.get().getConfig());
    }

    public void load(FileConfiguration config) {
        broadcastPrefix = config.getString("tubing-example.broadcast-prefix");
    }

    public String getBroadcastPrefix() {
        return broadcastPrefix;
    }
}
