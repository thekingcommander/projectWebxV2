package userStory1TestUnitaire;

import static org.junit.Assert.*;

import org.json.JSONException;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import clientUserStory1.UserStory1a;
import scenarioClasses.InformationLivre;

public class UserStory1aTest {
	
		private static InformationLivre researchBook;

	
	    @BeforeClass
	    public static void initTest() {
	    	researchBook = new InformationLivre();
	    }
	    
	    
	    @Before
	    public void beforeEachTest() throws JSONException {
	    	researchBook = UserStory1a.recupererInfoDocument("10.1007/978-3-662-07964-5");
	    }
	    
	    @Test
	    public void testTitle() {	
	        assertEquals(researchBook.getTitle(), "Interactive Theorem Proving and Program Development");
	   }
	    
	    @Test
	    public void testISBN(){	
	        assertEquals(researchBook.getISBN(), "978-3-642-05880-6");
	   }
	    
	    
	    @Test
	    public void authorSize(){	
	        assertEquals(researchBook.getListAuteur().size(), 2);
	   }




}
