package models;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;


/** An abstract class in order to treat questions and answers as the same. **/

public abstract class AEntry {
	
	public final int ID;
	public int vote;
	public User owner;
	public Timestamp timestamp;
	public String contents;
	private ArrayList<Integer> voterID =  new ArrayList<Integer>();
	
	public AEntry(String contents, User owner) {
		this.ID = KnowledgeBase.getInstance().getQuestions().size();
		this.contents = contents;
		this.vote = 0;
		this.owner = owner;
		timestamp = new Timestamp(new Date().getTime()); 
		assert(contents != null && vote == 0 && timestamp != null);
	}
	
	public Timestamp getTimestamp() {
		return timestamp;
	}
	
	public String getContents() {
		return contents;
	}
	
	public int getVote() {
		return vote;
	}
	
	public User getOwner() {
		return this.owner;
	}
	
	public ArrayList<Integer> getVoterIDs() {
		return this.voterID;
	}
	
	public void vote(int value, int ID) {
		this.vote += value;
		this.voterID.add(ID);
	}
	 
}
