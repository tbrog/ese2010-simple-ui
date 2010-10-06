package models;

import java.util.ArrayList;


public class Question extends AEntry{
	
	private ArrayList<Answer> answers;
	
	public Question(String contents, User owner) {
		super(contents, owner);
		answers = new ArrayList<Answer>();
	}
	
	public void answerQuestion(Answer answer) {
		answers.add(answer);
	}
	
	public ArrayList<Answer> getAnswers() {
		return answers;
	}
	
	
	
}

