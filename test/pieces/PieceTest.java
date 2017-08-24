package pieces;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import pieces.Piece;
import pieces.Piece.Type;

public class PieceTest {
	
	   @Test
	    public void create_piece() {
	        verifyPiece(Piece.createWhitePawn(), Piece.createBlackPawn(), Type.PAWN);
	        verifyPiece(Piece.createWhiteKnight(), Piece.createBlackKnight(), Type.KNIGHT);
	        verifyPiece(Piece.createWhiteRook(), Piece.createBlackRook(), Type.ROOK);
	        verifyPiece(Piece.createWhiteBishop(), Piece.createBlackBishop(), Type.BISHOP);
	        verifyPiece(Piece.createWhiteQueen(), Piece.createBlackQueen(), Type.QUEEN);
	        verifyPiece(Piece.createWhiteKing(), Piece.createBlackKing(), Type.KING);

	        Piece blank = Piece.createBlank();
	        assertFalse(blank.isWhite());
	        assertFalse(blank.isBlack());
	        assertEquals(Type.NO_PIECE, blank.getType());
	    }

	    private void verifyPiece(final Piece whitePiece, final Piece blackPiece, final Type type) {
	        assertTrue(whitePiece.isWhite());
	        assertEquals(type, whitePiece.getType());

	        assertTrue(blackPiece.isBlack());
	        assertEquals(type, blackPiece.getType());
	    }
	
}
