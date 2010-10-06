package controllers;

import java.util.ArrayList;

import models.KnowledgeBase;
import models.User;
import play.mvc.With;
import play.*;
import play.data.validation.Required;
import play.mvc.*;
import java.util.*;
import play.db.jpa.*;

@With(Secure.class)
public class UserControll extends Controller {

	public static User connect(String name, String password) {
		ArrayList<User> users = KnowledgeBase.getInstance().getUsers();
		for (User u : users) {
			if (u.getName().equals(name) && u.getPassword().equals(password)) {
				return u;
				
			}

		}

		return null;
	}
	
	public static void profile() {
		String name = KnowledgeBase.getInstance().getCurrentUser().getName();
		render(name);
	}
}
