/** An expression tree that is a leaf containing an integer. */
public class IntLeaf extends ExpTree {
    private int v; /// The value of this leaf
    
    /** Constructor: an instance with value v. */
    public IntLeaf(int v) {
        this.v= v;
    }
    
    /** Return the value of this tree --its integer. */
    public @Override int eval() {
        return v;
    }

    /** Return the value of this leaf as a string. */
    public @Override String preorder() {
        return "" + v;
    }

    
    /** Return the value of this leaf as a string. */
    public @Override String postorder() {
        return "" + v;
    }

    /** Return the value of this leaf as a string. */
    public @Override String inorder() {
        return "" + v;
    }
    

}
