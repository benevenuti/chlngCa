package mars.model;

/**
 * A Region represents an area from point x0,y0 to x1,y1
 * 
 * @author benevenuti
 *
 */
public class Region {
	
	private Coordinate iniPoint;
	
	private Coordinate endPoint;
	
	public Region(Integer initX, Integer initY, Integer endX, Integer endY) {
		iniPoint = new Coordinate(initX, initY);
		endPoint = new Coordinate(endX, endY);
	}

	public Region(Coordinate iniPoint, Coordinate endPoint) {
		this.iniPoint = iniPoint;
		this.endPoint = endPoint;
	}
	
	public Coordinate getEndPoint() {
		return endPoint;		
	}
	
	public Coordinate getIniPoint() {
		return iniPoint;
	}
	
	public Integer getInitX() {
		return iniPoint.getX();
	}
	
	public Integer getInitY() {
		return iniPoint.getY();
	}
	
	public Integer getEndX() {
		return endPoint.getX();
	}
	
	public Integer getEndY() {
		return endPoint.getY();
	}
	

	@Override
	public String toString() {
		return "Region [iniPoint=" + iniPoint + ", endPoint=" + endPoint + "]";
	}
	
	

}
