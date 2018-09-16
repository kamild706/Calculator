package lexer;

public class Token {
    /*public enum Type {
        NUMBER, PLUS, MINUS, TIMES, DIV, POW, L_PARENTHESIS, R_PARENTHESIS, EOI
    }*/

    private TokenType type;
    private String value;

    public TokenType getType() {
        return type;
    }

    public String getValue() {
        return value;
    }


    public Token(TokenType type, String value) {
        this.type = type;
        this.value = value;
    }

    @Override
    public String toString() {
        return "Token{" +
                "type=" + type +
                ", value=" + value +
                '}';
    }
}
