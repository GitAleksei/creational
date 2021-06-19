package ru.netology.task2;


import java.util.Date;

public class Logger {
    private static Logger instance = null;

    private int count;

    private Logger() {
        count = 1;
    }

    public static Logger getInstance() {
        if (instance == null) {
            instance = new Logger();
        }
        return instance;
    }

    void log(String msg) {
        System.out.println("[" + new Date() + " " + count++ + "] " + msg);
    }
}
