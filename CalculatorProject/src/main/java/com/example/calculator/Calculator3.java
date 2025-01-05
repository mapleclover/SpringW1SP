package com.example.calculator;

import java.util.Scanner;

public class Calculator3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double firstNumber;
        double secondNumber;
        char operation;
        double result;
        String finish;
        boolean run = true;

        ArithmeticCalculator calculator = new ArithmeticCalculator();

        while(run) {
            System.out.print("첫 번째 숫자를 입력하세요: ");
            while (!sc.hasNextInt()) {
                sc.next();
                System.out.print("잘못 입력하셨습니다. 첫 번째 숫자를 입력하세요: ");
            }
            firstNumber = sc.nextInt();
            sc.nextLine();

            System.out.print("두 번째 숫자를 입력하세요: ");
            while (!sc.hasNextInt()) {
                sc.next();
                System.out.print("잘못 입력하셨습니다. 두 번째 숫자를 입력하세요: ");
            }
            secondNumber = sc.nextInt();
            sc.nextLine();

            System.out.print("사칙연산 기호를 입력하세요: ");
            operation = sc.nextLine().charAt(0);

            result = calculator.calculate(firstNumber, secondNumber, operation);

            if (calculator.errorMsg != null) {
                System.out.println(calculator.errorMsg);
                continue;
            } else {
                calculator.saveResult(result);
            }
            System.out.println("결과: " + result);

            calculator.printResult();

            System.out.println("더 계산하시겠습니까? (exit 입력 시 종료, remove 입력 시 제일 오래된 결과 기록 삭제)");

            finish = sc.nextLine();
            if (finish.equals("exit"))
                run = false;
            else if(finish.equals("remove")) {
                calculator.removeResult();
                calculator.printResult();
            }
        }
    }
}
