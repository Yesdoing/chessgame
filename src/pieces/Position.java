package pieces;

public class Position {
	int xPos, yPos;
	
	public Position(String position) {
		char x = position.charAt(0);
		xPos = x - 'a';
		char y = position.charAt(1);
		yPos = Character.getNumericValue(y)-1;
	}

	public Position(int x, int y) {
		this.xPos = x;
		this.yPos = y;
	}
	
	public int getxPos() {
		return xPos;
	}

	public int getyPos() {
		return yPos;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + xPos;
		result = prime * result + yPos;
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
		Position other = (Position) obj;
		if (xPos != other.xPos)
			return false;
		if (yPos != other.yPos)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Position [xPos=" + xPos + ", yPos=" + yPos + "]";
	}
	

	
}
