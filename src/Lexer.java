import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collector;

/*
    AUTHOR: Jason Bradley
    CLASS: CSE3801 - W03
    ASSIGNMENT: Mod 3 - Lua Interpreter
 */
public class Lexer {

    private String str;
    private int cursor = 0;
    private int strlength = -1;

    public Lexer(String str) {
        this.str = str;
        strlength = str.length();
    }

    public Token next() {
        int forwardCursor = cursor;
        while (forwardCursor < strlength) {
            int currentType = Lexer_Tokens.NULL;
            char currentChar = str.charAt(forwardCursor);

            //Begin lexical analysis
            if (Character.isWhitespace(currentChar)) {
                //Whitespace character, scan forward until we hit a non-whitespace character to take care of the whole block.
                forwardCursor++;
                while (forwardCursor < strlength && Character.isWhitespace(str.charAt(forwardCursor))) {
                    forwardCursor++;
                }

                //Set the cursor to the next non-whitespace character location.
                //Falls through to the return null if cursor is out of bounds.
                cursor = forwardCursor;
            } else if (Character.isAlphabetic(currentChar)) {
                //Start of ID token
                forwardCursor++;

                //Keep scanning while each character is valid for a variable name.
                while (forwardCursor < strlength && isIDChar(str.charAt(forwardCursor))) {
                    forwardCursor++;
                }

                //Return the matched ID token
                int startCursor = cursor;
                cursor = forwardCursor;
                return new Token(Lexer_Tokens.ID, str.substring(startCursor, forwardCursor - 1));
            } else if (Character.isDigit(currentChar)) {
                //Start of INT_LITERAL token

            } else {

            }
        }

        //If we get this point then we have yet to match a token, so null is returned, signifying the end of the token stream.
        return null;
    }

    public List<Token> lex() {
        List<Token> tokens = new ArrayList<Token>();

        return tokens;
    }

    static class Token {
        int type;
        String value;

        Token(int tokenType, String tokenValue) {
            type = tokenType;
            value = tokenValue;
        }
    }

    private static boolean isAlpha(char c) {
        return Character.isAlphabetic(c);
    }

    private static boolean isDigit(char c) {
        return Character.isDigit(c);
    }

    private static boolean isIDChar(char c) {
        return Character.isAlphabetic(c) || Character.isDigit(c) || c == '_';
    }
}
