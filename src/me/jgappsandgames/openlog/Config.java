package me.jgappsandgames.openlog;

// Java
import java.io.File;

public class Config {
    // File Locations
    private File all_file;
    private File log_file;
    private File except_file;
    private File error_file;

    // Writers
    private Writer primary_writer;
    private Writer secondary_writer;

    // Initializer
    private Config() {
        // Set Locations
        all_file = new File("openlog");
        log_file = new File("openlog");
        except_file = new File("openlog");
        error_file = new File("openlog");

        // Create Directories if it does not exist yet
        if (!all_file.isDirectory()) all_file.mkdirs();
        if (!log_file.isDirectory()) log_file.mkdirs();
        if (!except_file.isDirectory()) except_file.mkdirs();
        if (!error_file.isDirectory()) error_file.mkdirs();

        primary_writer = ConsoleWriter.getInstance();
    }

    // Getters
    public File getAll() {
        return all_file;
    }
    public File getLog() {
        return log_file;
    }

    public File getExcept() {
        return except_file;
    }

    public File getError() {
        return error_file;
    }

    public Writer getPrimaryWriter() {
        return primary_writer;
    }

    public Writer getSecondaryWriter() {
        return secondary_writer;
    }

    // Setters
    public Config set(File file) {
        all_file = file;
        log_file = file;
        except_file = file;
        error_file = file;
        return this;
    }

    public Config setAll(File file) {
        all_file = file;
        return this;
    }

    public Config setLog(File file) {
        log_file = file;
        return this;
    }

    public Config setExcept(File file) {
        except_file = file;
        return this;
    }

    public Config setError(File file) {
        error_file = file;
        return this;
    }

    public Config setWriters(Writer writer) {
        primary_writer = writer;
        secondary_writer = writer;
        return this;
    }

    public Config setPrimaryWriter(Writer writer) {
        primary_writer = writer;
        return this;
    }

    public Config setSecondaryWriter(Writer writer) {
        secondary_writer = writer;
        return this;
    }

    // Singleton
    private static Config config;

    @Deprecated
    public static Config generateConfig(File location) {
        if (!location.isDirectory()) location.mkdirs();
        return new Config().set(location);
    }

    public static Config getInstance() {
        if (config == null) config = new Config();
        return config;
    }
}