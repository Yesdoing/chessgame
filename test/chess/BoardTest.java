package chess;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import chess.Board;
import pieces.Pawn;

public class BoardTest {
	Board board;
	
	@Before
	public void setup() {
		board = new Board();
	}
	
	@Test
	public void create() throws Exception {
		board.initialize();
		Pawn white = new Pawn(Pawn.PIECE_WHITE, Pawn.PIECE_WHITE_REPRESENTATION);
		board.addWhitePawn(white);
		assertEquals(9, board.white_pawn_size());
		assertEquals(white.getColor(), board.findWhitePawn(0).getColor());
		
		Pawn black = new Pawn(Pawn.PIECE_BLACK, Pawn.PIECE_BLACK_REPRESENTATION);
		board.addBlackPawn(black);
		assertEquals(9, board.black_pawn_size());
		assertEquals(black.getColor(), board.findBlackPawn(0).getColor());
	}
	
	
	@Test
	public void initialize() throws Exception {
		board.initialize();
		assertEquals("pppppppp", board.getWhitePawnsResult());
		assertEquals("PPPPPPPP", board.getBlackPawnsResult());
	}
	
	@Test
	public void print() throws Exception {
		board.initialize();
		board.print();
	}
	
}
