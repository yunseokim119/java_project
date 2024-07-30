package calculator;

public interface Operator {
    int apply(int num1, int num2) throws OneException;
}
