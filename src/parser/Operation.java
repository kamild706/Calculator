package parser;

public abstract class Operation extends Expression {
    private String operator;

    public String getOperator() {
        return operator;
    }

    public Operation(String operator) {
        this.operator = operator;
    }
}
