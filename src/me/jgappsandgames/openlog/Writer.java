package me.jgappsandgames.openlog;

public interface Writer {
    void load();
    void write(int code, String key, String data);
    void clear();
}
