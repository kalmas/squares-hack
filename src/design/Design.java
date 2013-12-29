package design;

public abstract class Design {
	
	public static final String FRONT = "front";
	public static final String REAR = "rear";
	
	private final String section;
	protected final char avatar;
	
	public String getSection() {
		return section;
	}

	public char getAvatar() {
		return avatar;
	}

	public Design(char avatar, String section) throws Exception {
		switch(section){
			case FRONT:
			case REAR:
				this.section = section;
				this.avatar = avatar;
				return;
			default:
				throw new Exception();
		}
	}
	
	public boolean matches(Design design){
		if(design.getAvatar() != this.getAvatar()) {
			return false;
		}
		
		return (design.getSection() != this.getSection());
	}
	
	public String toString() {
		if(section == Design.FRONT){
			return avatar + "1";
		}
		
		return avatar + "2";
	}
	
}
