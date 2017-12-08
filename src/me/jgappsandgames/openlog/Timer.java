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
        Config.getInstance().getPrimaryWriter().write(100, name, "Started");
        Config.getInstance().getSecondaryWriter().write(100, name, "Started");
        end = 0;
        start = System.nanoTime();
    }

    public void finish() {
        end = System.nanoTime();
        long t = end - start;
        Config.getInstance().getPrimaryWriter().write(100, name, "Ran For " + String.valueOf(t));
        Config.getInstance().getSecondaryWriter().write(100, name, "Ran For " + String.valueOf(t));
    }
}