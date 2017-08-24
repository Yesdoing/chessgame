package chess;

import java.util.ArrayList;

import pieces.Piece;
import static utils.StringUtils.appendNewLine;

public class Board {
	ArrayList<Piece> white_pieces = new ArrayList<>();
	ArrayList<Piece> black_pieces = new ArrayList<>();

	ArrayList<ArrayList<Piece>> rank = new ArrayList<>();

	Board() {
	}

	void addWhitePawn(Piece pawn) {
		white_pieces.add(pawn);
	}

	void addBlackPawn(Piece pawn) {
		black_pieces.add(pawn);
	}

	Piece findWhitePawn(int index) {
		return white_pieces.get(index);
	}

	Piece findBlackPawn(int index) {
		return black_pieces.get(index);
	}

	public int white_pawn_size() {
		return white_pieces.size();
	}

	public int black_pawn_size() {
		return black_pieces.size();
	}

	String getSeparator() {
		return "........";
	}

	String showBoard() {
		StringBuilder sb = new StringBuilder();
		for (ArrayList<Piece> line : rank) {
			if (line.isEmpty()) {
				sb.append(appendNewLine(getSeparator()));
			} else {
				sb.append(appendNewLine(printPieces(line)));				
			}
		}

		return sb.toString();
	}

	void initialize() {
		for (int i = 0; i < 8; i++) {
			rank.add(new ArrayList<Piece>());
		}
		
		generateWhitePieces();
		generateBlackPieces();
	}

	private void generateWhitePieces() {
		white_pieces.addAll(generateWhitePawns());
		white_pieces.addAll(generateWhiteNobless());
		
		rank.set(7, generateWhiteNobless());
		rank.set(6, generateWhitePawns());
	}

	private void generateBlackPieces() {
		black_pieces.addAll(generateBlackPawns());
		black_pieces.addAll(generateBlackNobless());
		
		rank.set(0, generateBlackNobless());
		rank.set(1, generateBlackPawns());
	}

	private ArrayList<Piece> generateWhiteNobless() {
		ArrayList<Piece> pieces = new ArrayList<>();
		pieces.add(Piece.createWhiteRook());
		pieces.add(Piece.createWhiteKnight());
		pieces.add(Piece.createWhiteBishop());
		pieces.add(Piece.createWhiteQueen());
		pieces.add(Piece.createWhiteKing());
		pieces.add(Piece.createWhiteBishop());
		pieces.add(Piece.createWhiteKnight());
		pieces.add(Piece.createWhiteRook());
		return pieces;
	}

	private ArrayList<Piece> generateWhitePawns() {
		ArrayList<Piece> pieces = new ArrayList<>();
		for (int i = 0; i < 8; i++) {
			pieces.add(Piece.createWhitePawn());
		}
		return pieces;
	}

	private ArrayList<Piece> generateBlackPawns() {
		ArrayList<Piece> pieces = new ArrayList<>();
		for (int i = 0; i < 8; i++) {
			pieces.add(Piece.createBlackPawn());
		}
		return pieces;
	}

	private ArrayList<Piece> generateBlackNobless() {
		ArrayList<Piece> pieces = new ArrayList<>();
		pieces.add(Piece.createBlackRook());
		pieces.add(Piece.createBlackKnight());
		pieces.add(Piece.createBlackBishop());
		pieces.add(Piece.createBlackQueen());
		pieces.add(Piece.createBlackKing());
		pieces.add(Piece.createBlackBishop());
		pieces.add(Piece.createBlackKnight());
		pieces.add(Piece.createBlackRook());
		return pieces;
	}

	public String getWhitePawnsResult() {
		return printPieces(white_pieces);
	}

	public String getBlackPawnsResult() {
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
		return white_pawn_size() + black_pawn_size();
	}

}
