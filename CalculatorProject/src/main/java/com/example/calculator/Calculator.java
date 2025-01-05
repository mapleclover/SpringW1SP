package com.example.calculator;

import java.util.Scanner;

public class Calculator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int firstNumber;
        int secondNumber;
        char operation;
        int result = 0;
        String finish;
        boolean run = true;
        boolean incorrectInput = true;

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
            while (incorrectInput) {
                operation = sc.nextLine().charAt(0);

                switch (operation) {
                    case '+':
                        result = firstNumber + secondNumber;
                        incorrectInput = false;
                        break;
                    case '-':
                        result = firstNumber - secondNumber;
                        incorrectInput = false;
                        break;
                    case '*':
                        result = firstNumber * secondNumber;
                        incorrectInput = false;
                        break;
                    case '/':
                        if (secondNumber == 0) {
                            System.out.println("나눗셈 연산에서 분모(두번째 정수)에 0이 입력될 수 없습니다.");
                            System.out.print("사칙연산 기호를 입력하세요: ");
                            continue;
                        }
                        result = firstNumber / secondNumber;
                        incorrectInput = false;
                        break;
                    default:
                        System.out.print("연산부호 입력이  잘못되었습니다. 다시 입력하세요: ");
                        break;
                }
            }
            System.out.println("결과: " + result);

            System.out.println("더 계산하시겠습니까? (exit 입력 시 종료)");
            finish = sc.nextLine();
            if (finish.equals("exit"))
                run = false;
        }
    }
}