package utility;
import org.apache.log4j.Logger;

public class LoggerHandler {

    private static final Logger log = Logger.getLogger(LoggerHandler.class);

    public static void trace(String traceMessage) {
        log.trace(traceMessage);
    }

    public static void debug(String debugMessage) {
        log.debug(debugMessage);
    }

    public static void info(String infoMessage) {
        log.info(infoMessage);
    }

    public static void warn(String warnMessage) {
        log.warn(warnMessage);
    }

    public static void error(String errorMessage) {
        log.error(errorMessage);
    }

    public static void fatal(String fatalMessage) {
        log.fatal(fatalMessage);
    }
}
