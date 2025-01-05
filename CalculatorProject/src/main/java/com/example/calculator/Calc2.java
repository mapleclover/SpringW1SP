package com.example.calculator;

import java.util.ArrayList;

public class Calc2 {
    private ArrayList<Integer> results = new ArrayList<>();

    public int calculate(int fn, int sn, char op)
    {
        int result;

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
                    throw new IllegalArgumentException("나눗셈 연산에서 분모(두번째 정수)에 0이 입력될 수 없습니다.");
                }
                result = fn / sn;
                break;
            default:
                throw new IllegalArgumentException("연산부호 입력이  잘못되었습니다.");
        }

        return result;
    }

    public void saveResult(int result)
    {
        results.add(result);
    }

    public void removeResult()
    {
        if(!results.isEmpty())
            results.remove(0);
    }

    public void printResult() {
        if (results.isEmpty()) {
            System.out.print("계산 기록이 없습니다.");
        } else {
            System.out.print("지금까지의 계산 결과: ");
            for (int res : results) {
                System.out.print(res + "  ");
            }
            System.out.println();
        }
    }

    public ArrayList<Integer> getResults(){
        return new ArrayList<>(results);
    }

    public void setResults(ArrayList<Integer> results) {
        this.results = results;
    }
}