package step2;

import java.util.Scanner; //Scanner 불러오기
import java.util.ArrayList;

public class App2 {

    public static void main(String[] args) {
        Calculator2 calc = new Calculator2(); // Calculator 생성
        Scanner sc = new Scanner(System.in); // Scanner 객체 생성

        // exit 입력 전까지 무한 반복
        while (true) {
            System.out.print("첫 번째 숫자를 입력하세요: "); // println 대신 print 를 사용해 숫자 입력시 바로 옆에 입력하도록 설정
            String input1 = sc.next();
            if (input1.equals("exit")) break;

            int num1 = 0; // 변수를 try-catch 밖에서 미리 생성해서 연산중 오류가 발생하지 않게 하기!
            try {
                num1 = Integer.parseInt(input1); // 문자를 숫자로 변환(abc나 !@#의 경우는 컴퓨터가 숫자로 못 바꿈)
                if (num1 < 0) { // 양의 정수 입력을 위한 조건
                    System.out.println("양의 정수를 입력하세요");
                    continue; // 양수가 아니면 재시작
                }
            } catch (NumberFormatException e) {
                System.out.println("숫자를 입력하세요");
                continue; // 숫자가 아니면 재시작
            }

            System.out.print("사칙연산 기호를 입력하세요: ");
            char operator = sc.next().charAt(0);

            if (operator != '+' && operator != '-' && operator != '*' && operator != '/') {
                System.out.println("사칙연산 기호가 아닙니다 (+, -, *, / 중 하나를 입력하세요)");
                continue;
            }

            System.out.print("두 번째 숫자를 입력하세요: ");
            String input2 = sc.next();
            if (input2.equals("exit")) break;
            int num2 = 0;
            try {
                num2 = Integer.parseInt(input2); // 문자를 숫자로 변환(abc나 !@#의 경우는 컴퓨터가 숫자로 못 바꿈)
                if (num2 < 0) { // 양의 정수 입력을 위한 조건
                    System.out.println("양의 정수를 입력하세요");
                    continue; // 양수가 아니면 재시작
                }
            } catch (NumberFormatException e) {
                System.out.println("숫자를 입력하세요");
                continue; // 숫자가 아니면 재시작
            }


            int result = calc.calculate(num1, num2, operator);
            System.out.println("결과: " + result);

            System.out.println("연산 기록: " + calc.getResults()); // 간접접근으로 기록 가져오기

            System.out.print("가장 오래된 기록을 삭제하겠습니까? (remove 입력 시 삭제)");
            String command = sc.next();

            if(command.equals("remove")) {
                calc.removeResult(); // 삭제하기
            }
            System.out.println("더 계산하시겠습니까? (exit 입력 시 종료)");
            String exitCheck = sc.next();
            if (exitCheck.equals("exit")) {
                break;
            }


        }

        calc.setResults(new ArrayList<>());
        System.out.println("프로그램을 종료합니다.");
        sc.close();


    }

}