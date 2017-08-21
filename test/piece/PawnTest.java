package piece;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class PawnTest {
	
	Pawn white_pawn;
	Pawn black_pawn;
	
	@Before
	public void setup() {
		white_pawn = new Pawn("white");
		black_pawn = new Pawn("black");
	}
	
	@Test
	public void 폰_색깔_검사() {
		assertEquals("white", white_pawn.getColor());
		assertEquals("black", black_pawn.getColor());
	}

}
