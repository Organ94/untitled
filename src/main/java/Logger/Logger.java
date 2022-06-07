package Logger;

import Interfaces.IStorage;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Logger {

    private int num = 1;
    private DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm:ss");
    private static Logger logger;
    protected IStorage storage;

    public Logger(IStorage storage) {
        this.storage = storage;
    }

    public void log(String msg) {
        String message = "[" + LocalDateTime.now().format(formatter) + " " + num++ + "] " + msg;
        System.out.println(message);
//        System.out.println("[" + LocalDateTime.now().format(formatter) + " " + num++ + "] " + msg);
        storage.append(message);
    }

    public static Logger getInstance() {
        if (logger == null) logger = new Logger(logger.storage);
        return logger;
    }
}
