package com.example.calculator;

import java.util.Scanner;

public class App3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double firstNumber;
        double secondNumber;
        double comparingNumber;
        char operation;
        double result;
        String finish;
        boolean run = true;

        ArithmeticCalculator<Number> calculator = new ArithmeticCalculator<>();

        while(run) {
            System.out.print("첫 번째 숫자를 입력하세요: ");
            while (!sc.hasNextDouble()) {
                sc.next();
                System.out.print("잘못 입력하셨습니다. 첫 번째 숫자를 입력하세요: ");
            }
            firstNumber = sc.nextDouble();
            sc.nextLine();

            System.out.print("두 번째 숫자를 입력하세요: ");
            while (!sc.hasNextDouble()) {
                sc.next();
                System.out.print("잘못 입력하셨습니다. 두 번째 숫자를 입력하세요: ");
            }
            secondNumber = sc.nextDouble();
            sc.nextLine();

            System.out.print("사칙연산 기호를 입력하세요: ");
            operation = sc.nextLine().charAt(0);

            try {
                result = calculator.calculate(firstNumber, secondNumber, operation);
            }
            catch(IllegalArgumentException e1) {
                System.out.println(e1.getMessage());
                continue;
            }

            calculator.saveResult(result);

            System.out.println("결과: " + result);

            calculator.printResult();

            System.out.println("더 계산하시겠습니까? (exit 입력 시 종료, remove 입력 시 제일 오래된 결과 기록 삭제, filter 입력 시 결과 값 필터 기능 이행)");

            finish = sc.nextLine();
            if (finish.equals("exit"))
                run = false;
            else if(finish.equals("remove")) {
                calculator.removeResult();
                calculator.printResult();
            } else if(finish.equals("filter")){
                System.out.print("결과 기록 중 입력하신 숫자보다 큰 결과들을 출력합니다 : ");
                while (!sc.hasNextDouble()) {
                    sc.next();
                    System.out.print("잘못 입력하셨습니다. 숫자를 입력하세요: ");
                }
                comparingNumber = sc.nextDouble();
                calculator.printLargerResult(comparingNumber);
            }
        }
    }
}
