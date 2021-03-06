import lexer.Lexer;
import parser.*;
import notation.PostfixNotation;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.print("calc> ");
            String line = scanner.nextLine();
            Lexer lexer = new Lexer(line);
            Parser parser = new Parser(lexer);
            Expression expr = parser.parse();
            System.out.println(expr.toNotation(new PostfixNotation()));
//            System.out.println(expr.toPostfixNotation());
//            System.out.println(expr.evaluate());
        }
    }
}
