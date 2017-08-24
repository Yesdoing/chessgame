package pieces;


public class Piece {
	public enum Color {
		WHITE, BLACK, NOCOLOR;
	}
	
	public enum Type {
		PAWN('p'), KNIGHT('n'), ROOK('r'), BISHOP('b'), QUEEN('q'), KING('k'), NO_PIECE('x');
		
		private char representation;
		
		Type (char representation) {
			this.representation = representation;
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
		return this.color.equals(Color.BLACK);
	}
	
	public boolean isWhite() {
		return this.color.equals(Color.WHITE);
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
}
