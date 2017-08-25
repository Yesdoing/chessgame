package chess;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import chess.Board;
import pieces.Piece;
import pieces.Piece.Color;

import static utils.StringUtils.appendNewLine;

import java.util.List;

public class BoardTest {
	Board board;

	@Before
	public void setup() {
		board = new Board();
	}
	
    @Test
    public void caculcatePoint() throws Exception {
        board.initializeEmpty();

        addPiece("b6", Piece.createBlackPawn());
        addPiece("e6", Piece.createBlackQueen());
        addPiece("b8", Piece.createBlackKing());
        addPiece("c8", Piece.createBlackRook());

        addPiece("f2", Piece.createWhitePawn());
        addPiece("g2", Piece.createWhitePawn());
        addPiece("e1", Piece.createWhiteRook());
        addPiece("f1", Piece.createWhiteKing());

        assertEquals(15.0, board.caculcatePoint(Color.BLACK), 0.01);
        assertEquals(6.5, board.caculcatePoint(Color.WHITE), 0.01);

        System.out.println(board.showBoard());
    }

    private void addPiece(String position, Piece piece) {
        board.move(position, piece);
    }

    @Test
    public void move() throws Exception {
        board.initializeEmpty();

        String position = "b5";
        Piece piece = Piece.createBlackRook();
        board.move(position, piece);

        assertEquals(piece, board.findPiece(position));
        System.out.println(board.showBoard());
    }
	
	@Test
	public void create() throws Exception {
		board.initialize();
		assertEquals(32, board.pieceCount());
		String blankRank = appendNewLine("........");
		assertEquals(appendNewLine("rnbqkbnr") + appendNewLine("pppppppp") + blankRank + blankRank + blankRank
				+ blankRank + appendNewLine("PPPPPPPP") + appendNewLine("RNBQKBNR"), board.showBoard());
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
	
	@Test
	public void findPieceNumTest() throws Exception {
		board.initialize();
		
		assertEquals(8, board.findPieceNum(Piece.createBlackPawn()));
		
	}
	
    @Test
    public void findPiece() throws Exception {
        board.initialize();
        assertEquals(Piece.createBlackRook(), board.findPiece("a8"));
        assertEquals(Piece.createBlackRook(), board.findPiece("h8"));
        assertEquals(Piece.createWhiteRook(), board.findPiece("a1"));
        assertEquals(Piece.createWhiteRook(), board.findPiece("h1"));
    }
    
	@Test
	public void printRankTest() throws Exception {
		board.initialize();
		System.out.println(board.showBoard());
	}
	
	@Test
	public void sortPieces() throws Exception {
		board.initialize();
		
		List<Piece> temp = board.whitePieceSort();
		for(Piece piece : temp) {
			System.out.println(piece.printPiece());
		}
		temp = board.blackPieceSort();
		for(Piece piece : temp) {
			System.out.println(piece.printPiece());
		}
	}
}
