package design;

public abstract class Design {
	
	public static final String FRONT = "front";
	public static final String REAR = "rear";
	
	private final String section;
	protected final char avatar;

	public Design(char avatar, String section) {
		this.section = section;
		this.avatar = avatar;
	}
	
	/**
	 * Does this design match given design
	 * Hint: FRONT matches REAR
	 */
	public boolean matches(Design design){
		if(design.getAvatar() != this.getAvatar()) {
			return false;
		}
		
		return (design.getSection() != this.getSection());
	}
	
	public String getSection() {
		return section;
	}

	public char getAvatar() {
		return avatar;
	}
	
	public String toString() {
		if(section == Design.FRONT){
			return avatar + "1";
		}
		
		return avatar + "2";
	}
	
}
