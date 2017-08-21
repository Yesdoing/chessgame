package pieces;

public class Pawn {
	public static final String PIECE_BLACK = "black";
	public static final String PIECE_WHITE = "white";
	
	String color;
	
	public Pawn() {
		this.color = "white";
	}
	
	public Pawn(String color) {
		this.color = color;
	}


	public String getColor() {
		return color;
	}
	
	
}
