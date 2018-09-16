package lexer;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class LexerTest {

    private void tokenize(String input, String[] expectedOutput) {
        Lexer lexer = new Lexer(input);
        Token token;

        int index = 0;
        while ((token = lexer.getNextToken()).getType() != TokenType.EOI) {
            assertEquals(token.getValue(), expectedOutput[index++]);
        }
        assertEquals(expectedOutput.length, index);
    }

    @Test
    public void additionTest1() {
        String input = "2+2 + 3";
        String[] expectedOutput = {"2", "+", "2", "+", "3"};
        tokenize(input, expectedOutput);
    }

    @Test
    public void additionTest2() {
        String input = "(1+1)";
        String[] expectedOutput = {"(", "1", "+", "1", ")"};
        tokenize(input, expectedOutput);
    }
}
