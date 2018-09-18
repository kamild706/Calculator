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
    public void expressionTest1() {
        tokenize("2+2 + 3", new String[]{"2", "+", "2", "+", "3"});
    }

    @Test
    public void expressionTest2() {
        tokenize("(1+1)", new String[]{"(", "1", "+", "1", ")"});
    }

    @Test
    public void expressionTest3() {
        tokenize("2 *2", new String[]{"2", "*", "2"});
    }

    @Test
    public void expressionTest4() {
        tokenize("3 * 1 + 6.54", new String[]{"3", "*", "1", "+", "6.54"});
    }

    @Test
    public void expressionTest5() {
        tokenize("(4+3 * 1.54) * (5.65 + 3)",
                new String[]{"(", "4", "+", "3", "*", "1.54", ")", "*", "(", "5.65", "+", "3", ")"});
    }

    @Test
    public void expressionTest6() {
        tokenize("1-65.7", new String[]{"1", "-", "65.7"});
    }

    @Test
    public void expressionTest7() {
        tokenize("(5-54 - 12.54) * 45", new String[]{"(", "5", "-", "54", "-", "12.54", ")", "*", "45"});
    }

    @Test
    public void expressionTest8() {
        tokenize("54 / 8 /34 * 2", new String[]{"54", "/", "8", "/", "34", "*", "2"});
    }

    @Test
    public void expressionTest9() {
        tokenize("54 / (12 + 4 - 54 * 54 / (54 - 23.43))",
                new String[]{
                        "54", "/", "(", "12", "+", "4", "-", "54", "*", "54", "/", "(", "54", "-", "23.43", ")", ")"
        });
    }

    @Test
    public void expressionTest10() {
        tokenize("54 ^ 23 ^ 543.65", new String[]{"54", "^", "23", "^", "543.65"});
    }

    @Test
    public void expressionTest11() {
        tokenize("12 * (13 ^ 67.2) ^ 34.3 / 4",
                new String[]{"12", "*", "(", "13", "^", "67.2", ")", "^", "34.3", "/", "4"});
    }

    @Test
    public void expressionTest12() {
        tokenize("-2", new String[]{"-", "2"});
    }

    @Test
    public void expressionTest13() {
        tokenize("-54 * 45 / 34.6 * (12 ^ (-34 * 3) + 3 )",
                new String[]{
                "-", "54", "*", "45", "/", "34.6", "*", "(", "12", "^", "(", "-", "34", "*", "3", ")", "+", "3", ")"
        });
    }

    @Test(expected = InvalidCharacterException.class)
    public void expressionTest14() {
        tokenize("54. 65", new String[]{"54.65"});
    }
}
