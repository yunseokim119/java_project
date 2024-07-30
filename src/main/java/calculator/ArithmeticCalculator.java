package calculator;

public class ArithmeticCalculator extends Calculator<Integer> {

    // 양의 정수 2개와 연산 기호를 매개변수로 받아 연산을 수행하고 결과 값을 반환하는 메서드
    public int calculate(int num1, int num2, char operator) throws OneException {
        OperatorType operatorType = OperatorType.fromSymbol(operator);
        Operator op = operatorType.getOperator();

        int result = op.apply(num1, num2);

        // 연산 결과를 리스트에 추가
        addResult(result);

        return result;
    }
}