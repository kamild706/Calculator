package parser;

import java.math.BigDecimal;

public class Negation extends UnaryOperation {

    public Negation(Expression operand) {
        super(operand);
    }

    @Override
    public BigDecimal evaluate() {
        return getOperand().evaluate().negate();
    }

    @Override
    public String getOperator() {
        return "-";
    }
}
