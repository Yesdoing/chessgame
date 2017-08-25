package chess;

public class Position {
	int rank;
	int file;
	String position;
	
	public Position(String position) {
		file = position.charAt(0) - 'a';
		rank = Character.getNumericValue(position.charAt(1))-1;
	}
	
	public int getRank() {
		return rank;
	}
	
	public int getFile() {
		return file;
	}
	
	
	
	
}
