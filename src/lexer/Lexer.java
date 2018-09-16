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

    private char[] text;
    private Character currentChar;
    private int pos;

    public Lexer(String aText) {
        text = aText.toCharArray();
        pos = 0;
        currentChar = text[pos];
    }

    private void characterError(char aChar) {
        throw new Error("Invalid character: " + aChar);
    }

    private void advance() {
        pos++;
        if (pos > text.length - 1) {
            currentChar = null;
        } else {
            currentChar = text[pos];
        }
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
                    characterError(currentChar);
                } else {
                    sb.append(currentChar);
                    isDecimalSeparatorFound = true;
                }
            } else {
                break;
            }
            advance();
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

            characterError(currentChar);
        }
        return new Token(TokenType.EOI, null);
    }
}
