package pieces;

public class Piece {
	public static final String BLACK_COLOR = "black";
	public static final String WHITE_COLOR = "white";

	String name;
	String color;
	char representation;
	boolean white = false;
	boolean black = false;
	
	public boolean isBlack() {
		return black;
	}
	
	public boolean isWhite() {
		return white;
	}
	
	
	
	private Piece(String name, String color, char representation) {
		if(color.equals("white")) {
			white = true;
		}
		
		if(color.equals("black")) {
			black = true;
		}
		
		this.name = name;
		this.color = color;
		this.representation = representation;
		
	}
	
	public static Piece createWhitePawn() {
		return new Piece("pawn", "white", 'p');
	}

	public static Piece createWhiteKing() {
		return new Piece("king", "white", 'k');
	}

	public static Piece createWhiteRook() {
		return new Piece("rook", "white", 'r');
	}

	public static Piece createWhiteQueen() {
		return new Piece("queen", "white", 'q');
	}
	
	public static Piece createWhiteKnight() {
		return new Piece("knight", "white", 'n');
	}

	public static Piece createWhiteBishop() {
		return new Piece("bishop", "white", 'b');
	}
	
	public static Piece createBlackPawn() {
		return new Piece("pawn", "black", 'P');
	}

	public static Piece createBlackBishop() {
		return new Piece("bishop", "black", 'B');
	}
	
	public static Piece createBlackRook() {
		return new Piece("rook", "black", 'R');
	}
	
	public static Piece createBlackKing() {
		return new Piece("king", "black", 'K');
	}
	public static Piece createBlackQueen() {
		return new Piece("queen", "black", 'Q');
	}

	public static Piece createBlackKnight() {
		return new Piece("knight", "black", 'N');
	}
	

	public String getColor() {
		return color;
	}

	public char getRepresentation() {
		return representation;
	}
	
	
}
