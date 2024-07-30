package calculator;

public enum OperatorType {
    ADD('+', new AddOperator()),
    SUBTRACT('-', new SubtractOperator()),
    MULTIPLY('*', new MultiplyOperator()),
    DIVIDE('/', new DivideOperator()),
    MOD('%', new ModOperator());

    private final char symbol;
    private final Operator operator;

    OperatorType(char symbol, Operator operator) {
        this.symbol = symbol;
        this.operator = operator;
    }

    public char getSymbol() {
        return symbol;
    }

    public Operator getOperator() {
        return operator;
    }

    public static OperatorType fromSymbol(char symbol) throws OneException {
        for (OperatorType type : values()) {
            if (type.symbol == symbol) {
                return type;
            }
        }
        throw new OneException("유효하지 않은 연산자입니다.");
    }
}