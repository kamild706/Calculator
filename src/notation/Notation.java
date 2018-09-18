package notation;

import parser.BinaryOperation;
import parser.Constant;
import parser.UnaryOperation;

public interface Notation {

    String parse(BinaryOperation operation);
    String parse(UnaryOperation operation);
    String parse(Constant constant);
}
