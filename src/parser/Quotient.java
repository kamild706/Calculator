package parser;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Quotient extends BinaryOperation {

    public Quotient(Expression leftOperand, Expression rightOperand) {
        super(leftOperand, rightOperand);
    }

    @Override
    public BigDecimal evaluate() {
        return getLeftOperand().evaluate().divide(getRightOperand().evaluate(), 3, RoundingMode.HALF_EVEN);
    }

    @Override
    public String getOperator() {
        return "/";
    }
}
