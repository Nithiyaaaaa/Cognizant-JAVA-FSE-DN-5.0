class Logger {

    // Private static instance
    private static Logger instance = new Logger();

    // Private constructor
    private Logger() {
        System.out.println("Logger instance created.");
    }

    // Public static method to get the single instance
    public static Logger getInstance() {
        return instance;
    }

    // Logging method
    public void log(String message) {
        System.out.println("LOG: " + message);
    }
}

public class singleton {

    public static void main(String[] args) {

        Logger logger1 = Logger.getInstance();
        logger1.log("Application started.");

        Logger logger2 = Logger.getInstance();
        logger2.log("Processing data.");

        // Verify that only one instance exists
        if (logger1 == logger2) {
            System.out.println("Only one Logger instance exists.");
        } else {
            System.out.println("Multiple Logger instances exist.");
        }
    }
}