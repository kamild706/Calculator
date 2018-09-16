package parser;

import visitor.Visitable;

import java.math.BigDecimal;

public abstract class Expression implements Visitable {

    public abstract String toPostfixNotation();
    public abstract BigDecimal calc();
}
