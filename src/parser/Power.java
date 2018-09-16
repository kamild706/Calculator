package parser;


import lexer.Token;

import java.math.BigDecimal;

public class Power extends BinaryOperation {

    public Power(Expression leftOperand, Token token, Expression rightOperand) {
        super(token.getValue(), leftOperand, rightOperand);
    }

    @Override
    public BigDecimal calc() {
        double base = Double.parseDouble(getLeftOperand().calc().toString());
        double exp = Double.parseDouble(getRightOperand().calc().toString());

        return BigDecimal.valueOf(Math.exp(Math.log(base) * exp));
    }
}
