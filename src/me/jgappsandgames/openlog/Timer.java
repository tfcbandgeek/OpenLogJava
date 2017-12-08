package me.jgappsandgames.openlog;

/**
 *
 */
public class Timer {
    private final String name;
    private long start;
    private long end;

    public Timer(String name) {
        this.name = name;
    }

    public void start() {
        if (Config.getInstance().getPrimaryWriter() != null) Config.getInstance().getPrimaryWriter().write(100, name, "Started");
        if (Config.getInstance().getSecondaryWriter() != null) Config.getInstance().getSecondaryWriter().write(100, name, "Started");
        end = 0;
        start = System.currentTimeMillis();
    }

    public void finish() {
        end = System.currentTimeMillis();
        long t = (end - start);
        if (Config.getInstance().getPrimaryWriter() != null) Config.getInstance().getPrimaryWriter().write(100, name, "Ran For " + String.valueOf(t));
        if (Config.getInstance().getSecondaryWriter() != null) Config.getInstance().getSecondaryWriter().write(100, name, "Ran For " + String.valueOf(t));
    }
}