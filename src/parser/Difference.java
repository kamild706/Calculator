package parser;

import java.math.BigDecimal;

public class Difference extends BinaryOperation {

    public Difference(Expression leftOperand, Expression rightOperand) {
        super(leftOperand, rightOperand);
    }

    @Override
    public BigDecimal evaluate() {
        return getLeftOperand().evaluate().subtract(getRightOperand().evaluate());
    }

    @Override
    public String getOperator() {
        return "-";
    }
}
