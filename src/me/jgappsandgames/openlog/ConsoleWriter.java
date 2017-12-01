package me.jgappsandgames.openlog;

public class ConsoleWriter implements Writer {
    // Visible Methods
    @Override
    public void load() {

    }

    @Override
    public void write(int code, String key, String data) {
        StringBuilder text = new StringBuilder();

        // Add The Prefix
        text.append("[OpenLog] ");

        // Add the Code
        switch (code) {
            // Log IInformation
            case Log.VERBOSE:
                text.append("VERBOSE:  ");
                break;
            case Log.DEBUG:
                text.append("DEBUG:    ");
                break;
            case Log.TRACK:
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
                text.append("Expected: ");
                break;
            case Exception.FIX:
                text.append("Fix:      ");
                break;
            case Exception.PROBLEM:
                text.append("Problem:  ");
                break;

            // Error Information
            case Error.DEBUG_ERROR:
                text.append("D_Error:  ");
                break;

            case Error.ERROR:
                text.append("Error:    ");
                break;

            // Default
            default:
                text.append("NA:       ");
                break;
        }

        // Add the Key
        key = key + "                    ";
        key = key.substring(0, 7);
        key = "[" + key + "] ";
        text.append(key);

        // Add The Data
        text.append(data);

        System.out.println(text.toString());
    }

    @Override
    public void clear() {
        // Does Nothing At the Moment
    }

    // Helper Methods

    // Singleton Instance
    public static ConsoleWriter writer = null;
    public static ConsoleWriter getInstance() {
        if (writer == null) writer = new ConsoleWriter();

        return writer;
    }
}
