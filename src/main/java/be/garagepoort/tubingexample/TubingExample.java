package be.garagepoort.tubingexample;

import be.garagepoort.mcioc.TubingPlugin;

public class TubingExample extends TubingPlugin {

    private static TubingExample plugin;

    public static TubingExample get() {
        return plugin;
    }

    @Override
    protected void beforeEnable() {
        plugin = this;
    }

    @Override
    protected void enable() {
        getLogger().info("TubingExample enabled");
    }

    @Override
    protected void disable() {
        getLogger().info("TubingExample disabled");
    }
}
