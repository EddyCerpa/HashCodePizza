package Tipos;

public class Slice {
	private Position positionIni;
	private Position positionEnd;
	
	private int tomatoes;
	private int mushroom;
	
	public Slice(Position positionIni, Position positionEnd, int tomatoes, int mushroom) {
		this.positionIni = positionIni;
		this.positionEnd = positionEnd;
		this.tomatoes = tomatoes;
		this.mushroom = mushroom;
	}

	public Position getPositionIni() {
		return positionIni;
	}

	public void setPositionIni(Position positionIni) {
		this.positionIni = positionIni;
	}

	public Position getPositionEnd() {
		return positionEnd;
	}

	public void setPositionEnd(Position positionEnd) {
		this.positionEnd = positionEnd;
	}

	public int getTomatoes() {
		return tomatoes;
	}

	public void setTomatoes(int tomatoes) {
		this.tomatoes = tomatoes;
	}

	public int getMushroom() {
		return mushroom;
	}

	public void setMushroom(int mushroom) {
		this.mushroom = mushroom;
	}
	
	public int getSize() {
		return (this.positionEnd.getRow() - this.positionIni.getRow()) * (this.positionEnd.getColumn() - this.positionIni.getColumn());
	}
}
