package hello;

public class Position extends Coordinate {
	
	private Direction d;
	
	public Position() {
		super();
		this.d = Direction.NORTH;
	}

	public Position(Integer x, Integer y, Direction d) {
		super(x, y);
		this.d = d;
	}

	public Direction getD() {
		return d;
	}

	public void setD(Direction d) {
		this.d = d;
	}

	@Override
	public String toString() {
		return "(" + super.toString() + ", " + d.getDir() + ")";
	}
	

}
