package parser;

import lexer.Token;
import notation.Notation;

import java.math.BigDecimal;

public class Constant implements Expression {

    private BigDecimal value;

    public BigDecimal getValue() {
        return value;
    }

    public Constant(Token token) {
        this.value = new BigDecimal(token.getValue());
    }

    @Override
    public String toNotation(Notation notation) {
        return notation.parse(this);
    }

    @Override
    public String toPostfixNotation() {
        return value.toString();
    }

    @Override
    public BigDecimal evaluate() {
        return value;
    }
}
