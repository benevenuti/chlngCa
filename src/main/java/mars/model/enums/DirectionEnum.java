package mars.model.enums;

public enum DirectionEnum {
	NORTH("N"), SOUTH("S"), EAST("E"), WEST("W");
	
	private String value;
	
	private DirectionEnum(String dir) {
		this.value = dir;		
	}
	
	public String getDir() {
		return this.value;
	}
}
