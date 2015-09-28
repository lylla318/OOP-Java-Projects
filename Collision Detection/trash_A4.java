if (this.box.getLength() == this.box.getWidth()) {
			// split here
			splitBox1Upper.x -= (this.box.upper.x - (this.box.getWidth() * 0.5));
			splitBox2Lower.x = (this.box.lower.x + (this.box.getWidth() * 0.5));
		} else {
			// split here
			splitBox1Lower.y = (this.box.upper.y - (this.box.getHeight() * 0.5));
			splitBox2Upper.y = (this.box.lower.y + (this.box.getHeight() * 0.5));
		}


public BlockTree(ArrayList<Block> blocks) {
		// Leave the following two "if" statements as they are.
		if (blocks == null)
			throw new IllegalArgumentException("blocks null");
		if (blocks.size() == 0)
			throw new IllegalArgumentException("no blocks");

		// TODO: implement me.

		
		System.out.println(blocks.size());
		// base case
		if (blocks.size() == 1) {
			System.out.println("here");
			block = blocks.get(0);
			Iterator<Block> itr = blocks.iterator();
			this.box = BoundingBox.findBBox(itr);
			this.numBlocks = blocks.size();
			this.left = null;
			this.right = null;
		}

		else {
			System.out.println("there");
			Iterator<Block> itr = blocks.iterator();
			this.box = BoundingBox.findBBox(itr);
			this.numBlocks = blocks.size();
//			if (this.isIntermediate()) {
//				this.block = null;
//			} else if (this.isLeaf()) {
//				this.block = blocks.get(0);
//			}
			System.out.println("where");
			Vector2D splitBox1Lower = new Vector2D(this.box.lower.x,
					this.box.lower.y);// first new BBox Lower Vector
			Vector2D splitBox1Upper = new Vector2D(this.box.upper.x,
					this.box.upper.y);// first new BBox Upper Vector
			Vector2D splitBox2Lower = new Vector2D(this.box.lower.x,
					this.box.lower.y);// second new BBox Lower Vector
			Vector2D splitBox2Upper = new Vector2D(this.box.upper.x,
					this.box.upper.y);// second new BBox Upper Vector

			if (this.box.getLength() == this.box.getWidth()) {
				// split here
				splitBox1Upper.x -= (this.box.getWidth() * 0.5);
				splitBox2Lower.x += (this.box.getWidth() * 0.5);
			} else {
				// split here
				splitBox1Upper.y -= (this.box.getHeight() * 0.5);
				splitBox2Lower.y += (this.box.getHeight() * 0.5);
			}

			BoundingBox splitBox1 = new BoundingBox(splitBox1Lower,
					splitBox1Upper);
			BoundingBox splitBox2 = new BoundingBox(splitBox2Lower,
					splitBox2Upper);
			ArrayList<Block> ListBox1 = new ArrayList<Block>();
			ArrayList<Block> ListBox2 = new ArrayList<Block>();

			int i = 0;
			while (i < numBlocks) {
				if ((splitBox1.overlaps(blocks.get(i).getBBox()))
						&& !(splitBox2.overlaps(blocks.get(i).getBBox()))) {
					ListBox1.add(blocks.get(i));
				} else if (splitBox2.overlaps(blocks.get(i).getBBox())) {
					ListBox2.add(blocks.get(i));
				}
				i++;
			}
			System.out.println(ListBox1.size() + " box1");
			System.out.println(ListBox2.size() + " box2");
			
			if (ListBox1.size() >= 1) {
				System.out.println(ListBox1.size() + "GG");
				this.left = new BlockTree(ListBox1);
			}
			if (ListBox2.size() >= 1) {
				System.out.println(ListBox2.size() + "HH");
				this.right = new BlockTree(ListBox2);
			}

		}

	}



IN CONTAINS, BLOCK TREE --> BULLSHIT CONDITIONS

// if (left != null && right != null) {
		// return this.left.contains(p) || this.right.contains(p);
		// }
		//
		// if (right == null && left != null){
		// return this.left.contains(p);
		// }
		//
		// if (left == null && right!= null){
		// return this.right.contains(p);
		// }





public boolean overlaps(Vector2D thisD, BlockTree t, Vector2D d) {
		// TODO: Implement me
		
		if ((this.isLeaf() == true) && (t.isLeaf() == true)){
			return this.block.getBBox().displaced(thisD).overlaps(t.block.getBBox().displaced(thisD));
		} else if ((this.isLeaf() == true) || (t.isLeaf() == true)){
			return this.block.getBBox().displaced(thisD).overlaps(t.right);
		}

		if (this.box.displaced(thisD).overlaps(t.box.displaced(d)) == false) {
			return false;
		}

		return ((this.left.overlaps(thisD, t.right, d))
				|| (this.right.overlaps(thisD, t.right, d))
				|| (this.left.overlaps(thisD, t.left, d)) || this.right
					.overlaps(thisD, t.left, d));

	}



public boolean overlaps(Vector2D thisD, BlockTree t, Vector2D d) {
		// TODO: Implement me
		
		if ((this.isLeaf() == true) && (t.isLeaf() == true)){
			return this.block.getBBox().displaced(thisD).overlaps(t.block.getBBox().displaced(thisD));
		} else if ((this.isLeaf() == true) && (t.isLeaf() != true)){
			return this.block.getBBox().displaced(thisD).overlaps(t.right.box.displaced(d));
		} else if ((this.isLeaf() == true) && (t.isLeaf() != true)){
			return this.block.getBBox().displaced(thisD).overlaps(t.left.box.displaced(d));
		} else if ((this.isLeaf() != true) && (t.isLeaf() == true)){
			return (this.right.box.displaced(d)).overlaps(t.block.getBBox().displaced(d));
		} else if ((this.isLeaf() != true) && (t.isLeaf() == true)){
			return (this.left.box.displaced(d)).overlaps(t.block.getBBox().displaced(d));
		}

		if (this.box.displaced(thisD).overlaps(t.box.displaced(d)) == false) {
			return false;
		}

		return ((this.left.overlaps(thisD, t.right, d))
				|| (this.right.overlaps(thisD, t.right, d))
				|| (this.left.overlaps(thisD, t.left, d)) || this.right
					.overlaps(thisD, t.left, d));

	}


