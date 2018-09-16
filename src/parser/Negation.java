package parser;


import java.math.BigDecimal;

public class Negation extends UnaryOperation {

    public Negation(Expression operand) {
        super(operand, "-");
    }

    @Override
    public BigDecimal calc() {
        return getOperand().calc().negate();
    }
}
