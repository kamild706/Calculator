package parser;

import java.math.BigDecimal;

public class Product extends BinaryOperation {

    public Product(Expression leftOperand, Expression rightOperand) {
        super(leftOperand, rightOperand);
    }

    @Override
    public BigDecimal evaluate() {
        return getLeftOperand().evaluate().multiply(getRightOperand().evaluate());
    }

    @Override
    public String getOperator() {
        return "*";
    }
}