package me.jgappsandgames.openlog;

import java.util.ArrayList;

/**
 * Log Class
 *
 * This Class should always be used to monitor what is going on with the application you want to Monitor
 */
public class Log {
    public static boolean debug = true;
    public static ArrayList<Writer> writers = new ArrayList<>();

    // Log Levels
    public static final int VERBOSE = 1;
    public static final int DEBUG = 2;
    public static final int TRACK = 3;

    public static final int INFO = 4;
    public static final int WARN = 5;

    // Write Verbose (Debug Level Only)
    public static void v(String key, String data) {
        if (writers.size() != 0) for (Writer writer : writers) writer.write(VERBOSE, key, data);
    }

    // Write Debug (Debug Level Only)
    public static void d(String key, String data) {
        if (writers.size() != 0) for (Writer writer : writers) writer.write(DEBUG, key, data);
    }

    // Write Track (Debug Level Only)
    public static void t(String key, String data) {
        if (writers.size() != 0) for (Writer writer : writers) writer.write(TRACK, key, data);
    }

    // Write Info (Always)
    public static void i(String key, String data) {
        if (writers.size() != 0) for (Writer writer : writers) writer.write(INFO, key, data);
    }

    // Write Warn (Always)
    public static void w(String key, String data) {
        if (writers.size() != 0) for (Writer writer : writers) writer.write(WARN, key, data);
    }
}