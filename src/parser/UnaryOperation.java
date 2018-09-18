package parser;

import visitor.Visitor;

public abstract class UnaryOperation extends Operation {

    private Expression operand;

    public Expression getOperand() {
        return operand;
    }

    public UnaryOperation(Expression operand) {
        this.operand = operand;
    }

    @Override
    public String apply(Visitor visitor) {
        return visitor.visit(this);
    }

    @Override
    public String toPostfixNotation() {
        return getOperator() + getOperand().toPostfixNotation();
    }
}
