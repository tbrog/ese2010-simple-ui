package models;

import java.util.ArrayList;





public class User  {

	public String name;
	public String password;
	public final int id;
	public ArrayList<Question> questions;
	public ArrayList<Answer> answers;
	public ArrayList<Vote> votes = new ArrayList<Vote>();
	
	public User(String name, String password, int id) {
		this.name = name;
		questions = new ArrayList<Question>();
		answers = new ArrayList<Answer>();
		this.password = password;
		this.id = id;
		
	}
	
	public void putQuestion(String contents) {
		Question question = new Question(contents, this);
		KnowledgeBase.getInstance().addQuestion(question);
		this.questions.add(question);
	}
	
	public void answerQuestion(String contents, Question question) {
		Answer answer = new Answer(contents, this, question);
		question.answerQuestion(answer);
		answers.add(answer);
		
	}
	
	public String getName() {
		return this.name;
	}
	
	public ArrayList<Vote> getVotes() {
		return votes;
	}
	
	public ArrayList<Answer> getAnswers() {
		return answers;
	}
	
	public ArrayList<Question> getQuestions() {
		return questions;
	}
	
	public void upVote(AEntry entry) {
		Vote vote = new Vote(1, entry, this);
		votes.add(vote);
	}

	public void downVote(AEntry entry) {
		Vote vote = new Vote(-1, entry, this);
		votes.add(vote);
		
	}

	public String getPassword() {
		return this.password;
	}
}
