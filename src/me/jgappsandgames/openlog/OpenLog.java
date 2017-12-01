package me.jgappsandgames.openlog;

public class OpenLog {
    public static void init() {
        final Writer writer = ConsoleWriter.getInstance();

        // Setup Log Files
        Log.writers.add(writer);
        Exception.writers.add(writer);
        Error.writers.add(writer);
    }

    public static void init(Writer writer) {
        // Setup Log Files
        Log.writers.add(writer);
        Exception.writers.add(writer);
        Error.writers.add(writer);
    }

    public static void init(boolean debug) {
        final Writer writer = ConsoleWriter.getInstance();

        // Setup Log Files
        Log.writers.add(writer);
        Exception.writers.add(writer);
        Error.writers.add(writer);

        Log.debug = debug;
        Exception.debug = debug;
        Error.debug = debug;
    }

    public static void init(Writer writer, boolean debug) {
        // Setup Log Files
        Log.writers.add(writer);
        Exception.writers.add(writer);
        Error.writers.add(writer);

        Log.debug = debug;
        Exception.debug = debug;
        Error.debug = debug;
    }
}