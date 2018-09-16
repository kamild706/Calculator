package parser;

import lexer.Token;
import visitor.Visitor;

import java.math.BigDecimal;

public class Constant extends Expression {

    private BigDecimal value;

    public BigDecimal getValue() {
        return value;
    }

    public Constant(Token token) {
        this.value = new BigDecimal(token.getValue());
    }

    public String apply(Visitor visitor) {
        return visitor.visit(this);
    }

    @Override
    public String toPostfixNotation() {
        return value.toString();
    }

    @Override
    public BigDecimal calc() {
        return value;
    }
}
