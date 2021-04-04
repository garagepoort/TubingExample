package be.garagepoort.tubingexample.config;

import be.garagepoort.tubingexample.TubingExample;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;

import static java.nio.charset.StandardCharsets.UTF_8;

public class AutoUpdater {

    private static final String CONFIG_FILE = "config.yml";

    public static void updateConfig(TubingExample bscorereportSystem) {
        bscorereportSystem.getLogger().info("Attempting to fix configuration file...");
        FileConfiguration config = bscorereportSystem.getConfig();
        AtomicInteger counter = new AtomicInteger();
        loadConfig().forEach((k, v) -> {
            if (!config.contains(k, true) && !(v instanceof ConfigurationSection)) {
                config.set(k, v);
                counter.getAndIncrement();
            }
        });
        bscorereportSystem.saveConfig();
        if (counter.get() > 0) {
            bscorereportSystem.getLogger().info("Configuration file Fixed. [" + counter.get() + "] properties were added.");
        } else {
            bscorereportSystem.getLogger().info("Configuration file is up to date. No fix needed");
        }
    }

    private static Map<String, Object> loadConfig() {
        Map<String, Object> configurations = new HashMap<>();
        InputStream defConfigStream = getResource();
        if (defConfigStream != null) {
            YamlConfiguration yamlConfiguration = YamlConfiguration.loadConfiguration(new InputStreamReader(defConfigStream, UTF_8));
            Set<String> keys = yamlConfiguration.getKeys(true);
            keys.forEach(k -> configurations.put(k, yamlConfiguration.get(k)));
        }
        return configurations;
    }

    private static InputStream getResource() {
        try {
            URL url = AutoUpdater.class.getClassLoader().getResource(AutoUpdater.CONFIG_FILE);
            if (url == null) {
                return null;
            }
            URLConnection connection = url.openConnection();
            connection.setUseCaches(false);
            return connection.getInputStream();
        } catch (IOException var4) {
            return null;
        }
    }
}
