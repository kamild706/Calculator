package parser;

import visitor.Visitor;


public abstract class BinaryOperation extends Operation {

    private Expression left;
    private Expression right;

    public Expression getLeftOperand() {
        return left;
    }

    public Expression getRightOperand() {
        return right;
    }

    public BinaryOperation(Expression leftOperand, Expression rightOperand) {
        left = leftOperand;
        right = rightOperand;
    }

    @Override
    public String apply(Visitor visitor) {
        return visitor.visit(this);
    }

    @Override
    public String toPostfixNotation() {
        String left = getLeftOperand().toPostfixNotation();
        String right = getRightOperand().toPostfixNotation();
        return left + " " + right + " " + getOperator();
    }
}
