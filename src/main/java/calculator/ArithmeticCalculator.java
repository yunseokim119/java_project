package calculator;

import java.util.HashMap;
import java.util.Map;

public class ArithmeticCalculator extends Calculator<Integer> {

    private final Map<Character, Operator> operators;

    // 생성자에서 연산자 객체를 초기화합니다.
    public ArithmeticCalculator() {
        operators = new HashMap<>();
        operators.put('+', new AddOperator());
        operators.put('-', new SubtractOperator());
        operators.put('*', new MultiplyOperator());
        operators.put('/', new DivideOperator());
        operators.put('%', new ModOperator());
    }

    // 양의 정수 2개와 연산 기호를 매개변수로 받아 연산을 수행하고 결과 값을 반환하는 메서드
    public int calculate(int num1, int num2, char operator) throws OneException {
        Operator op = operators.get(operator);
        if (op == null) {
            throw new OneException("값이 비어있습니다.");
        }

        int result = op.apply(num1, num2);

        // 연산 결과를 리스트에 추가
        addResult(result);

        return result;
    }
}

// 이렇게 하면 각 연산의 책임이 Operator 인터페이스와 이를 구현하는 클래스들로 분리되어,
// ArithmeticCalculator 클래스는 연산 로직을 직접 구현하지 않고 각 연산 클래스에 위임합니다.
// 이는 SOLID 원칙 중 SRP(단일 책임 원칙)를 잘 준수하는 구조입니다.
