package parser;

import lexer.Lexer;
import lexer.Token;
import lexer.TokenType;

public class Parser {

    private Lexer lexer;
    private Token currentToken;

    public Parser(Lexer aLexer) {
        lexer = aLexer;
        currentToken = lexer.getNextToken();
    }

    private void syntaxError() {
        throw new Error("Syntax error");
    }

    private void consume(TokenType type) {
        if (currentToken.getType() == type) {
            currentToken = lexer.getNextToken();
        } else {
            syntaxError();
        }
    }

    private Expression factor() {
        if (currentToken.getType() == TokenType.NUMBER) {
            Token token = currentToken;
            consume(TokenType.NUMBER);
            return new Constant(token);
        } else if (currentToken.getType() == TokenType.LEFT_PARENTHESIS) {
            consume(TokenType.LEFT_PARENTHESIS);
            Expression node = expression();
            consume(TokenType.RIGHT_PARENTHESIS);
            return node;
        }
        syntaxError();
        return null;
    }

    private Expression power() {
        if (currentToken.getType() == TokenType.MINUS) {
            consume(TokenType.MINUS);
            Expression node = power();
            while (currentToken.getType() == TokenType.POW) {
                Token token = currentToken;
                consume(TokenType.POW);
                node = new Power(node, token, power());
            }
            return new Negation(node);
        } else {
            Expression node = factor();
            while (currentToken.getType() == TokenType.POW) {
                Token token = currentToken;
                consume(TokenType.POW);
                node = new Power(node, token, power());
            }
            return node;
        }
    }

    private Expression term() {
        Expression node = power();

        while (currentToken.getType() == TokenType.TIMES || currentToken.getType() == TokenType.DIV) {
            Token token = currentToken;
            consume(currentToken.getType());
            if (token.getType() == TokenType.TIMES) {
                node = new Product(node, token, power());
            } else {
                node = new Quotient(node, token, power());
            }
        }

        return node;
    }

    private Expression expression() {
        Expression node = term();

        while (currentToken.getType() == TokenType.PLUS || currentToken.getType() == TokenType.MINUS) {
            Token token = currentToken;
            consume(currentToken.getType());
            if (token.getType() == TokenType.PLUS) {
                node = new Sum(node, token, term());
            } else {
                node = new Difference(node, token, term());
            }
        }

        return node;
    }

    public Expression parse() {
        Expression node = expression();
        if (currentToken.getType() != TokenType.EOI) {
            syntaxError();
        }
        return node;
    }
}
