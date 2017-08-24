package pieces;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import pieces.Piece;

public class PieceTest {
		
	@Before
	public void setup() {
		
	}
	
	private void verifyPawn(final Piece piece, final String color, final char representation) {
		assertEquals(color, piece.getColor());
		assertEquals(representation, piece.getRepresentation());
	}
 
	@Test
	public void create_piece() throws Exception {
		verifyPawn(Piece.createWhiteKing(), Piece.WHITE_COLOR, Piece.WHITE_KING_REPRESENTATION);
		verifyPawn(Piece.createBlackKing(), Piece.BLACK_COLOR, Piece.BLACK_KING_REPRESENTATION);
	}
	
	@Test
	public void isWhiteAndBlack() throws Exception {
		assertTrue(Piece.createWhiteKing().isWhite());
		assertTrue(Piece.createBlackKing().isBlack());
	}


	
}
