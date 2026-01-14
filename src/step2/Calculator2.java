package step2;

import java.util.ArrayList;
import java.util.List;

public class Calculator2 {

    private List<Integer> results = new ArrayList<>();

    public int calculate(int num1, int num2, char operator) {
        int result = 0;

        // 연산 진행
        switch(operator) {
            case '+':
                result = num1 + num2;
                break;

            case '-':
                result = num1 - num2;
                break;

            case '*':
                result = num1 * num2;
                break;

            case '/':
                // 분모가 0인 경우
                if (num2 == 0) {
                    System.out.println("분모에 0이 입력될 수 없습니다.");
                    return 0;
                }
                result = num1 / num2;
                break;
            default:
                System.out.println("올바른 연산 기호를 입력하세요.");
                return 0;
        }

        results.add(result); // 완료된 계산을 저장
        return result;
    }

    public List<Integer> getResults() {
        return results;
    }

    public void setResults(List<Integer>results) {
        this.results = results;
    }
}