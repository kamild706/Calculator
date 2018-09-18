package notation;

import parser.BinaryOperation;
import parser.Constant;
import parser.UnaryOperation;

public class PostfixNotation implements Notation {

    @Override
    public String parse(BinaryOperation operation) {
        String left = operation.getLeftOperand().toNotation(this);
        String right = operation.getRightOperand().toNotation(this);
        return left + " " + right + " " + operation.getOperator();
    }

    @Override
    public String parse(UnaryOperation operator) {
        return operator.getOperator() + operator.getOperand().toNotation(this);
    }

    @Override
    public String parse(Constant constant) {
        return constant.getValue().toString();
    }
}
