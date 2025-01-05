package com.example.calculator;

import java.util.ArrayList;

public class ArithmeticCalculator {
    // 연산자 타입을 Enum으로 정의
    public enum OperatorType {
        ADD(),
        SUBTRACT(),
        MULTIPLY(),
        DIVIDE();
    }

    private ArrayList<Double> results = new ArrayList<>();
    public String errorMsg;

    public double calculate(double fn, double sn, char op)
    {
        double result = 0;
        errorMsg = null;

        switch (op) {
            case '+':
                result = fn + sn;
                break;
            case '-':
                result = fn - sn;
                break;
            case '*':
                result = fn * sn;
                break;
            case '/':
                if (sn == 0) {
                    errorMsg = "나눗셈 연산에서 분모(두번째 정수)에 0이 입력될 수 없습니다.";
                    break;
                }
                result = fn / sn;
                break;
            default:
                errorMsg = "연산부호 입력이  잘못되었습니다.";
                break;
        }

        return result;
    }

    public void saveResult(double result)
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
            for (double res : results) {
                System.out.print(res + "  ");
            }
            System.out.println();
        }
    }

    public void printLargerResult(double value)
    {
        if (results.isEmpty()) {
            System.out.print("계산 기록이 없습니다.");
            return;
        }

        for (double res : results)
        {
            if(res > value)
                break;
        }
        System.out.print(value +" 보다 큰 계산 결과: ");
        for (double res : results) {
            if(res > value)
                System.out.print(res + "  ");
        }
        System.out.println();

    }
}
