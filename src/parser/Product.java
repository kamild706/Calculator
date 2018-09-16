package parser;


import lexer.Token;

import java.math.BigDecimal;

public class Product extends BinaryOperation {

    public Product(Expression leftOperand, Token token, Expression rightOperand) {
        super(token.getValue(), leftOperand, rightOperand);
    }

    @Override
    public BigDecimal calc() {
        return getLeftOperand().calc().multiply(getRightOperand().calc());
    }
}
