package visitor;

import parser.BinaryOperation;
import parser.Constant;
import parser.UnaryOperation;

public class PostfixNotationVisitor implements Visitor {

    @Override
    public String visit(BinaryOperation operation) {
        String left = operation.getLeftOperand().apply(this);
        String right = operation.getRightOperand().apply(this);
        return left + " " + right + " " + operation.getOperator();
    }

    @Override
    public String visit(UnaryOperation operator) {
        return operator.getOperator() + operator.getOperand().apply(this);
    }

    @Override
    public String visit(Constant constant) {
        return constant.getValue().toString();
    }
}
