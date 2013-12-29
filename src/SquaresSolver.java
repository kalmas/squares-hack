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

	public static void main(String[] args) throws Exception {
		
		// Build a list of the physical pieces we have to play with
		List<Piece> pieces = new ArrayList<Piece>();
		pieces.add(new Piece("A", 0, new Golden(Design.REAR), new Black(Design.REAR), new Yellow(Design.REAR), new Chocolate(Design.REAR)));
		pieces.add(new Piece("B", 0, new Golden(Design.FRONT), new Black(Design.FRONT), new Yellow(Design.FRONT), new Chocolate(Design.REAR)));
		pieces.add(new Piece("C", 0, new Chocolate(Design.FRONT), new Golden(Design.FRONT), new Yellow(Design.FRONT), new Black(Design.REAR)));
		pieces.add(new Piece("D", 0, new Chocolate(Design.FRONT), new Yellow(Design.REAR), new Black(Design.FRONT), new Golden(Design.FRONT)));
		pieces.add(new Piece("E", 0, new Golden(Design.REAR), new Black(Design.FRONT), new Yellow(Design.FRONT), new Chocolate(Design.REAR)));
		pieces.add(new Piece("F", 0, new Golden(Design.FRONT), new Black(Design.REAR), new Yellow(Design.REAR), new Chocolate(Design.FRONT)));
		pieces.add(new Piece("G", 0, new Yellow(Design.FRONT), new Golden(Design.FRONT), new Chocolate(Design.FRONT), new Black(Design.FRONT)));
		pieces.add(new Piece("H", 0, new Golden(Design.FRONT), new Black(Design.FRONT), new Yellow(Design.REAR), new Chocolate(Design.FRONT)));
		pieces.add(new Piece("I", 0, new Yellow(Design.FRONT), new Black(Design.FRONT), new Chocolate(Design.FRONT), new Golden(Design.REAR)));
		
		// Now make a list of all the possible ways a piece may be represented
		// i.e. 4 representations per piece, one for each possible orientation
		List<Piece> representations = new ArrayList<Piece>();
		Rotator rotator = new Rotator();
		for(Piece piece : pieces){
			List<Piece> rotations = rotator.getRotations(piece);
			representations.addAll(rotations);
		}
		
		// Start with an empty sequence of pieces, representing an empty table
		PieceSequence sequence = new PieceSequence();
		
		// Our diligent player will solve the puzzle
		Player kyle = new Player();
		
		PieceSequence winningCombo = kyle.play(sequence, representations);
		
		System.out.println("Solved it in " + Player.tries + " tries:");
		System.out.print(winningCombo.draw());
	}
}
