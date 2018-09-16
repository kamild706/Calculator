package parser;


import lexer.Token;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Quotient extends BinaryOperation {

    public Quotient(Expression leftOperand, Token token, Expression rightOperand) {
        super(token.getValue(), leftOperand, rightOperand);
    }

    @Override
    public BigDecimal calc() {
        return getLeftOperand().calc().divide(getRightOperand().calc(), RoundingMode.CEILING);
    }
}
