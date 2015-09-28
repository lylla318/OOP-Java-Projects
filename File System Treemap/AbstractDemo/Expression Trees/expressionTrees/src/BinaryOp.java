/** An instance represents a binary operator + - * / */
public class BinaryOp extends ExpTree {
    private String op; // The operator: * or /
    private ExpTree leftExp; // The left operand
    private ExpTree riteExp; // The right operand

    /** Constructor: an instance with left operand left, operator op,
     *  and and right tree right. */
    public BinaryOp(ExpTree left, String op, ExpTree right) {
        leftExp= left;
        this.op= op;
        riteExp= right;
    }

    /** Return the value of this tree. */
    public @Override int eval() {
        if (op.equals("+"))
            return leftExp.eval() + riteExp.eval();
        if (op.equals("-"))
            return leftExp.eval() - riteExp.eval();
        if (op.equals("*")) 
            return leftExp.eval() * riteExp.eval();
        return leftExp.eval() / riteExp.eval();
    }

    /** Return the preorder version of this expression. */
    public @Override String preorder() {
        return op + " " + leftExp.preorder() + " " + riteExp.preorder();
    }


    /** Return the postorder version of this expression. */
    public @Override String postorder() {
        return leftExp.postorder() + " " + riteExp.postorder() + " " + op;
    }

    /** Return the inorder version of this expression, parenthesized. */
    public @Override String inorder() {
        return "(" + leftExp.inorder() + " " + op + " " + 
                riteExp.inorder() + ")";
    }
}
