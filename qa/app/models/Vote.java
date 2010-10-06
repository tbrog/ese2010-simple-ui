package models;

public class Vote {

	
	private int value;
	private AEntry entry;
	
	public Vote(int value, AEntry entry, User u) {
		entry.vote(value, u.id);
		this.value = value;
		this.entry = entry;
	}
	
	
	public int getValue() {
		return value;
	}
	
	public AEntry getEntry() {
		return entry;
	}
}
