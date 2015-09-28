import static org.junit.Assert.*;

import org.junit.Test;


public class ExpTreeTester {

    @Test
    public void testIntLeaf() {
        IntLeaf t= new IntLeaf(-30);
        assertEquals(-30, t.eval());
        
        assertEquals("-30", t.preorder());
        assertEquals("-30", t.postorder());
        assertEquals("-30", t.inorder());
    }
    
    @Test
    public void testUnaryOp() {
        ExpTree leaf5= new IntLeaf(5);
        ExpTree leaf6= new IntLeaf(6);
        ExpTree t1= new UnaryOp("+", leaf5);
        ExpTree t2= new UnaryOp("-", leaf6);
        
        assertEquals(5, t1.eval());
        assertEquals("+ 5", t1.preorder());
        assertEquals("5 +", t1.postorder());
        assertEquals("+ 5", t1.inorder());
        

        assertEquals(-6, t2.eval());
        assertEquals("- 6", t2.preorder());
        assertEquals("6 -", t2.postorder());
        assertEquals("- 6", t2.inorder());
        
        ExpTree t3= new UnaryOp("+", t2);
        assertEquals(-6, t3.eval());
        assertEquals("+ - 6", t3.preorder());
        assertEquals("6 - +", t3.postorder());
        assertEquals("+ - 6", t3.inorder());
    }
    
    @Test
    public void testBinaryOp() {
        ExpTree leaf5= new IntLeaf(5);
        ExpTree leaf6= new IntLeaf(6);
        ExpTree leaf7= new IntLeaf(7);
        ExpTree leaf8= new IntLeaf(8);
        ExpTree t1= new BinaryOp(leaf6, "+", leaf5);
        ExpTree t2= new UnaryOp("-", leaf8);
        ExpTree t3= new BinaryOp(t2, "*", t1);
        
        assertEquals(-88, t3.eval());
        assertEquals("* - 8 + 6 5", t3.preorder());
        assertEquals("8 - 6 5 + *", t3.postorder());
        assertEquals("(- 8 * (6 + 5))", t3.inorder());
    }
    
    @Test
    public void testBinaryOpAgain() {
        ExpTree leaf2= new IntLeaf(2);
        ExpTree leaf3= new IntLeaf(3);
        ExpTree leaf1= new IntLeaf(1);
        ExpTree leaf4= new IntLeaf(4);
        ExpTree t1= new BinaryOp(leaf2, "+", leaf3);
        ExpTree t2= new UnaryOp("-", leaf4);
        ExpTree t3= new BinaryOp(leaf1, "+", t2);
        ExpTree t4= new BinaryOp(t1, "*", t3);
        
        assertEquals(-15, t4.eval());
        assertEquals("* + 2 3 + 1 - 4", t4.preorder());
        assertEquals("2 3 + 1 4 - + *", t4.postorder());
        assertEquals("((2 + 3) * (1 + - 4))", t4.inorder());
    }


}
