package pieces;


public class Piece {
	public enum Color {
		WHITE, BLACK, NOCOLOR;
	}
	
	public enum Type {
		PAWN('p', 1.0), 
		KNIGHT('n', 2.5), 
		ROOK('r', 5.0), 
		BISHOP('b', 3.0), 
		QUEEN('q', 9.0), 
		KING('k', 0.0), 
		NO_PIECE('.', 0.0);
		
		private char representation;
		private double defaultPoint;
		
		Type (char representation, double defaultPoint) {
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
		
	Color color;
	Type type;
		
	public boolean isBlack() {
		return color == Color.BLACK;
	}
	
	public boolean isWhite() {
		return color == Color.WHITE;
	}
	
	public double getPiecePoint(Color color) {
		if(this.color == color) {
			return type.getDefaultPoint();
		}
		return 0.0;
	}
	
	public char printPiece() {
		if(isBlack()) {
			return type.getBlackRepresentation();
		}
		if (isWhite()) {
			return type.getWhiteRepresentation();			
		}
		
		return type.getWhiteRepresentation();
	}
	
	private Piece(Color color, Type representation) {
		this.color = color;
		this.type = representation;
		
	}
	
	
	
	private static Piece createWhite(Type type) {
		return new Piece(Color.WHITE, type);
	}
	
	private static Piece createBlack(Type type) {
		return new Piece(Color.BLACK, type);
	}
	
	public static Piece createWhitePawn() {
		return createWhite(Type.PAWN);
	}

	public static Piece createWhiteKing() {
		return createWhite(Type.KING);
	}

	public static Piece createWhiteRook() {
		return createWhite(Type.ROOK);
	}

	public static Piece createWhiteQueen() {
		return createWhite(Type.QUEEN);
	}
	
	public static Piece createWhiteKnight() {
		return createWhite(Type.KNIGHT);
	}

	public static Piece createWhiteBishop() {
		return createWhite(Type.BISHOP);
	}
	
	public static Piece createBlackPawn() {
		return createBlack(Type.PAWN);
	}

	public static Piece createBlackBishop() {
		return createBlack(Type.BISHOP);
	}
	
	public static Piece createBlackRook() {
		return createBlack(Type.ROOK);
	}
	
	public static Piece createBlackKing() {
		return createBlack(Type.KING);
	}
	public static Piece createBlackQueen() {
		return createBlack(Type.QUEEN);
	}

	public static Piece createBlackKnight() {
		return createBlack(Type.KNIGHT);
	}
	

	public Color getColor() {
		return color;
	}


	public Type getType() {
		return type;
	}

	public static Piece createBlank() {
		return new Piece(Color.NOCOLOR, Type.NO_PIECE);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((color == null) ? 0 : color.hashCode());
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
		if (type != other.type)
			return false;
		return true;
	}
	
	
}
