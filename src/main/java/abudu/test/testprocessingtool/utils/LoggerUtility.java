package abudu.test.testprocessingtool.utils;


import java.util.logging.ConsoleHandler;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Logger is a utility class used to log messages, warnings, and errors for the application.
 * It uses Java's built-in logging framework to log at various levels such as INFO, WARNING, and SEVERE.
 */
public class LoggerUtility {

    // Define the logger instance for the application
    private static final Logger logger = Logger.getLogger(LoggerUtility.class.getName());


    static {
        // Set up a console handler to log messages to the console
        ConsoleHandler consoleHandler = new ConsoleHandler();
        consoleHandler.setLevel(Level.ALL); // Allow all levels of logs
        logger.addHandler(consoleHandler);
        logger.setLevel(Level.ALL); // Set the global logging level to ALL
    }

    public static void logInfo(String message) {
        logger.log(Level.INFO, message);
    }

    public static void logWarning(String message) {
        logger.log(Level.WARNING, message);
    }

    public static void logSevere(String message) {
        logger.log(Level.SEVERE, message);
    }

    public static void logError(Exception e) {
        logger.log(Level.SEVERE, "An error occurred: ", e);
    }
}