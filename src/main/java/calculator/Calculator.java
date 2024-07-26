package calculator;

import java.util.ArrayList;
import java.util.List;

public class Calculator {
    // 연산 결과를 저장하는 필드
    private List<Integer> results;

    // 생성자
    public Calculator() {
        results = new ArrayList<>();
    }

    // 양의 정수 2개와 연산 기호를 매개변수로 받아 연산을 수행하고 결과 값을 반환하는 메서드
    public int calculate(int num1, int num2, char operator) {
        int result = 0;

        switch (operator) {
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
                if (num2 != 0) {
                    result = num1 / num2;
                } else {
                    throw new IllegalArgumentException("0으로 나눌 수 없습니다.");
                }
                break;
            default:
                throw new IllegalArgumentException("유효하지 않은 연산자입니다.");
        }

        // 연산 결과를 리스트에 추가
        results.add(result);

        return result;
    }

    // 연산 결과를 반환하는 메서드
    public List<Integer> getResults() {
        return results;
    }
}
