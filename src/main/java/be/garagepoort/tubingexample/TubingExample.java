package be.garagepoort.tubingexample;

import be.garagepoort.mcioc.TubingPlugin;

public class TubingExample extends TubingPlugin {

    @Override
    protected void enable() {
        getLogger().info("TubingExample enabled");
    }

    @Override
    protected void disable() {
        getLogger().info("TubingExample disabled");
    }
}
