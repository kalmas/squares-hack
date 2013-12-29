package piece;

import java.util.ArrayList;
import java.util.List;

public class PieceSequence {
	
	private List<Piece> pieces;
	
	public PieceSequence(List<Piece> pieces){
		this.pieces = pieces;
	}
	
	public PieceSequence(){
		pieces = new ArrayList<Piece>();
	}
	
	public PieceSequence(PieceSequence toCopy){
		pieces = new ArrayList<Piece>(toCopy.getPieces());
	}
	
	public List<Piece> getPieces(){
		return pieces;
	}
	
	public void add(Piece piece) {
		pieces.add(piece);
	}
	
	/**
	 * Determine if given piece can be played at this position
	 */
	public boolean pieceIsPlayable(Piece piece){
		int count = pieces.size();
		switch(count){
			case 0:
				// Anything can be played in the first position
				return true;
			case 1:
			case 2:
				// Second two positions must match piece to the left
				return pieces.get(count - 1).canBeToTheWestOf(piece);
			case 3:
			case 6:
				// Third and sixth positions must match piece above
				return pieces.get(count - 3).canBeToTheNorthOf(piece);
			default:
				// Other positions must match the piece to the left and the piece above
				return (pieces.get(count - 1).canBeToTheWestOf(piece)
						&& pieces.get(count - 3).canBeToTheNorthOf(piece));
		}
	}
	
	public String draw() {
		String drawing = new String();
		for(Piece piece : pieces) {
			drawing = drawing + piece.draw() + "\n";
		}
		
		return drawing;
	}
	
	public int size(){
		return pieces.size();
	}

}
