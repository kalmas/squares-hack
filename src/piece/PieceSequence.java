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
		
		int length = pieces.size();
		System.out.println(length);
		if(length == 9){
			System.out.print(draw());
			throw new RuntimeException();
		}
	}
	
	public boolean pieceIsPlayable(Piece piece){
		int count = pieces.size();
		switch(count){
			case 0:
				return true;
			case 1:
			case 2:
				return pieces.get(count - 1).canBeToTheWestOf(piece);
			case 3:
			case 6:
				return pieces.get(count - 3).canBeToTheNorthOf(piece);
			default:
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

}
