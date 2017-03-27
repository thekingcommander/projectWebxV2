package userStory1TestUnitaire;

import static org.junit.Assert.*;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

import org.json.JSONException;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import clientUserStory1.UserStory1c;
import clientUserStory1.UserStory1e;
import scenarioClasses.ListLibraryPpn;
import scenarioClasses.UserInformation;

public class UserStory1eTest {
	
		private static List<Float> distanceList;
		private static List<ListLibraryPpn> listLibraryParPpn;

	
	    @BeforeClass
	    public static void initTest() {
	    	distanceList = new ArrayList<Float>();
	    	listLibraryParPpn = new ArrayList<ListLibraryPpn>();
	    	
	    }
	    
	    
	    @Before
	    public void beforeEachTest() throws UnsupportedEncodingException, JSONException {  	
	    	//Permet de récupérer la liste ddes BUs avec leur coordonnée en fonction du ppn
	    	UserStory1c.recupererLIstBUs("156358263", listLibraryParPpn);
	    	distanceList = UserStory1e.recupererDistanceVolOiseau(new UserInformation("15 rue Paul Decamps",(float) 43.6038246,(float) 1.4170895), 
	    			listLibraryParPpn.get(0).getListLibrary());
	    }
	    
	    
	    @Test
	    public void testDistanceList() throws JSONException {	
	        assertEquals(distanceList.size(), 2);
	   }
	    
	    
	    @Test
	    public void testDistanceValeuIndex1() throws JSONException {	
	        assertEquals(distanceList.get(1), 7.2797475, 0.01 );
	   }
}
