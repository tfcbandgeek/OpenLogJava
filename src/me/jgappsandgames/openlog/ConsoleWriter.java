package me.jgappsandgames.openlog;

// Java
import java.util.Calendar;

/**
 * ConsoleWriter Implements: Writer
 *
 * Writes to the Console
 * Version: 1.3.1
 */
public class ConsoleWriter implements Writer {
    // Visible Methods -------------------------------------------------------------------------------------------------

    /**
     * load()
     *
     * Not Needed for the ConsoleWriter (Empty Statement)
     */
    @Override
    public void load() {

    }

    /**
     * write(Int, String, Data)
     *
     * Method used to write the data to the Console
     *
     * @param code Log Level
     * @param key The Key
     * @param data The Actual problem/text
     */
    @Override
    public void write(int code, String key, String data) {
        StringBuilder text = new StringBuilder();

        // Add The Prefix
        text.append("[")
                .append(Config.getInstance().getPrefix())
                .append("] ");

        if (Config.getInstance().getTimeStamp()) text.append("<").append(Calendar.getInstance().getTime().toString()).append("> ");

        // Add the Code
        switch (code) {
            // Log IInformation
            case Log.VERBOSE:
                if (Config.getInstance().isDebug()) return;
                text.append("VERBOSE:  ");
                break;
            case Log.DEBUG:
                if (Config.getInstance().isDebug()) return;
                text.append("DEBUG:    ");
                break;
            case Log.TRACK:
                if (Config.getInstance().isDebug()) return;
                text.append("TRACK:    ");
                break;
            case Log.INFO:
                text.append("INFO:     ");
                break;
            case Log.WARN:
                text.append("WARN:     ");
                break;

            // Exception Information
            case Exception.EXPECTED:
                if (Config.getInstance().isDebug()) return;
                text.append("Expected: ");
                break;
            case Exception.FIX:
                if (Config.getInstance().isDebug()) return;
                text.append("Fix:      ");
                break;
            case Exception.PROBLEM:
                text.append("Problem:  ");
                break;

            // Error Information
            case Error.DEBUG_ERROR:
                if (Config.getInstance().isDebug()) return;
                text.append("D_Error:  ");
                break;

            case Error.ERROR:
                text.append("Error:    ");
                break;

            // Default
            default:
                if (Config.getInstance().isDebug()) return;
                text.append("NA:       ");
                break;
        }

        // Add the Key
        key = key + "                    ";
        key = key.substring(0, Config.getInstance().getKeyLength() - 1);
        key = "[" + key + "] ";
        text.append(key);

        // Add The Data
        text.append(data);

        // Print the Log
        System.out.println(text.toString());
    }

    /**
     * clear()
     *
     * Does Nothing at the Moment
     */
    @Override
    public void clear() {
        // Does Nothing At the Moment
        System.out.flush();
    }

    // Singleton Instance ----------------------------------------------------------------------------------------------
    /**
     * The ConsoleWriter Instance
     */
    private static ConsoleWriter writer = null;

    /**
     * getInstance()
     *
     * Gets the ConsoleWriter Instance
     * @return The Config Instance
     */
    public static ConsoleWriter getInstance() {
        if (writer == null) writer = new ConsoleWriter();

        return writer;
    }
}