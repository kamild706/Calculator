package lexer;

public class InvalidCharacterException extends RuntimeException {

    public InvalidCharacterException(char value) {
        super("\"" + value + "\"");
    }
}
