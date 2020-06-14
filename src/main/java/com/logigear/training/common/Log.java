package com.logigear.training.common;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.Marker;
import org.slf4j.MarkerFactory;

public class Log {
    private static Logger Log = LoggerFactory.getLogger(Log.class.getName());
    static final Marker marker = MarkerFactory.getMarker("FATAL");

    public static void info(String message) {
        Log.info(message);
    }

    public static void warn(String message) {
        Log.warn(message);
    }

    public static void error(String message) {
        Log.error(message);
    }

    public static void fatal(String message) {
        Log.error(marker, message);
    }

    public static void debug(String message) {
        Log.debug(message);
    }
}
