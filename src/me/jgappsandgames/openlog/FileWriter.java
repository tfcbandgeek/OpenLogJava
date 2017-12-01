package me.jgappsandgames.openlog;

import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.util.Calendar;

public class FileWriter implements Writer {
    private BufferedWriter writer;

    // Visible Methods
    @Override
    public void load() {
        try {
            writer = new BufferedWriter(new java.io.FileWriter(new File(Config.getInstance().location, String.valueOf(Calendar.getInstance().get(Calendar.DAY_OF_YEAR)))));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void write(int code, String key, String data) {
        StringBuilder text = new StringBuilder();

        // Add The Prefix
        text.append("[OpenLog] ");

        // Add the Code
        switch (code) {
            // Log IInformation
            case Log.VERBOSE:
                text.append("VERBOSE:  ");
                break;
            case Log.DEBUG:
                text.append("DEBUG:    ");
                break;
            case Log.TRACK:
                text.append("TRACK:    ");
                break;
            case Log.INFO:
                text.append("INFO:     ");
                break;
            case Log.WARN:
                text.append("WARN:     ");
                break;

            // Exception Information
            case Exception.EXPECTED:
                text.append("Expected: ");
                break;
            case Exception.FIX:
                text.append("Fix:      ");
                break;
            case Exception.PROBLEM:
                text.append("Problem:  ");
                break;

            // Error Information
            case Error.DEBUG_ERROR:
                text.append("D_Error:  ");
                break;

            case Error.ERROR:
                text.append("Error:    ");
                break;

            // Default
            default:
                text.append("NA:       ");
                break;
        }

        // Add the Key
        key = key + "                    ";
        key = key.substring(0, 7);
        key = "[" + key + "] ";
        text.append(key);

        // Add The Data
        text.append(data);

        try {
            writer.append(text);
            writer.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void clear() {
        try {
            writer.write("");
            writer.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Helper Methods

    // Singleton Methods
    private static FileWriter fileWriter;
    public static FileWriter getInstance() {
        if (fileWriter == null) fileWriter = new FileWriter();
        fileWriter.load();
        return fileWriter;
    }
}
