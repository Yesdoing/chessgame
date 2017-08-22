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
	public void board_폰_객체_추가하기() throws Exception {
		board.addWhitePawn(new Pawn(Pawn.PIECE_WHITE));
		Pawn pawn = new Pawn(Pawn.PIECE_WHITE);
		assertEquals(pawn.getColor(), board.findWhitePawn(0).getColor());
	}
	
	@Test
	public void create() throws Exception {
		
		Pawn white = new Pawn(Pawn.PIECE_WHITE, Pawn.PIECE_WHITE_REPRESENTATION);
		board.addWhitePawn(white);
		assertEquals(1, board.white_pawn_size());
		assertEquals(white, board.findWhitePawn(0));
		
		Pawn black = new Pawn(Pawn.PIECE_BLACK, Pawn.PIECE_BLACK_REPRESENTATION);
		board.addBlackPawn(black);
		assertEquals(1, board.black_pawn_size());
		assertEquals(black, board.findBlackPawn(0));
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
		System.out.println(board.print());
	}
	
}
