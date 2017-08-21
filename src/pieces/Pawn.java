package pieces;

public class Pawn {
	public static final String PIECE_BLACK = "black";
	public static final String PIECE_WHITE = "white";
	public static final char PIECE_WHITE_REPRESENTATION = 'p';
	public static final char PIECE_BLACK_REPRESENTATION = 'P';
	
	String color;
	char representation;
	
	public Pawn() {
		this.color = PIECE_WHITE;
		this.representation = PIECE_WHITE_REPRESENTATION;
	}
	
	public Pawn(String color) {
		this.color = color;
	}

	public Pawn(String color, final char representation) {
		this.color = color;
		this.representation = representation;
	}

	public String getColor() {
		return color;
	}

	public char getRepresentation() {
		return representation;
	}
	
	
}
