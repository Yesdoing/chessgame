package pieces;

public class Piece implements Comparable<Piece>{	
	public enum Color {
		WHITE("white"), BLACK("black"), NOCOLOR(".");
		
		private String color;
		
		Color(String color) {
			this.color = color;
		}
		
		public String getColor() {
			return color;
		}
	}
	
	public enum Type {
		PAWN('p', 1.0), ROOK('r', 5.0), KNIGHT('n', 2.5), BISHOP('b', 3.0), QUEEN('q', 9.0), KING('k', 0.0), NO_PIECE('.', 0.0);
		
		private char representation;
		private double defaultPoint;
		
		Type(char representation, double defaultPoint) {
			this.representation = representation;
			this.defaultPoint = defaultPoint;
		}
		
		public double getDefaultPoint() {
			return defaultPoint;
		}
		
		public char getWhiteRepresentation() {
			return representation;
		}

		public char getBlackRepresentation() {
			return Character.toUpperCase(representation);
		}
	}
	
	private Color color;
	private Type type;
	private Position position;
	
	private Piece(Color color, Type representation, Position position) {
		this.color = color;
		this.type = representation;
		this.position = position;
	}
	
	public Position getPosition() {
		return position;
	}

	public char getRepresentation() {
		return isWhite() ? this.type.getWhiteRepresentation() : this.type.getBlackRepresentation();
	}

	private Piece() {
	}

	private static Piece createBlack(Type type, Position position) {
		return new Piece(Color.BLACK, type, position);
	}

	private static Piece createWhite(Type type, Position position) {
		return new Piece(Color.WHITE, type, position);
	}
	
	public static Piece createBlackPawn(Position position) {
		return createBlack(Type.PAWN, position);
	}


	public static Piece createWhitePawn(Position position) {
		return createWhite(Type.PAWN, position);
	}


	public static Piece createWhiteKnight(Position position) {
		return createWhite(Type.KNIGHT, position);
	}

	public static Piece createBlackKnight(Position position) {
		return createBlack(Type.KNIGHT, position);
	}

	public static Piece createWhiteBishop(Position position) {
		return createWhite(Type.BISHOP, position);
	}

	public static Piece createBlackBishop(Position position) {
		return createBlack(Type.BISHOP, position);
	}
	public static Piece createWhiteRook(Position position) {
		return createWhite(Type.ROOK, position);
	}
	
	public static Piece createBlackRook(Position position) {
		return createBlack(Type.ROOK, position);
	}

	public static Piece createWhiteQueen(Position position) {
		return createWhite(Type.QUEEN, position);
	}

	public static Piece createBlackQueen(Position position) {
		return createBlack(Type.QUEEN, position);
	}

	public static Piece createWhiteKing(Position position) {
		return createWhite(Type.KING, position);
	}

	public static Piece createBlackKing(Position position) {
		return createBlack(Type.KING, position);
	}

	public boolean isWhite() {
		return matchColor(Color.WHITE);
	}

	private boolean matchColor(Color color) {
		return this.color == color;
	}

	public boolean isBlack() {
		return matchColor(Color.BLACK);	
	}

	public Type getType() {
		return type;
	}

	public double getPoint() {
		return this.type.defaultPoint;
	}
	
	public static Piece createBlank(Position position) {
		return new Piece(Color.NOCOLOR, Type.NO_PIECE, position);
	}

	public boolean isBlank() {
		return this.color == Color.NOCOLOR;
	}

	public Color getColor() {
		return this.color;
	}

	public boolean matchColorAndType(Color color, Type type) {
		return matchColor(color) && matchType(type);
	}

	private boolean matchType(Type type) {
		return this.type == type;
	}

	@Override
	public int compareTo(Piece o) {
		if( this.type.defaultPoint < o.getType().defaultPoint) return 1;
		return -1;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((color == null) ? 0 : color.hashCode());
		result = prime * result + ((position == null) ? 0 : position.hashCode());
		result = prime * result + ((type == null) ? 0 : type.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Piece other = (Piece) obj;
		if (color != other.color)
			return false;
		if (position == null) {
			if (other.position != null)
				return false;
		} else if (!position.equals(other.position))
			return false;
		if (type != other.type)
			return false;
		return true;
	}

	
	
	
	
}
