package calculator;

public class ModOperator implements Operator {
    @Override
    public int apply(int num1, int num2) throws OneException {
        if (num2 == 0) {
            throw new OneException("0으로 나눌 수 없습니다");
        }
        return num1 % num2;
    }
}
