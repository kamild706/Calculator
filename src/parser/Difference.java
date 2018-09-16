package parser;


import lexer.Token;

import java.math.BigDecimal;

public class Difference extends BinaryOperation {

    public Difference(Expression leftOperand, Token token, Expression rightOperand) {
        super(token.getValue(), leftOperand, rightOperand);
    }

    @Override
    public BigDecimal calc() {
        return getLeftOperand().calc().subtract(getRightOperand().calc());
    }
}
