package chess;

import java.util.ArrayList;

import pieces.Piece;
import pieces.Piece.Color;

public class Rank {
	private ArrayList<Piece> rank = new ArrayList<>();
	
	private Rank(ArrayList<Piece> pieces) {
		rank = pieces;
	}
	
	public static Rank addRank(ArrayList<Piece> pieces) {
		return new Rank(pieces);
	}
	
	public void addRankPieceOne(Piece piece, int index) {
		rank.set(index, piece);
	}
	
	public Piece findPiece(int index) {
		return rank.get(index);
	}
	
	public String printPieces() {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < rank.size(); i++) {
			sb.append(rank.get(i).getType().getWhiteRepresentation());
		}
		return sb.toString();
	}
	
	int findPieceNum(Piece comparePiece) {
		int number = 0;
		for(Piece piece : rank) {
			if (piece.equals(comparePiece)) {
				number++;
			}
		}
		
		return number;
	}
	
	public double calculateRankPiece(Color color) {
		double sum = 0.0;
		for(Piece piece : rank) {
			
		}
	}
	
}
