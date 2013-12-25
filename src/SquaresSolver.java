import java.util.ArrayList;
import java.util.List;

import design.Design;
import design.Golden;
import design.Black;
import design.Yellow;
import design.Chocolate;

import piece.Piece;
import piece.Rotator;


public class SquaresSolver {

	/**
	 * @param args
	 * @throws Exception 
	 */
	public static void main(String[] args) throws Exception {
		List<Piece> pieces = new ArrayList<Piece>();
		
		Design goldenFront = new Golden(Design.FRONT);
		Design goldenRear = new Golden(Design.REAR);
		Design blackFront = new Black(Design.FRONT);
		Design blackRear = new Black(Design.REAR);
		Design yellowFront = new Yellow(Design.FRONT);
		Design yellowRear = new Yellow(Design.REAR);
		Design chocolateFront = new Chocolate(Design.FRONT);
		Design chocolateRear = new Chocolate(Design.REAR);
		
		pieces.add(new Piece(goldenRear, blackRear, yellowRear, chocolateRear));
		pieces.add(new Piece(goldenFront, blackFront, yellowFront, chocolateRear));
		pieces.add(new Piece(chocolateFront, goldenFront, yellowFront, blackRear));
		pieces.add(new Piece(chocolateFront, yellowRear, blackFront, goldenFront));
		
		List<Piece> representations = new ArrayList<Piece>();
		Rotator rotator = new Rotator();
		
		for(Piece piece : pieces){
			List<Piece> rotations = rotator.getRotations(piece);
			representations.addAll(rotations);
		}
		
		for(Piece piece : representations) {
			System.out.println(piece.draw());
		}
		
		

	}


}
