package mars.business;

import mars.model.Position;
import mars.model.Region;
import mars.model.enums.DirectionEnum;

public class Navigator {

	// TODO should validate mrl and MRL?
	public static final String REGEX_VALID_MOVES = "[MRL]+";

	/**
	 * Verify if a sequence of moves may be valid
	 * @param moves String that codes the moves 
	 */
	private static void validateMoves(String moves) {
		if (moves != null && moves.matches(REGEX_VALID_MOVES)) {
			//System.out.println("Valid moves [" + moves + "]");
		} else {
			throw new IllegalArgumentException("Invalid moves [" + moves + "]");
		}
	}

	/**
	 * Do the navigation considering a sequence of moves through a region  
	 * @param moves String that codes the moves 
	 * @param region The region in the coordinates from initial point to the end point
	 * @return The Position after navigation occurs
	 */
	public static Position navigate(String moves, Region region) {
		validateMoves(moves);

		Position position = new Position();

		for (int i = 0; i < moves.length(); i++) {
			char c = moves.charAt(i);
	
			if (c == 'L') {
				RotateLeft(position);
			} else if (c == 'R') {
				RotateRight(position);
			} else if (c == 'M') {
				Move(position, region);
			}
		}

		return position;
	}

	/**
	 * Throws exception if invalid; nothing if valid
	 * @param p Current Position
	 * @param r Current Region
	 */
	private static void ValidateFinalPosition(Position p, Region r) {
		// validate y
		if ((p.getX() < r.getIniPoint().getX()) || (p.getX() > r.getEndPoint().getX())) {
			throw new IllegalArgumentException("Bad move [x = " + p.getX() + "]");
		}
		if ((p.getY() < r.getIniPoint().getY()) || (p.getY() > r.getEndPoint().getY())) {
			throw new IllegalArgumentException("Bad move [y = " + p.getY() + "]");
		}

	}
	
	
	/**
	 * Moves the position across the region towards the Direction in from the current Coordinates  
	 * @param p Current Position
	 * @param r Current Region
	 */
	private static void Move(Position p, Region r) {

		switch (p.getD()) {
		case NORTH:
			p.setY(p.getY() + 1);
			break;
		case WEST:
			p.setX(p.getX() - 1);
			break;
		case SOUTH:
			p.setY(p.getY() - 1);
			break;
		case EAST:
			p.setX(p.getX() + 1);
			break;

		default:
			throw new IllegalArgumentException("Bad move");
		}

		ValidateFinalPosition(p, r);
	}

	/**
	 * Rotate the current position to the Left
	 * @param p Current Position
	 */
	private static void RotateLeft(Position p) {
		switch (p.getD()) {
		case NORTH:
			p.setD(DirectionEnum.WEST);
			break;
		case WEST:
			p.setD(DirectionEnum.SOUTH);
			break;
		case SOUTH:
			p.setD(DirectionEnum.EAST);
			break;
		case EAST:
			p.setD(DirectionEnum.NORTH);
			break;

		default:
			throw new IllegalArgumentException("Bad direction");
		}
	}

	/**
	 * Rotate the current position to the Right
	 * @param p Current Position
	 */
	private static void RotateRight(Position p) {
		switch (p.getD()) {
		case NORTH:
			p.setD(DirectionEnum.EAST);
			break;
		case EAST:
			p.setD(DirectionEnum.SOUTH);
			break;
		case SOUTH:
			p.setD(DirectionEnum.WEST);
			break;
		case WEST:
			p.setD(DirectionEnum.NORTH);
			break;

		default:
			throw new IllegalArgumentException("Bad direction");
		}
	}

}
