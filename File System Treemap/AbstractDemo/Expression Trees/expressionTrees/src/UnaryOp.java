/** An instance represents a unary op - e or +e. */
public class UnaryOp extends ExpTree {
private String op; // The operator: + or -
private ExpTree exp; // The (right) operands
    
    /** Constructor: an instance with operator op and right tree e. */
    public UnaryOp(String op, ExpTree e) {
        this.op= op;
        exp= e;
    }
    
    /** Return the value of this tree. */
    public @Override int eval() {
        if (op.equals("+")) {
            return exp.eval();
        }
        return - exp.eval();
    }

    /** Return the preorder version of this expression. */
    public @Override String preorder() {
        return op + " " + exp.preorder();
    }

    
    /** Return the postorder version of this expression. */
    public @Override String postorder() {
        return exp.postorder() + " " + op;
    }

    /** Return the inorder version of this expression. */
    public @Override String inorder() {
        return op + " " + exp.inorder();
    }
}
