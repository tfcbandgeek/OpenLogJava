package me.jgappsandgames.openlog;

/**
 * Log Class
 *
 * This Class should always be used to monitor what is going on with the application you want to Monitor
 */
public class Log {
    // Log Levels
    public static final int VERBOSE = 1;
    public static final int DEBUG = 2;
    public static final int TRACK = 3;

    public static final int INFO = 4;
    public static final int WARN = 5;

    // Write Verbose (Debug Level Only)
    public static void v(String key, String data) {
        if (Config.getInstance().getPrimaryWriter() != null) Config.getInstance().getPrimaryWriter().write(VERBOSE, key, data);
        if (Config.getInstance().getSecondaryWriter() != null) Config.getInstance().getSecondaryWriter().write(VERBOSE, key, data);
    }

    // Write Debug (Debug Level Only)
    public static void d(String key, String data) {
        if (Config.getInstance().getPrimaryWriter() != null) Config.getInstance().getPrimaryWriter().write(DEBUG, key, data);
        if (Config.getInstance().getSecondaryWriter() != null) Config.getInstance().getSecondaryWriter().write(DEBUG, key, data);
    }

    // Write Track (Debug Level Only)
    public static void t(String key, String data) {
        if (Config.getInstance().getPrimaryWriter() != null) Config.getInstance().getPrimaryWriter().write(TRACK, key, data);
        if (Config.getInstance().getSecondaryWriter() != null) Config.getInstance().getSecondaryWriter().write(TRACK, key, data);
    }

    // Write Info (Always)
    public static void i(String key, String data) {
        if (Config.getInstance().getPrimaryWriter() != null) Config.getInstance().getPrimaryWriter().write(INFO, key, data);
        if (Config.getInstance().getSecondaryWriter() != null) Config.getInstance().getSecondaryWriter().write(INFO, key, data);
    }

    // Write Warn (Always)
    public static void w(String key, String data) {
        if (Config.getInstance().getPrimaryWriter() != null) Config.getInstance().getPrimaryWriter().write(WARN, key, data);
        if (Config.getInstance().getSecondaryWriter() != null) Config.getInstance().getSecondaryWriter().write(WARN, key, data);
    }
}