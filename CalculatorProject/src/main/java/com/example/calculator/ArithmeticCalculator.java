package com.example.calculator;

import java.util.ArrayList;

public class ArithmeticCalculator<T extends Number> {
    private final ArrayList<T> results = new ArrayList<>();

    public enum OperatorType {
        ADD('+'),
        SUBTRACT('-'),
        MULTIPLY('*'),
        DIVIDE('/');

        //필드
        private final char operatorType;

        //생성자
        OperatorType(char operator) {
            this.operatorType = operator;
        }

        //getter
        public char getOperatorType() {
            return this.operatorType;
        }

        static public OperatorType getTypeFromChar(char operator)
        {
            for(OperatorType ot : values())
            {
                if(ot.getOperatorType() == operator)
                    return ot;
            }
            throw new IllegalArgumentException("연산부호 입력이 잘못되었습니다.");
        }
    }

    public double calculate(T firstNumber, T secondNumber, char operator)
    {
        double num1 = firstNumber.doubleValue();
        double num2 = secondNumber.doubleValue();

        double result;
        OperatorType operatorType = OperatorType.getTypeFromChar(operator);

        switch (operatorType) {
            case ADD:
                result = num1 + num2;
                break;
            case SUBTRACT:
                result = num1 - num2;
                break;
            case MULTIPLY:
                result = num1 * num2;
                break;
            case DIVIDE:
                if (num2 == 0) {
                    throw new IllegalArgumentException("나눗셈 연산에서 분모(두번째 정수)에 0이 입력될 수 없습니다.");
                }
                result = num1 / num2;
                break;
            default:
                throw new IllegalArgumentException("연산부호 입력이  잘못되었습니다.");
        }

        return result;
    }

    public void saveResult(T result)
    {
        results.add(result);
    }

    public void removeResult()
    {
        results.remove(0);
    }

    public void printResult() {
        if (results.isEmpty()) {
            System.out.print("계산 기록이 없습니다.");
        } else {
            System.out.print("지금까지의 계산 결과: ");
            for (T res : results) {
                System.out.print(res + "  ");
            }
            System.out.println();
        }
    }

    public void printLargerResult(T inputValue)
    {
        if (results.isEmpty()) {
            System.out.print("계산 기록이 없습니다.");
            return;
        }

        for (T res : results)
        {
            if(res.doubleValue() > inputValue.doubleValue())
                break;
        }
        System.out.print(inputValue +" 보다 큰 계산 결과: ");

        results.stream()
            .filter(num -> num.doubleValue() > inputValue.doubleValue())
            .forEach(num -> System.out.print(num + "  "));

        System.out.println();
    }
}
