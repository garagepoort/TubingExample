package be.garagepoort.tubingexample.config;

import be.garagepoort.mcioc.IocBean;
import be.garagepoort.mcioc.configuration.ConfigProperty;

@IocBean
public class Configuration {

    @ConfigProperty("tubing-example.broadcast-prefix")
    public String broadcastPrefix;
}
