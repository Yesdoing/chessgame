package chess;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import pieces.Piece;
import pieces.Position;
import pieces.Piece.Color;
import pieces.Piece.Type;

public class RankTest {

	@Test
	public void calculateRankTest() throws Exception {
		Rank rank = Rank.addBlackPawns(0);
		Rank blankRank = Rank.addBlankRank(0);
		assertEquals(8.0, rank.calculatePointPerRank(Color.BLACK), 0.1);
		blankRank.setRankPiece(2, Piece.createBlackQueen(new Position(0, 1)));
		assertEquals(9.0, blankRank.calculatePointPerRank(Color.BLACK), 0.1);
	}
	
	@Test
	public void getPieceNumberPerRankTest() throws Exception {
		Rank rank = Rank.addWhitePawns(0);
		assertEquals(8, rank.getPieceNumberPerRank(Color.WHITE, Type.PAWN));
		rank = Rank.addWhitePieces(0);
		assertEquals(1, rank.getPieceNumberPerRank(Color.WHITE, Type.KING));
	}
	
	@Test
	public void setRankPieceTest() throws Exception {
		Rank rank = Rank.addBlankRank(0);
		rank.setRankPiece(0, Piece.createBlackBishop(new Position(0, 0)));
		assertEquals(1, rank.getPieceNumberPerRank(Color.BLACK, Type.BISHOP));
	}
	
	@Test
	public void create() throws Exception {
		assertEquals(Rank.addWhitePawns(0), createPieces(0, Piece.createWhitePawn(new Position("a8"))));
		assertEquals(Rank.addBlackPawns(0), createPieces(0, Piece.createBlackPawn(new Position("a8"))));
		assertEquals(Rank.addWhitePieces(0), createWhiteMajorPieces(0));
		assertEquals(Rank.addBlackPieces(0), createBlackMajorPieces(0));
	}

	private Rank createWhiteMajorPieces(int yPos) {
		List<Piece> pieces = new ArrayList<>();
		pieces.add(Piece.createWhiteRook(new Position(0, yPos)));
		pieces.add(Piece.createWhiteKnight(new Position(1, yPos)));
		pieces.add(Piece.createWhiteBishop(new Position(2, yPos)));
		pieces.add(Piece.createWhiteQueen(new Position(3, yPos)));
		pieces.add(Piece.createWhiteKing(new Position(4, yPos)));
		pieces.add(Piece.createWhiteBishop(new Position(5, yPos)));
		pieces.add(Piece.createWhiteKnight(new Position(6, yPos)));
		pieces.add(Piece.createWhiteRook(new Position(7, yPos)));
		return Rank.create(pieces);
	}

	private Rank createBlackMajorPieces(int yPos) {
		List<Piece> pieces = new ArrayList<>();
		pieces.add(Piece.createBlackRook(new Position(0, yPos)));
		pieces.add(Piece.createBlackKnight(new Position(1, yPos)));
		pieces.add(Piece.createBlackBishop(new Position(2, yPos)));
		pieces.add(Piece.createBlackKing(new Position(4, yPos)));
		pieces.add(Piece.createBlackQueen(new Position(3, yPos)));
		pieces.add(Piece.createBlackBishop(new Position(5, yPos)));
		pieces.add(Piece.createBlackKnight(new Position(6, yPos)));
		pieces.add(Piece.createBlackRook(new Position(7, yPos)));
		return Rank.create(pieces);
	}

	@Test
	public void getRankPieceTest() throws Exception {
		Rank rank = Rank.addBlackPawns(0);
		assertEquals(rank.getRankPiece(0), Piece.createBlackPawn(new Position(0, 0)));
	}
	
	
	private Rank createPieces(int yPos, Piece piece) {
		List<Piece> pieces = new ArrayList<>();
		for( int i=0; i<8; i++) {
			pieces.add(piece);
		}
		return Rank.create(pieces);
	}	
	
}

