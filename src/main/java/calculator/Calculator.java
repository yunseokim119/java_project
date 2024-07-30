package calculator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Calculator {
    // 연산 결과를 저장하는 필드

    private final List<Number> arithmeticResults;
    // 레벨2-7 list<Integer> 에서 Number로 변경하여, 정수와 부동 소수점 수 모두 저장할 수 있도록 함
    // static 키워드는 클래스 레벨에서 사용할 수 있는 멤버(변수나 메서드)를 정의할 때 사용
    // final 키워드는 상수 값을 정의하거나, 변경 불가능한 객체를 정의할 때 사용
    // 이렇게 하면 Calculator 클래스의 메서드와 필드가 static으로 선언되어 인스턴스를 생성하지 않고도 접근할 수 있으며, App 클래스에서 직접적으로 호출할 수 있음
    private final List<Double> circleAreaResults;

    // 생성자
    public Calculator() {
        arithmeticResults = new ArrayList<>();
        circleAreaResults = new ArrayList<>();
    }

    // 양의 정수 2개와 연산 기호를 매개변수로 받아 연산을 수행하고 결과 값을 반환하는 메서드
    public int calculate(int num1, int num2, char operator) throws OneException {
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
                    throw new OneException();
                }
                break;
            default:
                throw new OneException();
        }

        // 연산 결과를 리스트에 추가
        arithmeticResults.add(result);

        return result;
    }

    // 반지름을 매개변수로 받아 원의 넓이를 계산하여 반환하는 메서드
    public double calculateCircleArea(double radius) {
        double area = Math.PI * radius * radius;

        // 원의 넓이 결과를 리스트에 추가
        circleAreaResults.add(area);

        return area;
    }

    // 연산 결과의 불변 사본을 반환하는 메서드
    public List<Number> getArithmeticResults() {
        return Collections.unmodifiableList(arithmeticResults);
    }

    public List<Double> getCircleAreaResults() {
        return Collections.unmodifiableList(circleAreaResults);
    }

    // 가장 먼저 저장된 연산 결과를 삭제하는 메서드
    public void removeFirstArithmeticResult() {
        if (!arithmeticResults.isEmpty()) {
            arithmeticResults.remove(0);
        }
    }
    public void removeFirstCircleAreaResult() {
        if (!circleAreaResults.isEmpty()) {
            circleAreaResults.remove(0);
        }
    }
}
