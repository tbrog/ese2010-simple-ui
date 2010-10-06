

import static org.junit.Assert.*;

import org.junit.Test;

import models.KnowledgeBase;
import models.User;


public class UserTest {

	@Test
	public void userShouldHaveAName() {
		User mark = new User("Mark", "33", 2);
		assertTrue(mark.getName().equals("Mark"));
	}
	
	
	@Test
	public void shouldCreateQuestionCorrectly() {
		User mark = new User("Mark", "33", 4);
		mark.putQuestion("Why is it grey?");
		assertFalse(mark.getQuestions().isEmpty());
		assertTrue(mark.getQuestions().get(0).getOwner().equals(mark));
	}

	@Test
	public void shouldCreateUser() {
		KnowledgeBase base = KnowledgeBase.getInstance();
		base.createUser("Mark", "345");
		assertTrue(base.getUsers().get(0).getName().equals("Mark"));
		base.getUsers().get(0).putQuestion("Why?");
		assertTrue(base.getUsers().get(0).getQuestions().get(0).getContents().equals("Why?"));
		
	}
	
}
