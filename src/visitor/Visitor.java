package visitor;

import parser.BinaryOperation;
import parser.Constant;
import parser.UnaryOperation;

public interface Visitor {

    String visit(BinaryOperation operation);
    String visit(UnaryOperation operation);
    String visit(Constant constant);
}
