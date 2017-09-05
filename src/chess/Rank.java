package chess;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import pieces.Piece;
import pieces.Piece.Color;
import pieces.Piece.Type;
import pieces.Position;

public class Rank {
	public static final int RANKSIZE = 8;
	private List<Piece> rank = new ArrayList<>();
	
	public static Rank addBlankRank(int yPos) {
		List<Piece> pieces = new ArrayList<>();
		for(int i=0; i < 8; i++) {
			pieces.add(Piece.createBlank(new Position(i, yPos)));
		}
		return new Rank(pieces);
	}
	
	public static Rank addWhitePawns(int yPos) {
		List<Piece> pieces = new ArrayList<>();
		for(int i=0; i < 8; i++) {
			pieces.add(Piece.createWhitePawn(new Position(i, yPos)));
		}
		return new Rank(pieces);
	}
	
	public static Rank addBlackPawns(int yPos) {
		List<Piece> pieces = new ArrayList<>();
		for(int i=0; i < 8; i++) {
			pieces.add(Piece.createBlackPawn(new Position(i, yPos)));
		}
		return new Rank(pieces);

	}
	
	public static Rank addWhitePieces(int yPos) {
		List<Piece> pieces = new ArrayList<>();
		pieces.add(Piece.createWhiteRook(new Position(0, yPos)));
		pieces.add(Piece.createWhiteKnight(new Position(1, yPos)));
		pieces.add(Piece.createWhiteBishop(new Position(2, yPos)));
		pieces.add(Piece.createWhiteQueen(new Position(3, yPos)));
		pieces.add(Piece.createWhiteKing(new Position(4, yPos)));
		pieces.add(Piece.createWhiteBishop(new Position(5, yPos)));
		pieces.add(Piece.createWhiteKnight(new Position(6, yPos)));
		pieces.add(Piece.createWhiteRook(new Position(7, yPos)));
		return new Rank(pieces);
	}

	public static Rank addBlackPieces(int yPos) {
		List<Piece> pieces = new ArrayList<>();
		pieces.add(Piece.createBlackRook(new Position(0, yPos)));
		pieces.add(Piece.createBlackKnight(new Position(1, yPos)));
		pieces.add(Piece.createBlackBishop(new Position(2, yPos)));
		pieces.add(Piece.createBlackKing(new Position(3, yPos)));
		pieces.add(Piece.createBlackQueen(new Position(4, yPos)));
		pieces.add(Piece.createBlackBishop(new Position(5, yPos)));
		pieces.add(Piece.createBlackKnight(new Position(6, yPos)));
		pieces.add(Piece.createBlackRook(new Position(7, yPos)));
		return new Rank(pieces);
	}
	
	private Rank() {
	}
	
	private Rank(List<Piece> rank) {
		this.rank = rank;
	}
	
	List<Piece> getRank() {
		return Collections.unmodifiableList(rank); 
	}
	
	public static Rank create(List<Piece> rank) {
		return new Rank(rank);
	}
	
	public void addPiecePerRank(Piece piece) {
		rank.add(piece);
	}
	
	public Piece getRankPiece(int index) {
		return rank.get(index);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		for(Piece piece : rank) {
			sb.append(piece.getRepresentation());
		}
		return sb.toString();
	}

	public int getPieceNumberPerRank(Color color, Type type) {
		int targetPieceNumber = 0;
		for(Piece piece : rank) {
			if(piece.matchColorAndType(color, type)) {
				targetPieceNumber++;
			}
		}
		return targetPieceNumber;
	}

	public void setRankPiece(int xPos, Piece piece) {
		rank.set(xPos, piece);
	}

	public double calculatePointPerRank(Color color) {
		double piecePointPerRank = 0.0;
		for(Piece piece : rank) {
			if(piece.getColor() == color) {
				piecePointPerRank += piece.getType().getDefaultPoint();
			}
		}
		return piecePointPerRank;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((rank == null) ? 0 : rank.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Rank other = (Rank) obj;
		if (rank == null) {
			if (other.rank != null)
				return false;
		} else if (!rank.equals(other.rank))
			return false;
		return true;
	}

	public List<Piece> getColorPieces(Color color) {
		List<Piece> colorPieces = new ArrayList<>();
		for(Piece piece : rank) {
			if(piece.getColor() == color) {
				colorPieces.add(piece);							
			}
		}
		return colorPieces;
	}

	
}
