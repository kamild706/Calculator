package lexer;

public class Lexer {

    private static final char DECIMAL_SEPARATOR = '.';
    private static final char PLUS = '+';
    private static final char MINUS = '-';
    private static final char TIMES = '*';
    private static final char DIV = '/';
    private static final char POW = '^';
    private static final char LEFT_PARENTHESIS = '(';
    private static final char RIGHT_PARENTHESIS = ')';

    private char[] input;
    private Character currentChar;
    private int index;

    public Lexer(String input) {
        this.input = input.toCharArray();
        index = 0;
        currentChar = this.input[index];
    }

    private void advance() {
        index++;
        currentChar = index < input.length ? input[index] : null;
    }

    private void skipWhitespace() {
        while (currentChar != null && Character.isSpaceChar(currentChar)) {
            advance();
        }
    }

    private String recognizeRationalNumber() {
        StringBuilder sb = new StringBuilder();
        boolean isDecimalSeparatorFound = false;

        while (currentChar != null) {
            if (Character.isDigit(currentChar)) {
                sb.append(currentChar);
            } else if (currentChar.equals(DECIMAL_SEPARATOR)) {
                if (isDecimalSeparatorFound) {
                    throw new InvalidCharacterException(currentChar);
                } else {
                    sb.append(currentChar);
                    isDecimalSeparatorFound = true;
                }
            } else {
                break;
            }
            advance();
        }

        String number = sb.toString();
        if (number.endsWith(String.valueOf(DECIMAL_SEPARATOR))) {
            throw new InvalidCharacterException(DECIMAL_SEPARATOR);
        }

        return sb.toString();
    }

    public Token getNextToken() {
        while (currentChar != null) {
            if (Character.isSpaceChar(currentChar)) {
                skipWhitespace();
                continue;
            }
            if (Character.isDigit(currentChar)) {
                return new Token(TokenType.NUMBER, recognizeRationalNumber());
            }

            Token token = null;
            if (currentChar.equals(PLUS)) {
                token = new Token(TokenType.PLUS, String.valueOf(PLUS));
            }
            if (currentChar.equals(MINUS)) {
                token = new Token(TokenType.MINUS, String.valueOf(MINUS));
            }
            if (currentChar.equals(TIMES)) {
                token = new Token(TokenType.TIMES, String.valueOf(TIMES));
            }
            if (currentChar.equals(DIV)) {
                token = new Token(TokenType.DIV, String.valueOf(DIV));
            }
            if (currentChar.equals(POW)) {
                token = new Token(TokenType.POW, String.valueOf(POW));
            }
            if (currentChar.equals(LEFT_PARENTHESIS)) {
                token = new Token(TokenType.LEFT_PARENTHESIS, String.valueOf(LEFT_PARENTHESIS));
            }
            if (currentChar.equals(RIGHT_PARENTHESIS)) {
                token = new Token(TokenType.RIGHT_PARENTHESIS, String.valueOf(RIGHT_PARENTHESIS));
            }

            if (token != null) {
                advance();
                return token;
            }

            throw new InvalidCharacterException(currentChar);
        }
        return new Token(TokenType.EOI, null);
    }
}
