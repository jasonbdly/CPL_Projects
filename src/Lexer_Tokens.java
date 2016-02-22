/*
    AUTHOR: Jason Bradley
    CLASS: CSE3801 - W03
    ASSIGNMENT: Mod 3 - Lua Interpreter
 */
public class Lexer_Tokens {
    //Token ID generator function
    private static int id_counter = 0;
    private static int genId() {
        return id_counter++;
    }

    //====Value Tokens====
    public static final int
        //NULL_TOKEN
        NULL = -1,

        //id => letter, id | letter
        ID = genId(),

        //int => digit, int | digit
        INT_LITERAL = genId();

    //====Operator Tokens====
    public static final int
        //assign => =
        ASSIGN_OP = genId(),

        //less_than => <
        LESSTHAN_OP = genId(),

        //less_than_or_equal => <=
        LESSTHAN_EQ_OP = genId(),

        //greater_than => >
        GREATERTHAN_OP = genId(),

        //greater_than_or_equal => >=
        GREATERTHAN_EQ_OP = genId(),

        //equal => ==
        EQUAL_OP = genId(),

        //not_equal => ~=
        NOT_EQUAL_OP = genId(),

        //add => +
        ADD_OP = genId(),

        //subtract => -
        SUBTRACT_OP = genId(),

        //multiply => *
        MULTIPLY_OP = genId(),

        //divide => /
        DIVIDE_OP = genId();
}
