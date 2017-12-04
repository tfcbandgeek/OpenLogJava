package me.jgappsandgames.openlog;

// Java
import java.io.File;

/**
 * Config
 *
 * Holds the Config File for Open Log
 */
public class Config {
    // ---- ---- ---- ---- ---- ---- ---- ---- ---- File Locations ---- ---- ---- ---- ---- ---- ---- ---- ----
    /**
     * Location for Saving the Master List for Logs, Exceptions, and Errors (Combined)
     */
    private File all_file;
    /**
     * Location for Saving the Log File
     */
    private File log_file;
    /**
     * Location for saving the Exception File
     */
    private File except_file;
    /**
     * Location for saving the Error File
     */
    private File error_file;

    // ---- ---- ---- ---- ---- ---- ---- ---- ---- Writers ---- ---- ---- ---- ---- ---- ---- ---- ----
    /**
     * The Primary Writer for The Library
     *
     * DEFAULT: ConsoleWriter
     */
    private Writer primary_writer;
    /**
     * The Secondary Writer for the Library
     *
     * DEFAULT: NULL
     */
    private Writer secondary_writer;

    // ---- ---- ---- ---- ---- ---- ---- ---- ---- Initializer ---- ---- ---- ---- ---- ---- ---- ---- ----

    /**
     * Initializer
     *
     * Sets the Save Locations, Creates the Directory (If necessary), and sets the default writer
     */
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

    // ---- ---- ---- ---- ---- ---- ---- ---- ---- Getters ---- ---- ---- ---- ---- ---- ---- ---- ---- ----

    /**
     * getAll()
     *
     * Gets the Location for the Combined Save File
     * @return
     */
    public File getAll() {
        return all_file;
    }

    /**
     * getLog()
     *
     * Gets the Log Location
     * @return
     */
    public File getLog() {
        return log_file;
    }

    /**
     * getExcept()
     *
     * Gets the Exception Save Location
     * @return
     */
    public File getExcept() {
        return except_file;
    }

    /**
     * getError()
     *
     * Gets the Error Save Location
     * @return
     */
    public File getError() {
        return error_file;
    }

    /**
     * getPrimaryWriter()
     *
     * Gets the Primary Writer
     * @return
     */
    public Writer getPrimaryWriter() {
        return primary_writer;
    }

    /**
     * getSecondaryWriter()
     *
     * Gets the Secondary Writer
     * @return
     */
    public Writer getSecondaryWriter() {
        return secondary_writer;
    }

    // ---- ---- ---- ---- ---- ---- ---- ---- ---- Setters ---- ---- ---- ---- ---- ---- ---- ---- ----
    /**
     * set(File) Deprecated
     *
     * Sets A Universal File for the Logs
     * @param file The new File Location
     * @return This Config Instance, for Chaining Commands
     */
    @Deprecated
    public Config set(File file) {
        all_file = file;
        log_file = file;
        except_file = file;
        error_file = file;
        return this;
    }

    /**
     * setFiles(File)
     *
     * Sets A Universal File for the Logs
     * @param file The New File Location
     * @return The Config Instance, For Chaining Commands
     */
    public Config setFiles(File file) {
        all_file = file;
        log_file = file;
        except_file = file;
        error_file = file;
        return this;
    }

    /**
     * setAll(File)
     *
     * Sets the Combined File Location
     * @param file The New File Location
     * @return The Config Instance, For Chaining Commands
     */
    public Config setAll(File file) {
        all_file = file;
        return this;
    }

    /**
     * setLog(File)
     *
     * Sets the Log File Location
     * @param file The New File Location
     * @return The Config Instance, For Chaining Commands
     */
    public Config setLog(File file) {
        log_file = file;
        return this;
    }

    /**
     * setExcept(File)
     *
     * Sets the Exception File Location
     * @param file The New File Location
     * @return The Config Instance, For Chaining Commands
     */
    public Config setExcept(File file) {
        except_file = file;
        return this;
    }

    /**
     * setError(File)
     *
     * Sets the Error File Location
     * @param file The New File Location
     * @return The Config Instance, For Chaining Commands
     */
    public Config setError(File file) {
        error_file = file;
        return this;
    }

    /**
     * setWriters(Writer) Deprecated
     *
     * Sets the Same Writer for Both Instances
     * @param writer The New Writer
     * @return The Config Instance, For Chaining Commands
     */
    @Deprecated
    public Config setWriters(Writer writer) {
        primary_writer = writer;
        secondary_writer = writer;
        return this;
    }

    /**
     * setPrimaryWriter(Writer)
     *
     * Sets the Writer for the Primary Writer
     * @param writer The New Writer
     * @return The Config Instance, For Chaining Commands
     */
    public Config setPrimaryWriter(Writer writer) {
        primary_writer = writer;
        return this;
    }

    /**
     * setSecondaryWriter(Writer)
     *
     * Sets the Writer for the Secondary Writer
     * @param writer The New Writer
     * @return The Config Instance, For Chaining Commands
     */
    public Config setSecondaryWriter(Writer writer) {
        secondary_writer = writer;
        return this;
    }

    // ---- ---- ---- ---- ---- ---- ---- ---- ---- Singleton ---- ---- ---- ---- ---- ---- ---- ---- ----
    /**
     * The Config Instance
     */
    private static Config config;

    /**
     * generateConfig(File) Deprecated
     *
     * Generated the Config File with a certain File Selected for Everything
     * @param location The Location to Save to
     * @return The Config Instance, For Chaining Commands
     */
    @Deprecated
    public static Config generateConfig(File location) {
        if (!location.isDirectory()) location.mkdirs();
        return new Config().set(location);
    }

    /**
     * getInstance()
     *
     * Get the Instance of the Config that is active
     * @return the Config Instance (Duh)
     */
    public static Config getInstance() {
        if (config == null) config = new Config();
        return config;
    }
}