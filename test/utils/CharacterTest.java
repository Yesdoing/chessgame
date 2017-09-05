package utils;

import static org.junit.Assert.*;

import org.junit.Test;

public class CharacterTest {

	
	@Test
	public void whitespace() throws Exception {
		assertTrue(Character.isWhitespace('\n'));
		assertTrue(Character.isWhitespace('\t'));
		assertTrue(Character.isWhitespace(' '));
		assertTrue(Character.isWhitespace('\f'));
		assertTrue(Character.isWhitespace('\r'));
	}

	@Test
	public void identifier() throws Exception {
		assertTrue(Character.isJavaIdentifierPart('$'));
		assertTrue(Character.isJavaIdentifierPart('_'));
		assertFalse(Character.isJavaIdentifierPart('^'));
	}
}
