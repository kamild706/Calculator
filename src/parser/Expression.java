package parser;

import notation.Notation;

import java.math.BigDecimal;

public interface Expression {

    String toPostfixNotation();
    BigDecimal evaluate();
    String toNotation(Notation notation);
}
