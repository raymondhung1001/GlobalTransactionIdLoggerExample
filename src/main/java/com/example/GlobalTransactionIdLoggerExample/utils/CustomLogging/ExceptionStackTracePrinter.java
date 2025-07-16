package com.example.globaltransactionidloggerexample.utils.CustomLogging;

import org.apache.logging.log4j.Logger;
import java.util.Arrays;


public class ExceptionStackTracePrinter {

    public static void logErrorAndStackTrace(Logger logger, String methodName,
                                             Throwable throwable, boolean includeStackTrace) {
        // Log the error message - the transaction ID will be included automatically by the logging framework
        logger.error("Exception in method {}: {}", methodName, throwable.getMessage());

        // If includeStackTrace is true, log the stack trace elements directly
        if (includeStackTrace) {
            logStackTrace(logger, throwable, "Exception in method " + methodName);
        }
    }


    private static void logStackTrace(Logger logger, Throwable throwable, String context) {
        // Log stack trace header - transaction ID is included automatically by the logging framework
        logger.error("Stack trace for {}: {}", context, throwable.getClass().getName());

        // Log the exception stack trace
        logThrowableAndStackTrace(logger, throwable, "");
    }

    private static void logThrowableAndStackTrace(Logger logger, Throwable throwable, String prefix) {

        if (!prefix.isEmpty()) {
            logger.error("{}Caused by: {}: {}", prefix, throwable.getClass().getName(), throwable.getMessage());
        }

        Arrays.stream(throwable.getStackTrace())
                .forEach(element -> logger.error("{}    at {}", prefix, element.toString()));

        Throwable cause = throwable.getCause();
        if (cause != null) {
            logThrowableAndStackTrace(logger, cause, prefix);
        }

        Throwable[] suppressed = throwable.getSuppressed();
        if (suppressed != null && suppressed.length > 0) {
            Arrays.stream(suppressed).forEach(suppressedThrowable -> {
                logger.error("{}Suppressed: {}: {}",
                        prefix, suppressedThrowable.getClass().getName(), suppressedThrowable.getMessage());

                Arrays.stream(suppressedThrowable.getStackTrace())
                        .forEach(element -> logger.error("{}    at {}", prefix, element.toString()));
            });
        }
    }
}