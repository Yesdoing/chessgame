package chess;

import java.util.ArrayList;

import pieces.Pawn;

public class Board {
	ArrayList<Pawn> white_pieces;
	ArrayList<Pawn> black_pieces;
	
	Board() {
		white_pieces = new ArrayList<>();
		black_pieces = new ArrayList<>();
	}
	
	void addWhitePawn(Pawn pawn) {
		white_pieces.add(pawn);
	}

	void addBlackPawn(Pawn pawn) {
		black_pieces.add(pawn);
	}

	Pawn findWhitePawn(int index) {
		return white_pieces.get(index);
	}

	Pawn findBlackPawn(int index) {
		return black_pieces.get(index);
	}

	public int white_pawn_size() {
		return white_pieces.size();
	}
	public int black_pawn_size() {
		return black_pieces.size();
	}
	
	String print() {
		StringBuilder sb = new StringBuilder();
		String line = "........\n";
		sb.append(line);
		sb.append(getBlackPawnsResult());
		sb.append("\n");
		sb.append(line);
		sb.append(line);
		sb.append(line);
		sb.append(line);
		sb.append(getWhitePawnsResult());
		sb.append("\n");
		sb.append(line);
		
		return sb.toString();
	}
	
	void initialize() {
		generatePieces(white_pieces, Pawn.PIECE_WHITE, Pawn.PIECE_WHITE_REPRESENTATION);
		generatePieces(black_pieces, Pawn.PIECE_BLACK, Pawn.PIECE_BLACK_REPRESENTATION);
	}

	private void generatePieces(ArrayList<Pawn> pieces, String pawnColor, char pawnRepresentation) {
		//pieces = new ArrayList<>();
		for(int i=0; i<8; i++) {
			pieces.add(new Pawn(pawnColor, pawnRepresentation));
		}
	}
	

	public String getWhitePawnsResult() {
		return printPawns(white_pieces);
	}

	
	public String getBlackPawnsResult() {
		return printPawns(black_pieces);
	}
	
	
	private String printPawns(ArrayList<Pawn> pawn) {
		StringBuilder sb = new StringBuilder();
		for(int i=0; i < pawn.size(); i++) {
			sb.append(pawn.get(i).getRepresentation());
		}
		return sb.toString();
	}
	
	
}
