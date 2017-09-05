package chess;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static utils.StringUtils.appendNewLine;
import pieces.Piece;
import pieces.Piece.Color;
import pieces.Piece.Type;
import pieces.Position;

public class Board {
	public static final int BOARDSIZE = 8;

	List<Rank> board = new ArrayList<>();
	
	

		
	public void initialize() {
		board.add(Rank.addWhitePieces(0));		
		board.add(Rank.addWhitePawns(1));
		board.add(Rank.addBlankRank(2));
		board.add(Rank.addBlankRank(3));
		board.add(Rank.addBlankRank(4));
		board.add(Rank.addBlankRank(5));
		board.add(Rank.addBlackPawns(6));
		board.add(Rank.addBlackPieces(7));
	}


	

	public String showBoard() {
		StringBuilder sb = new StringBuilder();

		for(int i = board.size()-1; i>=0; i--) {
			sb.append(appendNewLine(board.get(i).toString()));
		}
		
		return sb.toString();
	}

	public int getPieceNumberPerBoard(Color color, Type type) {
		int targetPieceNum = 0;
		for(Rank rank : board) {
			targetPieceNum += rank.getPieceNumberPerRank(color, type);
		}
		return targetPieceNum;
	}

	public Piece findPiece(String position) {
		Position pos = new Position(position);
		return board.get(pos.getyPos()).getRankPiece(pos.getxPos());
	}

	public void initializeEmpty() {
		for(int i=0; i<BOARDSIZE; i++) {
			board.add(Rank.addBlankRank(i));
		}
	}

	public void move(Position position, Piece piece) {
		Position pos = position;
		board.get(pos.getyPos()).setRankPiece(pos.getxPos(), piece);
	}

	public double calculatePoint(Color color) {
		double piecePointPerBoard = 0;
		for(Rank rank : board) {
			piecePointPerBoard += rank.calculatePointPerRank(color);
		}
		return piecePointPerBoard;
	}
	
	public List<Piece> sortPointPerColorPieces(Color color) {
		List<Piece> sortPieces = new ArrayList<>();
		for(Rank rank : board) {
			sortPieces.addAll(rank.getColorPieces(color));
		}
		Collections.sort(sortPieces);
		return sortPieces;
	}




	public void move(String position, Piece piece) {
		move(new Position(position), piece);
	}




	public void move(String sourcePosition, String targetPosition) {
		Piece piece = findPiece(targetPosition);
		move(targetPosition, findPiece(sourcePosition));
		move(sourcePosition, piece);
	}
}
