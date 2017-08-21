package chess;

import static org.junit.Assert.*;

import org.junit.Test;

import chess.Board;
import pieces.Pawn;

public class BoardTest {
	
	@Test
	public void board_폰_객체_추가하기() throws Exception {
		Board board = new Board();
		board.addPawn(new Pawn("white"));
		Pawn pawn = new Pawn("white");
		assertEquals(pawn.getColor(), board.findPawn(0).getColor());
	}
	
	@Test
	public void create() throws Exception {
		Board board = new Board();
		
		Pawn white = new Pawn(Pawn.PIECE_WHITE);
		board.addPawn(white);
		assertEquals(1, board.size());
		assertEquals(white, board.findPawn(0));
		
		Pawn black = new Pawn(Pawn.PIECE_BLACK);
		board.addPawn(black);
		assertEquals(2, board.size());
		assertEquals(black, board.findPawn(1));
	}
}
