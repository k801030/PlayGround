package my.play.ground;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Log4jApp {
    private static Logger LOGGER = LoggerFactory.getLogger(Log4jApp.class);

    public static void main(String[] args) {
        Log4jApp app = new Log4jApp();
        app.print();
    }

    public void print() {
        LOGGER.info("hello, world!");
    }
}
