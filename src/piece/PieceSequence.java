package piece;

import java.util.List;

public class PieceSequence {
	
	private List<Piece> pieces;
	
	public PieceSequence(List<Piece> pieces){
		this.pieces = pieces;
	}
	
	public String draw() {
		String drawing = new String();
		for(Piece piece : pieces) {
			drawing = drawing + piece.draw() + "\n";
		}
		
		return drawing;
	}

}
