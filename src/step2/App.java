package step2;

import java.util.Scanner; //Scanner 불러오기

public class App {

    public static void main(String[] args) {
        Calculator calc = new Calculator(); // Calculator 생성
        Scanner sc = new Scanner(System.in); // Scanner 객체 생성

        // exit 입력 전까지 무한 반복
        while (true) {
            System.out.print("첫 번째 숫자를 입력하세요: "); // println 대신 print 를 사용해 숫자 입력시 바로 옆에 입력하도록 설정
            String input1 = sc.next();
            if (input1.equals("exit")) break; // exit 입력시 종료
            int num1 = Integer.parseInt(input1); // 문자를 숫자로 변환
            // 양의 정수 입력을 위한 조건
            if (num1 < 0) {
                System.out.println("양의 정수를 입력하세요");
                continue;
            }

            System.out.print("두 번째 숫자를 입력하세요: ");
            String input2 = sc.next();
            int num2 = Integer.parseInt(input2);
            if (num2 < 0) {
                System.out.println("양의 정수를 입력하세요");
                continue;
                        }

            System.out.print("사칙연산 기호를 입력하세요: ");
            char operator = sc.next().charAt(0);

            int result = calc.calculate(num1, num2, operator);

            System.out.println("결과: " + result);

        }
        System.out.println("프로그램을 종료합니다.");
        sc.close();


    }



}