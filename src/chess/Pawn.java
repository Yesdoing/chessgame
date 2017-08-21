package chess;

public class Pawn {
	public static final String PIECE_BLACK = "black";
	public static final String PIECE_WHITE = "white";
	
	String color;
	
	public Pawn() {
		this.color = "white";
	}
	
	Pawn(String color) {
		this.color = color;
	}


	public String getColor() {
		return color;
	}
	
	
}
