import java.util.ArrayList;
import java.util.List;

import piece.Piece;
import piece.PieceSequence;

public class Player {
	
	public static int tries = 0;
	
	/**
	 * Given a sequence of pieces on the table and a list of playable pieces, try every
	 * combination
	 */
	public PieceSequence play(PieceSequence currentSeq, List<Piece> playablePieces) {
		for(int i = 0; i < playablePieces.size(); i++){
			tries++;
			Piece pieceToPlay = playablePieces.get(i);
			if(currentSeq.pieceIsPlayable(pieceToPlay)){
				List<Piece> filteredList = removePiecesWithSameOrigin(playablePieces, pieceToPlay.getOrigin());
				PieceSequence newSeq = new PieceSequence(currentSeq);
				newSeq.add(pieceToPlay);
				if(newSeq.size() == 9){
					return newSeq;
				} else {
					PieceSequence result = play(newSeq, filteredList);
					if(result != null){
						return result;
					}
				}
			}
		}
		
		// Whelp, this was a dead end
		return null;
	}
	
	/**
	 * Return a copy of the given list, with representations originating from the 
	 * original physical piece removed in order to comply with the laws of physics
	 */
	private List<Piece> removePiecesWithSameOrigin(List<Piece> pieces, String origin){
		List<Piece> newList = new ArrayList<Piece>(pieces);
		for(int i = 0; i < newList.size(); i++){
			if(newList.get(i).getOrigin() == origin){
				newList.remove(i);
				i--;
			}
		}
		
		return newList;
	}

}
