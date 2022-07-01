package be.garagepoort.tubingexample;

import be.garagepoort.mcioc.tubingbukkit.TubingBukkitPlugin;

public class TubingExample extends TubingBukkitPlugin {

    @Override
    protected void enable() {
        getLogger().info("TubingExample enabled");
    }

    @Override
    protected void disable() {
        getLogger().info("TubingExample disabled");
    }
}
