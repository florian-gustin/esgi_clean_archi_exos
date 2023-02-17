package org.example.exo.infrastructure.parser;


import org.example.exo.domain.interfaces.Parser;

import java.util.Scanner;

public final class ConsoleParser implements Parser {
    private final Scanner scanner;

    private ConsoleParser(Scanner scanner) {
        this.scanner = scanner;
    }

    @Override
    public String input() {
        return scanner.nextLine();
    }

    public static ConsoleParser instantiate() {
        return new ConsoleParser(new Scanner(System.in));
    }
}


