package org.example.mathematics;

import org.example.logger.Logger;

import java.util.List;

public class ConsoleCalculator implements Calculator{
    private final Logger logger;

    public ConsoleCalculator(Logger logger) {
        this.logger = logger;
    }



    private int accWithDetailledLog(List<String> values, String operator) {
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
                res = applyOperator(operator, res, raw);
                logger.println("parsed value = "+raw);
                logger.printOperations(operator+value+" (= "+res+")");
                logger.println("accumulation : " + values.get(i) + " on line " + (i+1));
            }
        }
        logger.printSeparator();
        logger.printOperations("Total = "+res);
        logger.println("end of program");
        return res;
    }

    private int acc(List<String> values, String operator) {
        int res = 0;
        for (int i = 0; i < values.size(); i++) {
            String value = values.get(i);
            int raw = Integer.parseInt(value);
            if(i == 0){
                res = raw;
                logger.printOperations(value);

            }else{
                res = applyOperator(operator, res, raw);
                logger.printOperations(operator+value+" (= "+res+")");
            }
        }
        logger.printSeparator();
        logger.printOperations("Total = "+res);
        return res;
    }

    private int applyOperator(String operator, int prev, int next) {
        int res = 0;
           switch (operator) {
               case "-" :
                   res = prev - next;
                   break;
               case "*" :
                   res = prev * next;
                   break;
               case "/" :
                   res = prev / next;
                   break;
               default:
                    res = prev + next;
           };
           return res;
    }

    @Override
    public int accumulate(List<String> values, boolean log, String operator) {
        return log ? accWithDetailledLog(values, operator) : acc(values, operator);
    }
}
