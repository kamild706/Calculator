package parser;

import java.math.BigDecimal;

public class Power extends BinaryOperation {

    public Power(Expression leftOperand, Expression rightOperand) {
        super(leftOperand, rightOperand);
    }

    @Override
    public BigDecimal evaluate() {
        double base = getLeftOperand().evaluate().doubleValue();
        double exp = getRightOperand().evaluate().doubleValue();
        return BigDecimal.valueOf(Math.exp(Math.log(base) * exp));
    }

    @Override
    public String getOperator() {
        return "^";
    }

    private boolean isIntegerValue(BigDecimal bd) {
        return bd.signum() == 0 || bd.scale() <= 0 || bd.stripTrailingZeros().scale() <= 0;
    }
}
