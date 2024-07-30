package calculator;

public class ArithmeticCalculator extends Calculator<Integer> {

    private final Operator addOperator;
    private final Operator subtractOperator;
    private final Operator multiplyOperator;
    private final Operator divideOperator;

    // 생성자에서 연산자 객체를 초기화합니다.
    public ArithmeticCalculator() {
        this.addOperator = new AddOperator();
        this.subtractOperator = new SubtractOperator();
        this.multiplyOperator = new MultiplyOperator();
        this.divideOperator = new DivideOperator();
    }

    // 양의 정수 2개와 연산 기호를 매개변수로 받아 연산을 수행하고 결과 값을 반환하는 메서드
    public int calculate(int num1, int num2, char operator) throws OneException {
        int result;

        switch (operator) {
            case '+':
                result = addOperator.apply(num1, num2);
                break;
            case '-':
                result = subtractOperator.apply(num1, num2);
                break;
            case '*':
                result = multiplyOperator.apply(num1, num2);
                break;
            case '/':
                result = divideOperator.apply(num1, num2);
                break;
            default:
                throw new OneException("유효하지 않은 연산자입니다.");
        }

        // 연산 결과를 리스트에 추가
        addResult(result);

        return result;
    }
}
// 이렇게 하면 각 연산의 책임이 Operator 인터페이스와 이를 구현하는 클래스들로 분리되어,
// ArithmeticCalculator 클래스는 연산 로직을 직접 구현하지 않고 각 연산 클래스에 위임합니다.
// 이는 SOLID 원칙 중 SRP(단일 책임 원칙)를 잘 준수하는 구조입니다.
