package org.example.exo.infrastructure.logger;

import org.example.exo.domain.enums.Type;
import org.example.exo.domain.interfaces.Logger;

public final class ConsoleLogger implements Logger {

    private ConsoleLogger() {}

    private String message(String text, Type type) {
        if(type == Type.DEBUG) {
            text = "(debug) " + text;
        }

        return text;
    }

    @Override
    public void print(String message, Type type) {
        System.out.print(message(message, type));
    }

    @Override
    public void println(String message, Type type) {
        System.out.println(message(message, type));
    }

    public static ConsoleLogger instantiate() {
        return new ConsoleLogger();
    }

}
