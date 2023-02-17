package org.example.logger;


import java.time.LocalDateTime;
import java.util.Date;

public final class ConsoleLogger implements Logger {

    public ConsoleLogger() {}

    private String message(String text) {
        text = "["+ LocalDateTime.now() + "] [log] " + text;
        return text;
    }


    @Override
    public void println(String message) {
        System.out.println(message(message));
    }

    public void printOperations(String message) {
        System.out.println(message);
    }

    @Override
    public void printSeparator() {
        System.out.println("--------------");
    }

}
