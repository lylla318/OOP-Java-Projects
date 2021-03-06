import java.util.ArrayList;
import java.util.Iterator;

/**
 * An instance is a non-empty collection of points organized in a hierarchical
 * binary tree structure.
 */
public class BlockTree {
	private BoundingBox box; // bounding box of the blocks contained in this
								// tree.

	private int numBlocks; // Number of blocks in this tree.

	private BlockTree left; // left subtree --null iff this is a leaf

	private BlockTree right; // right subtree --null iff this is a leaf

	private Block block; // The block of a leaf node --null if not a leaf

	// REMARK:
	// Leaf node: left, right == null && block != null
	// Intermediate node: left, right != null && block == null

	/**
	 * Constructor: a binary tree containing blocks. Precondition: blocks is
	 * nonempty, i.e. it contain at least one block.
	 */
	public BlockTree(ArrayList<Block> blocks) {
		// Leave the following two "if" statements as they are.
		if (blocks == null)
			throw new IllegalArgumentException("blocks null");
		if (blocks.size() == 0)
			throw new IllegalArgumentException("no blocks");

		// TODO: implement me.

		if (blocks.size() == 1) {
			block = blocks.get(0);
			Iterator<Block> itr = blocks.iterator();
			this.box = BoundingBox.findBBox(itr);
			this.numBlocks = blocks.size();
			this.left = null;
			this.right = null;
		}

		else {
			Iterator<Block> itr = blocks.iterator();
			this.box = BoundingBox.findBBox(itr);
			this.numBlocks = blocks.size();
			this.block = null;

			ArrayList<Block> ListBox1 = new ArrayList<Block>();
			ArrayList<Block> ListBox2 = new ArrayList<Block>();

			for (Block b : blocks) {
				if (this.box.getLength() == this.box.getWidth()) {
					if (b.getBBox().getCenter().x <= this.box.getCenter().x) {
						ListBox1.add(b);
					} else {
						ListBox2.add(b);
					}
				} else {
					if (b.getBBox().getCenter().y <= this.box.getCenter().y) {
						ListBox1.add(b);
					} else {
						ListBox2.add(b);
					}
				}
			}

			if (ListBox1.size() >= 1) {
				this.left = new BlockTree(ListBox1);
			}
			if (ListBox2.size() >= 1) {
				this.right = new BlockTree(ListBox2);
			}

		}

	}

	/** Return the bounding box of the collection of blocks. */
	public BoundingBox getBox() {
		return box;
	}

	/** Return true iff this is a leaf node. */
	public boolean isLeaf() {
		return block != null;
	}

	/** Return true iff this is an intermediate node. */
	public boolean isIntermediate() {
		return !isLeaf();
	}

	/** Return the number of blocks contained in this tree. */
	public int getNumBlocks() {
		return numBlocks;
	}

	/** Return true iff this collection of blocks contains point p. */
	public boolean contains(Vector2D p) {
		// Caution. By "contains" we do NOT mean that the bounding box
		// of this block tree contains p. That is not enough. We mean
		// that one of the blocks in this BlockTree contains p.
		// TODO: Implement me.

		if (this.numBlocks == 0) {
			return false;
		}

		if (isLeaf()) {
			if (this.block.contains(p)) {
				return true;
			}
		}

		if (isIntermediate()) {
			return this.left.contains(p) || this.right.contains(p);
		}

		return false;
	}

	/**
	 * Return true iff (this tree displaced by thisD) and (tree t displaced by
	 * d) overlap.
	 */
	public boolean overlaps(Vector2D thisD, BlockTree t, Vector2D d) {
		// TODO: Implement me
		
		if (!(this.box.displaced(thisD).overlaps(t.box.displaced(d)))) {
			return false;
		}
		
		if (this.isLeaf() && t.isLeaf()){
			return this.box.displaced(thisD).overlaps(t.box.displaced(d));
		}
		
		if (this.isLeaf()){
			return  t.left.overlaps(d,this,thisD)  ||  t.right.overlaps(d,this,thisD); 
		}
		
		if (t.isLeaf()){ 
			return  this.left.overlaps(thisD,t,d)  ||  this.right.overlaps(thisD,t,d);
			
		} 
		
		return this.overlaps(thisD, t.left, d) || this.overlaps(thisD, t.right, d);
		
	}
		
		
		

	/** Return a representation of this instance. */
	public String toString() {
		return toString(new Vector2D(0, 0));
	}

	/** Return a representation of this tree displaced by d. */
	public String toString(Vector2D d) {
		return toStringAux(d, "");
	}

	/** Useful for creating appropriate indentation for function toString. */
	private static final String indentation = "   ";

	/**
	 * Return a representation of this instance displaced by d, with indentation
	 * indent.
	 * 
	 * @param d
	 *            Displacement vector.
	 * @param indent
	 *            Indentation.
	 * @return String representation of this tree (displaced by d).
	 */
	private String toStringAux(Vector2D d, String indent) {
		String str = indent + "Box: ";
		str += "(" + (box.lower.x + d.x) + "," + (box.lower.y + d.y) + ")";
		str += " -- ";
		str += "(" + (box.upper.x + d.x) + "," + (box.upper.y + d.y) + ")";
		str += "\n";

		if (isLeaf()) {
			String vStr = "(" + (block.position.x + d.x) + ","
					+ (block.position.y + d.y) + ")" + block.halfwidth;
			str += indent + "Leaf: " + vStr + "\n";
		} else {
			String newIndent = indent + indentation;
			str += left.toStringAux(d, newIndent);
			str += right.toStringAux(d, newIndent);
		}

		return str;
	}
}
