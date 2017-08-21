package pieces;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import pieces.Pawn;

public class PawnTest {
		
	@Before
	public void setup() {
		
	}
	
	private void verifyPawn(String color, final char representation) {
		Pawn pawn = new Pawn(color, representation);
		assertEquals(color, pawn.getColor());
		assertEquals(representation, pawn.getRepresentation());
	}

	@Test
	public void create_기본생성자() throws Exception {
		Pawn pawn = new Pawn();
		assertEquals(Pawn.PIECE_WHITE, pawn.getColor());
		assertEquals(Pawn.PIECE_WHITE_REPRESENTATION, pawn.getRepresentation());
	}
	
	@Test
	public void create() throws Exception {
		verifyPawn(Pawn.PIECE_WHITE, Pawn.PIECE_WHITE_REPRESENTATION);
		verifyPawn(Pawn.PIECE_BLACK, Pawn.PIECE_BLACK_REPRESENTATION);
	}
}
