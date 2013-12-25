package piece;

import java.util.ArrayList;
import java.util.List;

import design.Design;

public class Rotator {
	
	static final int NINETY = 90;
	static final int ONE_EIGHTY = 180;
	static final int TWO_SEVENTY = 270;
	
	public List<Piece> getRotations(Piece original){
		List<Piece> pieces = new ArrayList<Piece>();
		Design[] originalDesigns = original.getDesigns();
		
		pieces.add(new Piece(originalDesigns));
		pieces.add(new Piece(rotateNinety(originalDesigns)));
		pieces.add(new Piece(rotateOneEighty(originalDesigns)));
		pieces.add(new Piece(rotateTwoSeventy(originalDesigns)));
		
		return pieces;
	}
	
	private Design[] slideOnce(Design[] original){
		Design[] slided = new Design[4];
		slided[0] = original[3];
		slided[1] = original[0];
		slided[2] = original[1];
		slided[3] = original[2];
		
		return slided;
	}
	
	private Design[] rotateNinety(Design[] designs){
		return slideOnce(designs);
	}
	
	private Design[] rotateOneEighty(Design[] designs){
		return rotateNinety(rotateNinety(designs));
	}
	
	private Design[] rotateTwoSeventy(Design[] designs){
		return rotateNinety(rotateOneEighty(designs));
	}

}
