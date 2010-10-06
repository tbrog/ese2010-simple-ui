package controllers;

import play.*;
import play.jobs.*;
import play.test.*;
 
import models.*;
 
@OnApplicationStart
public class Bootstrap extends Job {
 
    public void doJob() {
        // Check if the database is empty
        
            KnowledgeBase.getInstance().createUser("Karl", "elefant");
            KnowledgeBase.getInstance().getUsers().get(0).putQuestion("Is this the case?");
           
            
        
            
            KnowledgeBase.getInstance().createUser("Peter", "feletant");
            KnowledgeBase.getInstance().getUsers().get(1).putQuestion("How old is a turtle?");
            
            KnowledgeBase.getInstance().createUser("Tom", "telefant");
            KnowledgeBase.getInstance().getUsers().get(2).putQuestion("Why is a raven like a writing desk?");
            KnowledgeBase.getInstance().getUsers().get(2).putQuestion("What's this?");
            
            
            KnowledgeBase.getInstance().getUsers().get(0).answerQuestion("At least one day", KnowledgeBase.getInstance().getUsers().get(1).getQuestions().get(0));
    	}
 
}