package org.example;


import org.example.logger.ConsoleLogger;
import org.example.logger.Logger;
import org.example.mathematics.Calculator;
import org.example.mathematics.ConsoleCalculator;
import org.example.parser.FileParser;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws IOException, URISyntaxException {
        final FileParser fileParser = new FileParser();
        final Logger logger = new ConsoleLogger();
        final Calculator calculator = new ConsoleCalculator(logger);

        List<String> arguments = Arrays.stream(args).collect(Collectors.toList());
        if(arguments.get(0).equals("calc")){
            List<String> operations = fileParser.fromFileName(arguments.get(1));
            boolean isLog = arguments.get(3).equals("-log");
            calculator.accumulate(operations, isLog);
        }
    }
}
