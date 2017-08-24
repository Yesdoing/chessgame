package chess;

import java.util.ArrayList;

import pieces.Piece;
import static utils.StringUtils.appendNewLine;

public class Board {
	private static int pieceCount = 0;
	ArrayList<Piece> white_pieces = new ArrayList<>();
	ArrayList<Piece> black_pieces = new ArrayList<>();
	ArrayList<Piece> white_pawns = new ArrayList<>();
	ArrayList<Piece> black_pawns = new ArrayList<>();
	
	ArrayList<ArrayList<Piece>> rank = new ArrayList<>();

	Board() {
	}

	void addWhitePawn(Piece pawn) {
		pieceCount++;
		white_pawns.add(pawn);
	}

	void addBlackPawn(Piece pawn) {
		pieceCount++;
		black_pawns.add(pawn);
	}

	void addBlackPieces(Piece piece) {
		pieceCount++;
		black_pieces.add(piece);
	}
	
	void addWhitePieces(Piece piece) {
		pieceCount++;
		white_pieces.add(piece);
	}

	Piece findWhitePawn(int index) {
		return white_pawns.get(index);
	}
	Piece findWhitePieces(int index) {
		return white_pieces.get(index);
	}

	Piece findBlackPawn(int index) {
		return black_pawns.get(index);
	}
	
	Piece findBlackPieces(int index) {
		return black_pieces.get(index);
	}

	String getSeparator() {
		return "........";
	}

	String showBoard() {
		String blankRank = appendNewLine("........");
		StringBuilder sb = new StringBuilder();
		sb.append(appendNewLine(getBlackPiecesResult()));
		sb.append(appendNewLine(getBlackPawnsResult()));
		sb.append(blankRank);
		sb.append(blankRank);
		sb.append(blankRank);
		sb.append(blankRank);
		sb.append(appendNewLine(getWhitePawnsResult()));
		sb.append(appendNewLine(getWhitePiecesResult()));
		return sb.toString();
	}

	void initialize() {
		
		addWhitePieces(Piece.createWhiteRook());
		addWhitePieces(Piece.createWhiteKnight());
		addWhitePieces(Piece.createWhiteBishop());
		addWhitePieces(Piece.createWhiteQueen());
		addWhitePieces(Piece.createWhiteKing());
		addWhitePieces(Piece.createWhiteBishop());
		addWhitePieces(Piece.createWhiteKnight());
		addWhitePieces(Piece.createWhiteRook());
		
		for (int i = 0; i < 8; i++) {
			addWhitePawn(Piece.createWhitePawn());
		}
		
		
		addBlackPieces(Piece.createBlackRook());
		addBlackPieces(Piece.createBlackKnight());
		addBlackPieces(Piece.createBlackBishop());
		addBlackPieces(Piece.createBlackQueen());
		addBlackPieces(Piece.createBlackKing());
		addBlackPieces(Piece.createBlackBishop());
		addBlackPieces(Piece.createBlackKnight());
		addBlackPieces(Piece.createBlackRook());
		
		for (int i = 0; i < 8; i++) {
			addBlackPawn(Piece.createBlackPawn());
		}
		
		
	}


	public String getWhitePawnsResult() {
		return printPieces(white_pawns);
	}

	public String getWhitePiecesResult() {
		return printPieces(white_pieces);
	}

	public String getBlackPawnsResult() {
		return printPieces(black_pawns);
	}
	
	public String getBlackPiecesResult() {
		return printPieces(black_pieces);
	}

	private String printPieces(ArrayList<Piece> pieces) {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < pieces.size(); i++) {
			sb.append(pieces.get(i).getRepresentation());
		}
		return sb.toString();
	}

	public int pieceCount() {
		return pieceCount;
	}

}
