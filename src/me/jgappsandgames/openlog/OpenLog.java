package me.jgappsandgames.openlog;

public class OpenLog {
    public static void init() {
        final Writer writer = ConsoleWriter.getInstance();

        // Setup Log Files
        Log.writer = writer;
        Exception.writer = writer;
        Error.writer = writer;
    }
}