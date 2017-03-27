package userStory1TestUnitaire;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import clientUserStory1.UserStory1d;
import scenarioClasses.UserInformation;

public class UserStory1dTest {
	
		private static UserInformation user;

	
	    @BeforeClass
	    public static void initTest() {
	    	user = new UserInformation();
	    }
	    
	    
	    @Before
	    public void beforeEachTest() {
	    	user = UserStory1d.recupererCoordonneeGeographiqueAvecAdressePostale("15 rue Paul Decamps, Toulouse");
	    }
	    
	    @Test
	    public void testAdressePostale(){	
	        assertEquals(user.getAdressePostale(), "15, Rue Paul Décamps, Fontaine Bayonne - Cartoucherie, Toulouse Rive Gauche, Toulouse, Haute-Garonne, Occitanie, 31300, France");
	   }
	    
	    
	    @Test
	    public void testLongitude(){
	        assertEquals(user.getLongitude(), 1.4170895, 0.001);
	   }

	    
	    @Test
	    public void testLatitude(){	
	        assertEquals(user.getLatitude(), 43.6038246, 0.001);
	   }
}
