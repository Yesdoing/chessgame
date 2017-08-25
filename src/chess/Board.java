package chess;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import pieces.Piece;
import pieces.Piece.Color;

import static utils.StringUtils.appendNewLine;

public class Board {
	
	private static int pieceCount = 0;
	ArrayList<Piece> white_pieces = new ArrayList<>();
	ArrayList<Piece> black_pieces = new ArrayList<>();
	ArrayList<Piece> white_pawns = new ArrayList<>();
	ArrayList<Piece> black_pawns = new ArrayList<>();
	ArrayList<Piece> blank_pieces;
	ArrayList<Rank> ranks = new ArrayList<>();
	Position pos;
	Board() {
	}

	int findPieceNum(Piece piece) {
		int number=0;
		for(Rank rank : ranks) {
			number += rank.findPieceNum(piece);
		}
		
		return number;
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
		StringBuilder sb = new StringBuilder();

		for(Rank rank : ranks) {
			sb.append(appendNewLine(rank.printPieces()));
		}
		
		return sb.toString();
	}

	void initialize() {
		ranks.add(createWhitePieces());
		ranks.add(createWhitePawns());
		ranks.add(createBlankPieces());
		ranks.add(createBlankPieces());
		ranks.add(createBlankPieces());
		ranks.add(createBlankPieces());
		ranks.add(createBlackPawns());
		ranks.add(createBlackPieces());
	}

	private Rank createBlankPieces() {
		blank_pieces = new ArrayList<>();
		for (int i = 0; i < 8; i++) {
			addBlankPiece(Piece.createBlank());
		}
		
		return Rank.addRank(blank_pieces);
	}

	private Rank createBlackPawns() {
		for (int i = 0; i < 8; i++) {
			addBlackPawn(Piece.createBlackPawn());
		}
		
		return Rank.addRank(black_pawns);
	}

	private Rank createBlackPieces() {
		addBlackPieces(Piece.createBlackRook());
		addBlackPieces(Piece.createBlackKnight());
		addBlackPieces(Piece.createBlackBishop());
		addBlackPieces(Piece.createBlackQueen());
		addBlackPieces(Piece.createBlackKing());
		addBlackPieces(Piece.createBlackBishop());
		addBlackPieces(Piece.createBlackKnight());
		addBlackPieces(Piece.createBlackRook());
		
		return Rank.addRank(black_pieces);
	}

	private Rank createWhitePawns() {
		for (int i = 0; i < 8; i++) {
			addWhitePawn(Piece.createWhitePawn());
		}
		
		return Rank.addRank(white_pawns);
	}

	private Rank createWhitePieces() {
		addWhitePieces(Piece.createWhiteRook());
		addWhitePieces(Piece.createWhiteKnight());
		addWhitePieces(Piece.createWhiteBishop());
		addWhitePieces(Piece.createWhiteQueen());
		addWhitePieces(Piece.createWhiteKing());
		addWhitePieces(Piece.createWhiteBishop());
		addWhitePieces(Piece.createWhiteKnight());
		addWhitePieces(Piece.createWhiteRook());
		
		return Rank.addRank(white_pieces);
	}


	private void addBlankPiece(Piece createBlank) {
		blank_pieces.add(createBlank);
	}

	public String getWhitePawnsResult() {
		return printWhitePieces(white_pawns);
	}

	public String getWhitePiecesResult() {
		return printWhitePieces(white_pieces);
	}

	public String getBlackPawnsResult() {
		return printBlackPieces(black_pawns);
	}
	
	public String getBlackPiecesResult() {
		return printBlackPieces(black_pieces);
	}

	private String printWhitePieces(ArrayList<Piece> pieces) {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < pieces.size(); i++) {
			sb.append(pieces.get(i).getType().getWhiteRepresentation());
		}
		return sb.toString();
	}
	private String printBlackPieces(ArrayList<Piece> pieces) {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < pieces.size(); i++) {
			sb.append(pieces.get(i).getType().getBlackRepresentation());
		}
		return sb.toString();
	}

	public int pieceCount() {
		return pieceCount;
	}

	public Piece findPiece(String position) {
		pos = new Position(position);
		return ranks.get(pos.getRank()).findPiece(pos.getFile());
	}
	

	public void initializeEmpty() {
		for(int i=0; i<8; i++) {
			ranks.add(createBlankPieces());			
		}
	}

	public void move(String position, Piece piece) {
		pos = new Position(position);
		ranks.get(pos.getRank()).addRankPieceOne(piece, pos.getFile());
	}

	public double caculcatePoint(Color color) {
		for(Rank rank : ranks) {
			
		}
		return 0;
	}
}
