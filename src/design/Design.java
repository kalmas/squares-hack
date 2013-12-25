package design;

public abstract class Design {
	
	public static final String FRONT = "front";
	public static final String REAR = "rear";
	
	private String section;
	protected char avatar;
	
	public Design(String section) throws Exception {
		switch(section){
			case FRONT:
			case REAR:
				this.section = section;
				return;
			default:
				throw new Exception();
		}
	}
	
	public String toString() {
		if(section == Design.FRONT){
			return avatar + "1";
		}
		
		return avatar + "2";
	}
	
}
