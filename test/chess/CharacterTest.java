package chess;

import static org.junit.Assert.*;

import org.junit.Test;

public class CharacterTest {

	@Test
	public void whitespace() {
		assertEquals(true, Character.isWhitespace('\n'));
		assertEquals(true, Character.isWhitespace('\t'));
		assertEquals(true, Character.isWhitespace(' '));
		assertTrue(Character.isJavaIdentifierPart('$'));
		assertFalse(Character.isJavaIdentifierPart('\n'));
	}
	
	@Test
	public void subString() throws Exception {
		String str = "a8";
		
		String row = str.substring(0, 1);
		String col = str.substring(1);
		
		System.out.println(row + " " + col);
	}

}
