public boolean overlaps(Vector2D thisD, BlockTree t, Vector2D d) {
		// TODO: Implement me
		
		if (!(this.box.displaced(thisD).overlaps(t.box.displaced(d)))) {
			return false;
		}
		
		if (this.isLeaf() && t.isLeaf())
		
		if (this.right == null || t.left == null) {
			if (this.block.getBBox().displaced(thisD).overlaps(t.box.displaced(d))){
				return true;
			}
		} else if (t.right == null || this.left == null) {
			if (t.block.getBBox().displaced(d).overlaps(this.box.displaced(thisD))){
				return true;
			}
		}
		
		else {
			if (this.box.displaced(thisD).getCenter().x <= t.box.displaced(d).getCenter().x) {
				this.right.overlaps(thisD, t.left, d);
			} else {
				this.left.overlaps(thisD, t.right,d);
			}
		}
		
		return false;
	}




if (this.contains(t.block.getBBox().getCenter())){
				return true;
			} else {
				return false;
			}



REAL TALK:

if (t.isLeaf()){
			System.out.println("inside t.isLeaf()");
			if (this.isLeaf()) {
				System.out.println("inside this.isLeaf()");
				return this.box.displaced(thisD).overlaps(t.box.displaced(d));
			} else if (this.left.box.displaced(thisD).overlaps(t.box.displaced(d))){
				return this.left.overlaps(thisD, t, d);
			} else if (this.right.box.displaced(thisD).overlaps(t.box.displaced(d))){
				return this.right.overlaps(thisD, t, d);
			} else {
				return false;
			}
		}
		
		if (t.left.box.displaced(d).overlaps(this.box.displaced(thisD))){
			System.out.println("inside left overlap");
			return this.overlaps(thisD, t.left, d);
		} else if (t.right.box.displaced(d).overlaps(this.box.displaced(thisD))){
			System.out.println("inside right overlap");
			return this.overlaps(thisD, t.right, d);
		}


REALER TALK:

/**if (t.numBlocks >= this.numBlocks){
			if (t.isLeaf()){
				if (this.isLeaf()) {
					return this.box.displaced(thisD).overlaps(t.box.displaced(d));
				} else if (this.left.box.displaced(thisD).overlaps(t.box.displaced(d))){
					return this.left.overlaps(thisD, t, d);
				} else if (this.right.box.displaced(thisD).overlaps(t.box.displaced(d))){
					return this.right.overlaps(thisD, t, d);
				} else {
					return false;
				}
			}
			
			if (t.left.box.displaced(d).overlaps(this.box.displaced(thisD))){
				return this.overlaps(thisD, t.left, d);
			} else if (t.right.box.displaced(d).overlaps(this.box.displaced(thisD))){
				return this.overlaps(thisD, t.right, d);
			}
			
		} else {
			if (this.isLeaf()){
				if (t.isLeaf()) {
					return t.box.displaced(d).overlaps(this.box.displaced(thisD));
				} else if (t.left.box.displaced(d).overlaps(this.box.displaced(thisD))){
					return t.left.overlaps(d, this, thisD);
				} else if (t.right.box.displaced(d).overlaps(this.box.displaced(thisD))){
					return t.right.overlaps(d, this, thisD);
				} else {
					return false;
				}
			}
			
			if (this.left.box.displaced(thisD).overlaps(t.box.displaced(d))){
				return t.overlaps(d, this.left, thisD);
			} else if (this.right.box.displaced(thisD).overlaps(t.box.displaced(d))){
				return t.overlaps(d, this.right, thisD);
			}
		}*/
		
		
		
		return true;


REAL TALK 2.0

/**if (this.isLeaf() && t.isLeaf()){
			System.out.println("cow");
			if (t.box.displaced(d).overlaps(this.box.displaced(thisD))){
				return true;
			}
		}
		
		if (this.isLeaf()){
			if (this.box.displaced(thisD).overlaps(t.right.box.displaced(d))){
				return t.right.overlaps(d,this,thisD);
			} else if (this.box.displaced(thisD).overlaps(t.left.box.displaced(d))){
				return t.left.overlaps(d,this,thisD);
			}
		} else if (t.isLeaf()){
			if (t.box.displaced(d).overlaps(this.right.box.displaced(thisD))){
				return this.right.overlaps(thisD,t,d);
			} else if (t.box.displaced(d).overlaps(this.left.box.displaced(thisD))){
				return this.left.overlaps(thisD,t,d);
			}
		}
		
		if (t.numBlocks == 1 && this.numBlocks > 1){
			System.out.println("pigz");
			return this.contains(t.box.displaced(d).getCenter());
		} else if (this.numBlocks == 1 && t.numBlocks > 1){
			return t.contains(this.box.displaced(thisD).getCenter());
		} else if (t.numBlocks ==1 && this.numBlocks==1){
			return this.contains(t.box.displaced(d).getCenter());
		}*/














		/**if (!(this.box.displaced(thisD).overlaps(t.box.displaced(d)))) {
			System.out.println("BASE1");
			return false;
		}
		
		if (this.numBlocks == 1 && t.numBlocks == 1){
			System.out.println("In base case.");
			return this.block.getBBox().displaced(thisD).overlaps(t.block.getBBox().displaced(d));
			}
		
		if ((t.numBlocks > 1) && t.numBlocks >= this.numBlocks){ //t is bigger
			if (t.left.box.displaced(d).overlaps(this.box)){ //left box of t overlaps this
				t.left.overlaps(d,this,thisD);
			} else if (t.right.box.displaced(d).overlaps(this.box)){ //right box of t overlaps this
				t.right.overlaps(d,this,thisD);
			}
		} else if ((this.numBlocks > 1) && this.numBlocks > t.numBlocks){ //this is bigger
			if (this.left.box.displaced(thisD).overlaps(t.box)){ //left box of this overlaps t
				this.left.overlaps(thisD,t,d); 
			} else if (this.right.box.displaced(thisD).overlaps(t.box)){ //right box of this overlaps t
				this.right.overlaps(thisD,t,d);
			}
		}*/