package parser;

import notation.Notation;

public abstract class UnaryOperation extends Operation {

    private Expression operand;

    public Expression getOperand() {
        return operand;
    }

    public UnaryOperation(Expression operand) {
        this.operand = operand;
    }

    @Override
    public String toNotation(Notation notation) {
        return notation.parse(this);
    }

    @Override
    public String toPostfixNotation() {
        return getOperator() + getOperand().toPostfixNotation();
    }
}
