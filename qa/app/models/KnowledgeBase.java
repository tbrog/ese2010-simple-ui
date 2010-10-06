package models;

import java.util.ArrayList;
import java.util.List;

public final class KnowledgeBase {

	private static KnowledgeBase instance;
	private ArrayList<User> users;
	private ArrayList<Question> questions = new ArrayList<Question>();
	private User currentUser;

	private KnowledgeBase() {
		this.users = new ArrayList<User>();
	}

	public synchronized static KnowledgeBase getInstance() {
		if (instance == null) {
			instance = new KnowledgeBase();
		}
		return instance;
	}

	public void createUser(String name, String password) {
		int id = this.users.size();
		User user = new User(name, password, id);
		this.users.add(user);

	}

	public ArrayList<User> getUsers() {
		return this.users;
	}

	public ArrayList<Question> getQuestions() {
		return this.questions;
	}
	
	public void addQuestion(Question q) {
		questions.add(q);
	}
	public void deleteUser(User user) {
		for (int i = 0; i < user.getVotes().size(); i++) {
			int value = user.getVotes().get(i).getValue();
			user.getVotes().get(i).getEntry().vote(-value, user.id);
		}
		for (int i = 0; i < user.getAnswers().size(); i++) {
			user.getAnswers().get(0).getQuestion().getAnswers().remove(
					user.getAnswers().get(i));
		}

		users.remove(user);
		user = null;
	}

	public void setCurrentUser(User user) {
		this.currentUser = user;

	}

	public User getCurrentUser() {
		return this.currentUser;
	}
	
	public  void sortQuestions() {
		for(int i = 0; i < this.questions.size()-1; i++) {
			if(questions.get(i).getVote() < questions.get(i+1).getVote()) {
				questions.add(i+1, questions.remove(i));
			}
		}
	}
}
