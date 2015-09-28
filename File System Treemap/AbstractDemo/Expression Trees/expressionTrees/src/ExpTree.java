/**An instance represents an expression tree. */
public abstract class ExpTree {

    
    /** Return the value of this tree. */
    public abstract int eval();
    
    /** Return the preorder of this tree. */
    public abstract String preorder();

    /** Return the postorder of this tree. */
    public abstract String postorder();

    /** Return the inorder of this tree, with binary ops parenthesized. */
    public abstract String inorder();

}
