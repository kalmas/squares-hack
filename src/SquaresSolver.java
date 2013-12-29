import java.util.ArrayList;
import java.util.List;

import design.Design;
import design.Golden;
import design.Black;
import design.Yellow;
import design.Chocolate;

import piece.Piece;
import piece.PieceSequence;
import piece.Rotator;


public class SquaresSolver {

	/**
	 * @param args
	 * @throws Exception 
	 */
	public static void main(String[] args) throws Exception {
		List<Piece> pieces = new ArrayList<Piece>();
		
		Design g1 = new Golden(Design.FRONT);
		Design g2 = new Golden(Design.REAR);
		Design b1 = new Black(Design.FRONT);
		Design b2 = new Black(Design.REAR);
		Design y1 = new Yellow(Design.FRONT);
		Design y2 = new Yellow(Design.REAR);
		Design c1 = new Chocolate(Design.FRONT);
		Design c2 = new Chocolate(Design.REAR);
		
		pieces.add(new Piece("A", 0, g2, b2, y2, c2));
		pieces.add(new Piece("B", 0, g1, b1, y1, c2));
		// pieces.add(new Piece("Z", 0, g1, b1, y1, c2));
		pieces.add(new Piece("C", 0, c1, g1, y1, b2));
		pieces.add(new Piece("D", 0, c1, y2, b1, g1));
		pieces.add(new Piece("E", 0, g2, b1, y1, c2));
		pieces.add(new Piece("F", 0, g1, b2, y2, c1));
		pieces.add(new Piece("G", 0, y1, g1, c1, b1));
		pieces.add(new Piece("H", 0, g1, b1, y2, c1));
		pieces.add(new Piece("I", 0, y1, b1, c1, g2));
		
		List<Piece> representations = new ArrayList<Piece>();
		Rotator rotator = new Rotator();
		
		for(Piece piece : pieces){
			List<Piece> rotations = rotator.getRotations(piece);
			representations.addAll(rotations);
		}
		
		PieceSequence sequence = new PieceSequence();
		Player kyle = new Player();
		kyle.play(sequence, representations);
		
		System.out.println("Done");

		
		

	}


}
