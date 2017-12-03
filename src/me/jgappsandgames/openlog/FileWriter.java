package me.jgappsandgames.openlog;

import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.util.Calendar;

public class FileWriter implements Writer {
    private BufferedWriter all;
    private BufferedWriter log;
    private BufferedWriter except;
    private BufferedWriter error;

    // Visible Methods
    @Override
    public void load() {
        try {
            all = new BufferedWriter(new java.io.FileWriter(new File(Config.getInstance().getAll(), String.valueOf(Calendar.getInstance().get(Calendar.DAY_OF_YEAR)) + ".all")));
            log = new BufferedWriter(new java.io.FileWriter(new File(Config.getInstance().getLog(), String.valueOf(Calendar.getInstance().get(Calendar.DAY_OF_YEAR)) + ".log")));
            except = new BufferedWriter(new java.io.FileWriter(new File(Config.getInstance().getExcept(), String.valueOf(Calendar.getInstance().get(Calendar.DAY_OF_YEAR)) + ".except")));
            error = new BufferedWriter(new java.io.FileWriter(new File(Config.getInstance().getError(), String.valueOf(Calendar.getInstance().get(Calendar.DAY_OF_YEAR)) + ".error")));
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
            if (code <= 10 ) {
                log.append(text);
                log.append(System.lineSeparator());
                log.flush();
            } else if (code <= 20) {
                except.append(text);
                except.append(System.lineSeparator());
                except.flush();
            } else if (code <= 30) {
                error.append(text);
                error.append(System.lineSeparator());
                error.flush();
            }

            all.append(text);
            all.append(System.lineSeparator());
            all.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void clear() {
        try {
            log.write("");
            log.flush();

            except.write("");
            except.flush();

            error.write("");
            error.flush();
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
