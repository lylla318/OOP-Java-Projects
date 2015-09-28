public boolean overlaps(Vector2D thisD, BlockTree t, Vector2D d) {
		// TODO: Implement me
		
		if (!(this.box.displaced(thisD).overlaps(t.box.displaced(d)))) {
			System.out.println("BASE1");
			return false;
		}
		
		if (this.isLeaf() && t.isLeaf()){
			System.out.println("In base case.");
			return this.box.displaced(thisD).overlaps(t.box.displaced(d));
		}
		
		if (this.isLeaf() && t.contains(this.block.getBBox().displaced(thisD).getCenter())){
			return t.overlaps(d, this, thisD);
		} else if (t.isLeaf() && this.contains(t.block.getBBox().displaced(d).getCenter())){ 
			return this.overlaps(thisD, t, d);
		} else {
			System.out.println("in third");
			if (t.box.getArea() >= this.box.getArea()){
				if (t.left.box.displaced(d).overlaps(this.box.displaced(thisD))){
					return t.left.overlaps(d,this,thisD);
				} else {
					return t.right.overlaps(d,this,thisD);
				}
			} else {
				if (this.left.box.displaced(thisD).overlaps(t.box.displaced(d))){
					return this.left.overlaps(thisD,t,d);
				} else {
					return this.right.overlaps(thisD,t,d);
				}
			}
		} 
	}
		


OTHER METHOD/ONLY TREES

public boolean overlaps(Vector2D thisD, BlockTree t, Vector2D d) {
	// TODO: Implement me
	
	if (!(this.box.displaced(thisD).overlaps(t.box.displaced(d)))) {
		return false;
	}
	
	if (this.isLeaf() && t.isLeaf()){
		return this.box.displaced(thisD).overlaps(t.box.displaced(d));
	}
	
	if (this.isLeaf()){
		if (t.left.numBlocks >= t.right.numBlocks){
			return t.left.overlaps(d,this,thisD);
		} else {
			return t.right.overlaps(d,this,thisD);
		}
	} else if (t.isLeaf()){ 
		if (this.left.numBlocks >= this.right.numBlocks){
			return this.left.overlaps(thisD,t,d);
		} else {
			return this.right.overlaps(thisD,t,d);
		}
	} else {
		if (t.numBlocks >= this.numBlocks){
			if (t.left.box.displaced(d).overlaps(this.box.displaced(thisD))){
				return t.left.overlaps(d,this,thisD);
			} else {
				return t.right.overlaps(d,this,thisD);
			}
		} else {
			if (this.left.box.displaced(thisD).overlaps(t.box.displaced(d))){
				return this.left.overlaps(thisD,t,d);
			} else {
				return this.right.overlaps(thisD,t,d);
			}
		} 
	} 
}
	



if (!(this.box.displaced(thisD).overlaps(t.box.displaced(d)))) {
System.out.println("BASE1");
return false;
}

if (this.numBlocks == 1 && t.numBlocks == 1){
System.out.println("In base case.");
return this.block.getBBox().displaced(thisD).overlaps(t.block.getBBox().displaced(d));
}

if ((t.numBlocks > 1) && t.numBlocks >= this.numBlocks){ //t is bigger
if (t.left.box.displaced(d).overlaps(this.box)){ //left box of t overlaps this
	return t.left.overlaps(d,this,thisD);
} else if (t.right.box.displaced(d).overlaps(this.box)){ //right box of t overlaps this
	return t.right.overlaps(d,this,thisD);
}
} else if ((this.numBlocks > 1) && this.numBlocks > t.numBlocks){ //this is bigger
if (this.left.box.displaced(thisD).overlaps(t.box)){ //left box of this overlaps t
	return this.left.overlaps(thisD,t,d); 
} else if (this.right.box.displaced(thisD).overlaps(t.box)){ //right box of this overlaps t
	return this.right.overlaps(thisD,t,d);
}
}









//WORKINGWORKINGWORKING


public boolean overlaps(Vector2D thisD, BlockTree t, Vector2D d) {
	// TODO: Implement me
	
	if (!(this.box.displaced(thisD).overlaps(t.box.displaced(d)))) {
		return false;
	}
	
	if (this.isLeaf() && t.isLeaf()){
		return this.box.displaced(thisD).overlaps(t.box.displaced(d));
	}
	
	if (t.numBlocks >= this.numBlocks){
		if (t.left.box.displaced(d).overlaps(this.box.displaced(thisD))){
			return t.left.overlaps(d,this,thisD);
		} else {
			return t.right.overlaps(d,this,thisD);
		}
	} else {
		if (this.left.box.displaced(thisD).overlaps(t.box.displaced(d))){
			return this.left.overlaps(thisD,t,d);
		} else {
			return this.right.overlaps(thisD,t,d);
		}
	} 
}



THE FOLLOWING METHOD WORKS ALBEIT VERY SHITTILY:
	
	public boolean overlaps(Vector2D thisD, BlockTree t, Vector2D d) {
	// TODO: Implement me
	
	if (!(this.box.displaced(thisD).overlaps(t.box.displaced(d)))) {
		return false;
	}
	
	if (this.isLeaf() && t.isLeaf()){
		return this.box.displaced(thisD).overlaps(t.box.displaced(d));
	}
	
	if (this.isLeaf()){
		if (t.left.numBlocks >= t.right.numBlocks){
			return t.left.overlaps(d,this,thisD);
		} else {
			return t.right.overlaps(d,this,thisD);
		}
	} else if (t.isLeaf()){ 
		if (this.left.numBlocks >= this.right.numBlocks){
			return this.left.overlaps(thisD,t,d);
		} else {
			return this.right.overlaps(thisD,t,d);
		}
	} else {
		if (t.box.getArea() >= this.box.getArea()){
			if (t.left.box.displaced(d).overlaps(this.box.displaced(thisD))){
				return t.left.overlaps(d,this,thisD);
			} else {
				return t.right.overlaps(d,this,thisD);
			}
		} else {
			if (this.left.box.displaced(thisD).overlaps(t.box.displaced(d))){
				return this.left.overlaps(thisD,t,d);
			} else {
				return this.right.overlaps(thisD,t,d);
			}
		}
	} 
}




