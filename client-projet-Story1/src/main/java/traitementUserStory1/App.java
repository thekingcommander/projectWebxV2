package traitementUserStory1;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

import org.json.JSONException;

import clientUserStory1.UserStory1a;
import clientUserStory1.UserStory1b;
import clientUserStory1.UserStory1c;
import clientUserStory1.UserStory1d;
import clientUserStory1.UserStory1e;
import scenarioClasses.InformationLivre;
import scenarioClasses.ListLibraryPpn;
import scenarioClasses.PpnLivre;
import scenarioClasses.UserInformation;

/**
 * 
 * @author Admin
 *
 */
public class App 
{
    public static void main( String[] args ) throws JSONException, UnsupportedEncodingException
    {
    	InformationLivre researchBook = new InformationLivre();
    	PpnLivre isbnPpnInfo = new PpnLivre();
    	List<ListLibraryPpn> listLibraryParPpn =  new ArrayList<ListLibraryPpn>();
      	UserInformation user = new UserInformation();
		@SuppressWarnings("unused")
		List<Float> distanceList = new ArrayList<Float>();
		
    	//User story 1a: on donne un doi en paramètre  	 
		researchBook =  UserStory1a.recupererInfoDocument("10.1007/978-3-662-07964-5");
		//researchBook =  UserStory1a.recupererInfoDocument("10.1007/978-0-387-70914-7");
			
    	//User story 1b
    	isbnPpnInfo = UserStory1b.recupererIdentifiantPPN(researchBook.getISBN(), researchBook);
    	//User story 1c
    	UserStory1c.recupererLIstBUs(isbnPpnInfo.getResult().get(0), listLibraryParPpn);
    	//User story 1d
    	user = UserStory1d.recupererCoordonneeGeographiqueAvecAdressePostale("35 rue Paul Decamps, Toulouse");
    	//User story 1e
    	distanceList = UserStory1e.recupererDistanceVolOiseau(user, listLibraryParPpn.get(0).getListLibrary());
    }
}
