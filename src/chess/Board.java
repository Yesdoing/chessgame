package chess;

import java.util.ArrayList;

import pieces.Pawn;

public class Board {
	ArrayList<Pawn> pieces;
	
	Board() {
		pieces = new ArrayList<Pawn>();
	}
	
	void addPawn(Pawn pawn) {
		pieces.add(pawn);
	}

	Pawn findPawn(int index) {
		return pieces.get(index);
	}

	public int size() {
		return pieces.size();
	}
	
	
	
	
}
