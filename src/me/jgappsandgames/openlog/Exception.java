package me.jgappsandgames.openlog;

/**
 * Exception Class
 *
 * The Exception Class should be used to report errors within the app that do not lead to the app crashing.
 */
public class Exception {
    public static boolean debug = true;
    public static Writer writer = ConsoleWriter.getInstance();

    public static final int EXPECTED = 11;
    public static final int FIX = 12;
    public static final int PROBLEM = 13;

    // Write Expected (Debug Level Only)
    public static void e(String key, String data) {
        writer.write(EXPECTED, key, data);
    }

    // Write Fix (Debug Level Only)
    public static void f(String key, String data) {
        writer.write(FIX, key, data);
    }

    // Write Problem (Always)
    public static void p(String key, String data) {
        writer.write(PROBLEM, key, data);
    }
}