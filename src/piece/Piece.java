package piece;
import design.Design;

public class Piece {

	private final String origin;
	private final int rotation;
	private final Design north;
	private final Design east;
	private final Design south;
	private final Design west;
	
	public Piece(String origin, int rotation, Design north, Design east, Design south, Design west) {
		this.origin = origin;
		this.rotation = rotation;
		this.north = north;
		this.east = east;
		this.south = south;
		this.west = west;
	}
	
	public Piece(String origin, int rotation, Design[] designs){
		this(origin, rotation, designs[0], designs[1], designs[2], designs[3]);
	}
	
	public String getOrigin() {
		return origin;
	}
	
	public boolean canBeToTheWestOf(Piece piece){
		return this.east.matches(piece.west);
	}
	
	public boolean canBeToTheNorthOf(Piece piece){
		return this.south.matches(piece.north);
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
				west.toString() + " | | " + east.toString() + "    " + origin + rotation +"\n" + 
				"    -\n" +
				"   " + south.toString() + "\n";
	}

}
