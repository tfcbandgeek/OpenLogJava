package me.jgappsandgames.openlog;

public class OpenLog {
    public static void init() {
        final Writer writer = ConsoleWriter.getInstance();

        // Setup Log Files
        Log.writer = writer;
        Exception.writer = writer;
        Error.writer = writer;
    }

    public static void init(Writer writer) {
        // Setup Log Files
        Log.writer = writer;
        Exception.writer = writer;
        Error.writer = writer;
    }

    public static void init(boolean debug) {
        final Writer writer = ConsoleWriter.getInstance();

        // Setup Log Files
        Log.writer = writer;
        Log.debug = debug;
        Exception.writer = writer;
        Exception.debug = debug;
        Error.writer = writer;
        Error.debug = debug;
    }

    public static void init(Writer writer, boolean debug) {
        // Setup Log Files
        Log.writer = writer;
        Log.debug = debug;
        Exception.writer = writer;
        Exception.debug = debug;
        Error.writer = writer;
        Error.debug = debug;
    }
}