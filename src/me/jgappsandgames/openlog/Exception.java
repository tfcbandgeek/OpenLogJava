package me.jgappsandgames.openlog;

/**
 * Exception Class
 *
 * The Exception Class should be used to report errors within the app that do not lead to the app crashing.
 */
public class Exception {
    // Exception Levels
    public static final int EXPECTED = 11;
    public static final int FIX = 12;
    public static final int PROBLEM = 13;

    // Write Expected (Debug Level Only)
    public static void e(String key, String data) {
        if (Config.getInstance().getPrimaryWriter() != null) Config.getInstance().getPrimaryWriter().write(EXPECTED, key, data);
        if (Config.getInstance().getSecondaryWriter() != null) Config.getInstance().getSecondaryWriter().write(EXPECTED, key, data);
    }

    // Write Fix (Debug Level Only)
    public static void f(String key, String data) {
        if (Config.getInstance().getPrimaryWriter() != null) Config.getInstance().getPrimaryWriter().write(FIX, key, data);
        if (Config.getInstance().getSecondaryWriter() != null) Config.getInstance().getSecondaryWriter().write(FIX, key, data);
    }

    // Write Problem (Always)
    public static void p(String key, String data) {
        if (Config.getInstance().getPrimaryWriter() != null) Config.getInstance().getPrimaryWriter().write(PROBLEM, key, data);
        if (Config.getInstance().getSecondaryWriter() != null) Config.getInstance().getSecondaryWriter().write(PROBLEM, key, data);
    }
}