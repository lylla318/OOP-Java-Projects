import java.util.Iterator;

/** An instance is a 2D bounding box. */
public class BoundingBox {
	/** The corner of the bounding box with the smaller x,y coordinates. */
	public Vector2D lower; // (minX, minY)

	/** The corner of the bounding box with the larger x,y coordinates.	 */
	public Vector2D upper; // (maxX, maxY)

	/** Constructor: an instance is a copy of bounding box b.*/
	public BoundingBox(BoundingBox b) {
		lower= new Vector2D(b.lower);
		upper= new Vector2D(b.upper);
	}

	/** Constructor: An instance with lower as smaller coordinates and
	 * upper as larger coordinates. */
	public BoundingBox(Vector2D lower, Vector2D upper) {
		if (upper.x < lower.x)
			throw new IllegalArgumentException("invalid bbox");
		if (upper.y < lower.y)
			throw new IllegalArgumentException("invalid bbox");

		this.lower= lower;
		this.upper= upper;
	}

	/** Return the width of this bounding box (along x-dimension).  */
	public double getWidth() {
		return upper.x - lower.x;
	}

	/** Return the height of this bounding box (along y-dimension). */
	public double getHeight() {
		return upper.y - lower.y;
	}

	/** Return the larger of the width and height of this bounding box.  */
	public double getLength() {
		// TODO: Implement me.
		return -1;
	}

	/** Return the center of this bounding box.  */
	public Vector2D getCenter() {
		// TODO: Implement me.
		return null;
	}

	/** Return the result of displacing this bounding box by d.  */
	public BoundingBox displaced(Vector2D d) {
		// TODO: Implement me.
		return null;
	}

	/** Return true iff this bounding box contains p.  */
	public boolean contains(Vector2D p) {
		boolean inX= lower.x <= p.x && p.x <= upper.x;
		boolean inY= lower.y <= p.y && p.y <= upper.y;
		return inX && inY;
	}

	/** Return the area of this bounding box.  */
	public double getArea() {
		// TODO: Implement me.
		return -1;
	}

	/** Return true iff this bounding box overlaps with box.  */
	public boolean overlaps(BoundingBox box) {
		// TODO: Implement me.

		return false;
	}

	/** Return the bounding box of blocks given by iter. */
	public static BoundingBox findBBox(Iterator<Block> iter) {
		// Do not modify the following "if" statement.
		if (!iter.hasNext())
			throw new IllegalArgumentException("empty iterator");

		// TODO: Implement me.
		return null;
	}

	/** Return a representation of this bounding box. */
	public String toString() {
		return lower + " -- " + upper;
	}
}
