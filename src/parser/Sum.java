package parser;

import java.math.BigDecimal;

public class Sum extends BinaryOperation {

    public Sum(Expression leftOperand, Expression rightOperand) {
        super(leftOperand, rightOperand);
    }

    @Override
    public BigDecimal evaluate() {
        return getLeftOperand().evaluate().add(getRightOperand().evaluate());
    }

    @Override
    public String getOperator() {
        return "+";
    }
}
