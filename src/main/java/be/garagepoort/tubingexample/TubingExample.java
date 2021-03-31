package be.garagepoort.tubingexample;

import be.garagepoort.mcioc.TubingPlugin;
import be.garagepoort.tubingexample.config.AutoUpdater;

public class TubingExample extends TubingPlugin {

    private static TubingExample plugin;

    public static TubingExample get() {
        return plugin;
    }

    @Override
    protected void enable() {
        plugin = this;
        saveDefaultConfig();
        AutoUpdater.updateConfig(this);
    }

    @Override
    protected void disable() {
        // no disabling logic
    }

}