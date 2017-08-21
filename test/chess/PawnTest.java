package chess;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import chess.Pawn;

public class PawnTest {
		
	@Before
	public void setup() {
		
	}
	
	@Test
	public void 폰_색깔_검사() {
		verifyPawn("white");
		verifyPawn("black");
	}

	private void verifyPawn(String color) {
		Pawn pawn = new Pawn(color);
		assertEquals(color, pawn.getColor());
	}

	@Test
	public void create_기본생성자() throws Exception {
		Pawn pawn = new Pawn();
		assertEquals("white", pawn.getColor());
	}
}
