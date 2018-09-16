package parser;


import lexer.Token;

import java.math.BigDecimal;

public class Sum extends BinaryOperation {

    public Sum(Expression leftOperand, Token token, Expression rightOperand) {
        super(token.getValue(), leftOperand, rightOperand);
    }

    @Override
    public BigDecimal calc() {
        return getLeftOperand().calc().add(getRightOperand().calc());
    }
}