AGAIN


public boolean overlaps(Vector2D thisD, BlockTree t, Vector2D d) {
	// TODO: Implement me
	
	if (!(this.box.displaced(thisD).overlaps(t.box.displaced(d)))) {
		return false;
	}
	
	if (this.isLeaf() && t.isLeaf()){
		return this.box.displaced(thisD).overlaps(t.box.displaced(d));
	}
	
	if (this.isLeaf()){
		if (t.left.box.displaced(d).overlaps(this.box.displaced(thisD))){
			return t.left.overlaps(d,this,thisD);
		} else {
			return t.right.overlaps(d,this,thisD);
		}
	} else if (t.isLeaf()){ 
		if (this.left.box.displaced(thisD).overlaps(t.box.displaced(d))){
			return this.left.overlaps(thisD,t,d);
		} else {
			return this.right.overlaps(thisD,t,d);
		}
	} else {
		if (t.numBlocks >= this.numBlocks){
			if (t.left.box.displaced(d).overlaps(this.box.displaced(thisD))){
				return t.left.overlaps(d,this,thisD);
			} else {
				return t.right.overlaps(d,this,thisD);
			}
		} else {
			if (this.left.box.displaced(thisD).overlaps(t.box.displaced(d))){
				return this.left.overlaps(thisD,t,d);
			} else {
				return this.right.overlaps(thisD,t,d);
			}
		} 
	} 
}

AOTHER PIECE OF SHIT


public boolean overlaps(Vector2D thisD, BlockTree t, Vector2D d) {
	// TODO: Implement me
	
	if (!(this.box.displaced(thisD).overlaps(t.box.displaced(d)))) {
		return false;
	}
	
	if (this.isLeaf() && t.isLeaf()){
		return this.box.displaced(thisD).overlaps(t.box.displaced(d));
	}
	
	if (this.isLeaf()){
		if (t.left.box.displaced(d).overlaps(this.box.displaced(thisD))){
			return this.overlaps(thisD,t.left,d);
		} else if (t.right.box.displaced(d).overlaps(this.box.displaced(thisD))){
			return this.overlaps(thisD,t.right,d);
		}
	} else if (t.isLeaf()){ 
		if (this.left.box.displaced(thisD).overlaps(t.box.displaced(d))){
			return t.overlaps(d,this.left,thisD);
		} else if (this.right.box.displaced(thisD).overlaps(t.box.displaced(d))){
			return t.overlaps(d, this.right, thisD);
		}
	} else {
		if (t.numBlocks >= this.numBlocks){
			if (t.left.box.displaced(d).overlaps(this.box.displaced(thisD))){
				return this.overlaps(thisD,t.left,d);
			} else if (t.right.box.displaced(d).overlaps(this.box.displaced(thisD))){
				return this.overlaps(thisD,t.right,d);
			}
		} else {
			if (this.left.box.displaced(thisD).overlaps(t.box.displaced(d))){
				return t.overlaps(d,this.left,thisD);
			} else if (this.right.box.displaced(thisD).overlaps(t.box.displaced(d))){
				return t.overlaps(d, this.right, thisD);
			}
		} 
	} return false;
}
































public boolean overlaps(Vector2D thisD, BlockTree t, Vector2D d) {
	// TODO: Implement me
	
	if (!(this.box.displaced(thisD).overlaps(t.box.displaced(d)))) {
		return false;
	}
	
	if (this.isLeaf() && t.isLeaf()){
		return this.box.displaced(thisD).overlaps(t.box.displaced(d));
	}
	
	if (this.isLeaf()){
		if (t.left.box.displaced(d).overlaps(this.box.displaced(thisD))){
			return this.overlaps(thisD,t.left,d);
		} else if (t.right.box.displaced(d).overlaps(this.box.displaced(thisD))){
			return this.overlaps(thisD,t.right,d);
		}
	} else if (t.isLeaf()){ 
		if (this.left.box.displaced(thisD).overlaps(t.box.displaced(d))){
			return t.overlaps(d,this.left,thisD);
		} else if (this.right.box.displaced(thisD).overlaps(t.box.displaced(d))){
			return t.overlaps(d, this.right, thisD);
		}
	} else {
		if (t.numBlocks >= this.numBlocks){
			if (t.left.box.displaced(d).overlaps(this.box.displaced(thisD))){
				return this.overlaps(thisD,t.left,d);
			} else if (t.right.box.displaced(d).overlaps(this.box.displaced(thisD))){
				return this.overlaps(thisD,t.right,d);
			}
		} else {
			if (this.left.box.displaced(thisD).overlaps(t.box.displaced(d))){
				return t.overlaps(d,this.left,thisD);
			} else if (this.right.box.displaced(thisD).overlaps(t.box.displaced(d))){
				return t.overlaps(d, this.right, thisD);
			}
		} 
	} 
	return false;
}
	


