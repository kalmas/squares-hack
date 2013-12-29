import java.util.ArrayList;
import java.util.List;

import piece.Piece;
import piece.PieceSequence;


public class Player {
	
	public void play(PieceSequence currentSeq, List<Piece> playablePieces) {
		for(int i = 0; i < playablePieces.size(); i++){

			System.out.print(".");
			Piece pieceToPlay = playablePieces.get(i);
			if(currentSeq.pieceIsPlayable(pieceToPlay)){
				List<Piece> filteredList = removePiecesWithSameOrigin(playablePieces, pieceToPlay.getOrigin());
				PieceSequence newSeq = new PieceSequence(currentSeq);
				newSeq.add(pieceToPlay);
				play(newSeq, filteredList);
			}
		}
	}
	
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
