package me.jgappsandgames.openlog;

import java.io.File;

public class Config {
    private static Config config;

    public File location;

    public Config() {
        location = new File("openlog");
        if (!location.isDirectory()) location.mkdirs();
    }

    public static Config generateConfig(File location) {
        Config c = new Config();
        if (!location.isDirectory()) location.mkdirs();
        c.location = location;
        return c;
    }

    public static Config getInstance() {
        if (config == null) config = new Config();

        return config;
    }
}
