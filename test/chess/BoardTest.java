package chess;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import chess.Board;
import pieces.Piece;
import static utils.StringUtils.appendNewLine;

public class BoardTest {
	Board board;

	@Before
	public void setup() {
		board = new Board();
	}

	@Test
	public void create() throws Exception {
		board.initialize();
		assertEquals(32, board.pieceCount());
		String blankRank = appendNewLine("........");
		assertEquals(appendNewLine("RNBQKBNR") + appendNewLine("PPPPPPPP") + blankRank + blankRank + blankRank
				+ blankRank + appendNewLine("pppppppp") + appendNewLine("rnbqkbnr"), board.showBoard());
	}

	@Test
	public void initialize() throws Exception {
		board.initialize();
		assertEquals("pppppppp", board.getWhitePawnsResult());
		assertEquals("rnbqkbnr", board.getWhitePiecesResult());
		assertEquals("PPPPPPPP", board.getBlackPawnsResult());
		assertEquals("RNBQKBNR", board.getBlackPiecesResult());
	}

	@Test
	public void print() throws Exception {
		board.initialize();
		board.showBoard();
	}

}
