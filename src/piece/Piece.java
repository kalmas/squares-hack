package piece;
import design.Design;

public class Piece {

	private final Design north;
	private final Design east;
	private final Design south;
	private final Design west;
	
	public Piece(Design north, Design east, Design south, Design west) {
		this.north = north;
		this.east = east;
		this.south = south;
		this.west = west;
	}
	
	public Piece(Design[] designs){
		this(designs[0], designs[1], designs[2], designs[3]);
	}
	
	public Design[] getDesigns(){
		Design[] designs = new Design[4];
		designs[0] = north;
		designs[1] = east;
		designs[2] = south;
		designs[3] = west;
		
		return designs;
	}
	
	public String draw(){
		return  "   " + north.toString() + "\n" +
				"    _\n" +
				west.toString() + " | | " + east.toString() + "\n" +
				"    -\n" +
				"   " + south.toString() + "\n";
	}

}
