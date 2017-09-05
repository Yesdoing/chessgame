package pieces;

import static org.junit.Assert.*;
import org.junit.Test;

import pieces.Piece;
import pieces.Piece.Type;

public class PieceTest {
	
	
	@Test
	public void create_piece() throws Exception {
		verifyPawn(Piece.createWhitePawn(new Position("a8")), Piece.createBlackPawn(new Position("a4")), Type.PAWN);
	}

	@Test
	public void getRepresentationPerPiece() throws Exception {
		assertEquals('p', Piece.Type.PAWN.getWhiteRepresentation());
		assertEquals('P', Piece.Type.PAWN.getBlackRepresentation());
	}
	
	@Test
	public void getPiecePointTest() throws Exception {
		Piece whitePawn = Piece.createWhitePawn(new Position("a8"));
		Piece blackPawn = Piece.createBlackPawn(new Position("a8"));
		
		assertEquals(1.0, whitePawn.getPoint(), 0.1);
		assertEquals(1.0, blackPawn.getPoint(), 0.1);
		assertEquals(9.0, Piece.createWhiteQueen(new Position("a8")).getPoint(), 0.1);
		assertEquals(9.0, Piece.createBlackQueen(new Position("a8")).getPoint(), 0.1);
		assertEquals(5.0, Piece.createWhiteRook(new Position("a8")).getPoint(), 0.1);
		assertEquals(5.0, Piece.createBlackRook(new Position("a8")).getPoint(), 0.1);
		assertEquals(3.0, Piece.createWhiteBishop(new Position("a8")).getPoint(), 0.1);
		assertEquals(3.0, Piece.createBlackBishop(new Position("a8")).getPoint(), 0.1);
		assertEquals(2.5, Piece.createWhiteKnight(new Position("a8")).getPoint(), 0.1);
		assertEquals(2.5, Piece.createBlackKnight(new Position("a8")).getPoint(), 0.1);
		assertEquals(0.0, Piece.createWhiteKing(new Position("a8")).getPoint(), 0.1);
		assertEquals(0.0, Piece.createBlackKing(new Position("a8")).getPoint(), 0.1);
	}
	
	@Test
	public void isColorTest() throws Exception {
		Piece whitePawn = Piece.createWhitePawn(new Position("a8"));
		Piece blackPawn = Piece.createBlackPawn(new Position("a1"));
		assertTrue(whitePawn.isWhite());
		assertTrue(blackPawn.isBlack());
	}
	
	private void verifyPawn(final Piece whitePiece, final Piece blackPiece, final Type type) {
		assertTrue(whitePiece.isWhite());
		assertEquals(type, whitePiece.getType());
		
		assertTrue(blackPiece.isBlack());
		assertEquals(type, blackPiece.getType());
	}
}
