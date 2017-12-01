package me.jgappsandgames.openlog;

import java.util.ArrayList;

/**
 * Error Class
 *
 * The Error Class should be used to report when within the app that are not recoverable (The App Stops Execution Afterwards)
 */
public class Error {
    public static boolean debug = true;
    public static ArrayList<Writer> writers = new ArrayList<>();

    public static final int DEBUG_ERROR = 21;
    public static final int ERROR = 22;

    // Write Debug (Always)
    public static void d(String key, String data) {
        if (writers.size() != 0) for (Writer writer : writers) writer.write(DEBUG_ERROR, key, data);
    }

    // Write Error (Always)
    public static void e(String key, String data) {
        if (writers.size() != 0) for (Writer writer : writers) writer.write(ERROR, key, data);
    }
}