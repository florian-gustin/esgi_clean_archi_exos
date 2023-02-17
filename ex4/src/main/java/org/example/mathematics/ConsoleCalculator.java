package org.example.mathematics;

import org.example.logger.Logger;

import java.util.List;

public class ConsoleCalculator implements Calculator{
    private final Logger logger;

    public ConsoleCalculator(Logger logger) {
        this.logger = logger;
    }


    public int accumulate(List<String> values, boolean log) {
        return log ? accWithDetailledLog(values) : acc(values);
    }

    private int accWithDetailledLog(List<String> values) {
        int res = 0;
        for (int i = 0; i < values.size(); i++) {
            String value = values.get(i);
            int raw = Integer.parseInt(value);
            if(i == 0){
                res = raw;
                logger.println("started");
                logger.println("applying operation addition");
                logger.println("parsed value = "+raw);
                logger.printOperations(value);
                logger.println("accumulation : " + values.get(i) + " on line " + (i+1));
            }else{
                res += raw;
                logger.println("parsed value = "+raw);
                logger.printOperations("+"+value+" (= "+res+")");
                logger.println("accumulation : " + values.get(i) + " on line " + (i+1));
            }
        }
        logger.printSeparator();
        logger.printOperations("Total = "+res);
        logger.println("end of program");
        return res;
    }

    private int acc(List<String> values) {
        int res = 0;
        for (int i = 0; i < values.size(); i++) {
            String value = values.get(i);
            int raw = Integer.parseInt(value);
            if(i == 0){
                res = raw;
                logger.printOperations(value);

            }else{
                res += raw;
                logger.printOperations("+"+value+" (= "+res+")");
            }
        }
        logger.printSeparator();
        logger.printOperations("Total = "+res);
        return res;
    }

}
