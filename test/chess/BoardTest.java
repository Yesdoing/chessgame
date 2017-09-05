package chess;

import static org.junit.Assert.*;
import static utils.StringUtils.appendNewLine;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import chess.Board;
import pieces.Piece;
import pieces.Piece.Color;
import pieces.Piece.Type;
import pieces.Position;

public class BoardTest {

	Board board;
	@Before
	public void setup() {
		board = new Board();
	}
	
	@Test
	public void create() {
		board.initialize();
		String blankRank = appendNewLine("........");
		assertEquals(
				appendNewLine("RNBKQBNR") + 
				appendNewLine("PPPPPPPP") + 
				blankRank + blankRank + blankRank + blankRank +
				appendNewLine("pppppppp") + 
				appendNewLine("rnbqkbnr"), 
				board.showBoard());
	}
		
	@Test
	public void getPieceNumberPerBoard() throws Exception {
		board.initialize();
		assertEquals(8, board.getPieceNumberPerBoard(Color.BLACK, Type.PAWN));
		assertEquals(8, board.getPieceNumberPerBoard(Color.WHITE, Type.PAWN));
		assertEquals(1, board.getPieceNumberPerBoard(Color.BLACK, Type.KING));
		assertEquals(1, board.getPieceNumberPerBoard(Color.WHITE, Type.QUEEN));
		assertEquals(2, board.getPieceNumberPerBoard(Color.WHITE, Type.BISHOP));
		assertEquals(2, board.getPieceNumberPerBoard(Color.WHITE, Type.KNIGHT));
		assertEquals(2, board.getPieceNumberPerBoard(Color.BLACK, Type.ROOK));
		assertEquals(32, board.getPieceNumberPerBoard(Color.NOCOLOR, Type.NO_PIECE));
	}
	
	@Test
	public void showBoardTest() throws Exception {
		board.initialize();
		System.out.println(board.showBoard());
	}
	
	@Test
	public void findPiece() throws Exception {
		board.initialize();
		
		assertEquals(Piece.createBlackBishop(new Position("c8")), board.findPiece("c8"));
		assertEquals(Piece.createBlackBishop(new Position("f8")), board.findPiece("f8"));
		assertEquals(Piece.createWhiteBishop(new Position("c1")), board.findPiece("c1"));
		assertEquals(Piece.createWhiteBishop(new Position("f1")), board.findPiece("f1"));
	}
	
	@Test
	public void move() throws Exception {
		board.initialize();
		
		String sourcePosition = "b2";
		String targetPosition = "b3";
		System.out.println(board.findPiece(sourcePosition).getRepresentation());
		board.move(sourcePosition, targetPosition);
		System.out.println(board.findPiece(sourcePosition).getRepresentation());
		System.out.println(board.findPiece(targetPosition).getRepresentation());
//		assertEquals(Piece.createBlank(new Position(sourcePosition)), board.findPiece(sourcePosition) );
		assertEquals(Piece.createWhitePawn(new Position(sourcePosition)), board.findPiece(targetPosition));
		assertEquals(board.findPiece(targetPosition), board.findPiece(targetPosition));
		assertEquals(board.findPiece(sourcePosition), board.findPiece(sourcePosition));
		}
	
	@Test
	public void calculatePoint() throws Exception {
		board.initializeEmpty();

		addPiece(Piece.createBlackPawn(new Position("b6")));
		addPiece(Piece.createBlackQueen(new Position("e6")));
		addPiece(Piece.createBlackKing(new Position("b8")));
		addPiece(Piece.createBlackRook(new Position("c8")));
		
		addPiece(Piece.createWhitePawn(new Position("f2")));
		addPiece(Piece.createWhitePawn(new Position("g2")));
		addPiece(Piece.createWhiteRook(new Position("e1")));
		addPiece(Piece.createWhiteKing(new Position("f1")));		
		
		assertEquals(15.0, board.calculatePoint(Color.BLACK), 0.01);
		assertEquals(7.0, board.calculatePoint(Color.WHITE), 0.01);
		System.out.println(board.showBoard());
	}

	private void addPiece(Piece piece) {
		board.move(piece.getPosition(), piece);
	}
	
	@Test
	public void sortPointPerColorPiecesTest() throws Exception {
		board.initializeEmpty();
		List<Piece> compareList = new ArrayList<>();
		compareList.add(Piece.createBlackQueen(new Position("e6")));
		compareList.add(Piece.createBlackRook(new Position("c8")));
		compareList.add(Piece.createBlackPawn(new Position("b6")));
		compareList.add(Piece.createBlackKing(new Position("b8")));
		
		addPiece(Piece.createBlackPawn(new Position("b6")));
		addPiece(Piece.createBlackQueen(new Position("e6")));
		addPiece(Piece.createBlackKing(new Position("b8")));
		addPiece(Piece.createBlackRook(new Position("c8")));
		
		
		assertEquals(compareList, board.sortPointPerColorPieces(Color.BLACK));
		
	}
	
}
