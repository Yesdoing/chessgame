package piece;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

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

	
}
