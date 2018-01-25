package hello;

public enum Direction {
	NORTH("N"), SOUTH("S"), EAST("E"), WEST("W");
	
	private String value;
	
	private Direction(String dir) {
		this.value = dir;		
	}
	
	public String getDir() {
		return this.value;
	}
}
