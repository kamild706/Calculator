package parser;

import notation.Notation;


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
    public String toNotation(Notation notation) {
        return notation.parse(this);
    }

    @Override
    public String toPostfixNotation() {
        String left = getLeftOperand().toPostfixNotation();
        String right = getRightOperand().toPostfixNotation();
        return left + " " + right + " " + getOperator();
    }
}
