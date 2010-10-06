package controllers;

import models.*;

public class Security extends Secure.Security {
	
	static boolean authentify(String username, String password) {
	    User u = UserControll.connect(username, password);
	    KnowledgeBase.getInstance().setCurrentUser(u);
	    return	u != null;
	   
	}

}
