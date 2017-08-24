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

	private void verifyWhitePawn(final Piece piece, final String color, final char representation) {
		assertEquals(color, piece.getColor());
		assertEquals(representation, piece.getRepresentation());
		assertTrue(piece.isWhite());
		assertFalse(piece.isBlack());
	}

	private void verifyBlackPawn(final Piece piece, final String color, final char representation) {
		assertEquals(color, piece.getColor());
		assertEquals(representation, piece.getRepresentation());
		assertTrue(piece.isBlack());
		assertFalse(piece.isWhite());
	}
 
	@Test
	public void create_piece() throws Exception {
		verifyPawn(Piece.createWhitePawn(), Piece.WHITE_COLOR, 'p');
		verifyWhitePawn(Piece.createWhitePawn(), Piece.WHITE_COLOR, 'p');
		verifyBlackPawn(Piece.createBlackPawn(), Piece.BLACK_COLOR, 'P');
	}


	
}
