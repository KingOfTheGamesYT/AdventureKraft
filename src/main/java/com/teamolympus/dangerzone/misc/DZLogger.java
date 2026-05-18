package com.teamolympus.dangerzone.misc;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class DZLogger
{
    private static final String LOGGER_NAME = "AdventureKraft Logger";
    private static final Logger LOGGER = LogManager.getLogger(LOGGER_NAME);

    public static void fatal(String string) {
        LOGGER.fatal(string);
    }

    public static void error(String string) {
        LOGGER.error(string);
    }

    public static void warning(String string) {
        LOGGER.warn(string);
    }

    public static void info(String string) {
        LOGGER.info(string);
    }

    public static void debug(String string) {
        LOGGER.debug(string);
    }

    public static void trace(String string) {
        LOGGER.trace(string);
    }

}
