package com.serenitydojo.calculator;

import java.util.List;

public class Calculator {
    public int evaluate(String expression) {
        int result = 0;
        if (expression.length() > 1) {
            List<String> ExpressionList = List.of(expression.split(" "));
            for (int i = 0; i < ExpressionList.size(); ) {
                if (i != 0) {
                    String operation = ExpressionList.get(i);
                    int value2 = Integer.parseInt(ExpressionList.get(i + 1));
                    switch (operation) {
                        case "+":
                            result += value2;
                            break;
                        case "-":
                            result = result - value2;
                            break;
                        case "*":
                            result = result * value2;
                            break;
                        default:
                            throw new IllegalMathsOperatorException("Unsupported operation");
                    }
                    i = i + 2;
                } else {
                    int value1 = Integer.parseInt(ExpressionList.get(i));
                    String operation = ExpressionList.get(i + 1);
                    int value2 = Integer.parseInt(ExpressionList.get(i + 2));
                    switch (operation) {
                        case "+":
                            result += value1 + value2;
                            break;
                        case "-":
                            result += value1 - value2;
                            break;
                        case "*":
                            result += value1 * value2;
                            break;
                        default:
                            throw new IllegalMathsOperatorException("Unsupported operation");
                    }
                    i = i + 3;
                }
            }
        } else if (expression.length() == 0) {
            return 0;
        } else {
            return Integer.parseInt(expression);
        }
        return result;
    }
}
