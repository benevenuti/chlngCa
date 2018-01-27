package mars.model;

import mars.model.enums.DirectionEnum;

/**
 * A position is a point x,y in the Cartesian plan plus a direction [N, E, S, W]
 * @author benevenuti
 *
 */
public class Position extends Coordinate {
	
	private DirectionEnum d;
	
	public Position() {
		super();
		this.d = DirectionEnum.NORTH;
	}

	public Position(Integer x, Integer y, DirectionEnum d) {
		super(x, y);
		this.d = d;
	}

	public DirectionEnum getD() {
		return d;
	}

	public void setD(DirectionEnum d) {
		this.d = d;
	}

	@Override
	public String toString() {
		return "(" + super.toString() + ", " + d.getDir() + ")";
	}
	

}
