package models;

public class Answer extends AEntry{

	private Question question;
	
	public Answer(String contents, User owner, Question question) {
		super(contents, owner);
		this.question = question;
	}

	
	public Question getQuestion() {
		return question;
	}
	
}
