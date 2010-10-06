import org.junit.*;

import controllers.UserControll;

import java.util.*;
import play.test.*;
import models.*;

public class BasicTest extends UnitTest {

    @Test
    public void aVeryImportantThingToTest() {
        assertEquals(2, 1 + 1);
    }
    
    
    @Test
    public void testUserAuthentication() {
    	KnowledgeBase.getInstance().createUser("Henry", "12345");
    	
    	assertNotNull(UserControll.connect("Henry", "12345"));
    }
    
    
    @Test
    public void usersShouldnotbenull() {
    	assertNotNull(KnowledgeBase.getInstance().getUsers());
    }

}
