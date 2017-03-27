package userStory1TestIntegration;

import static org.junit.Assert.*;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

import org.json.JSONException;

import org.junit.BeforeClass;
import org.junit.Test;

import clientUserStory1.UserStory1a;
import clientUserStory1.UserStory1b;
import clientUserStory1.UserStory1c;
import clientUserStory1.UserStory1d;
import clientUserStory1.UserStory1e;
import scenarioClasses.InformationLivre;
import scenarioClasses.ListLibraryPpn;
import scenarioClasses.PpnLivre;
import scenarioClasses.UserInformation;


public class UserStoryIntegrationTest {

	private static PpnLivre isbnPpnInfo;
	private static List<ListLibraryPpn> listLibraryParPpn;
	private static UserInformation user;
	private static List<Float> distanceList;
	private static InformationLivre researchBook;

	
	@BeforeClass
	public static void initTest() throws UnsupportedEncodingException, JSONException {
		isbnPpnInfo = new PpnLivre();
		listLibraryParPpn = new ArrayList<ListLibraryPpn>();
		user = new UserInformation();
		distanceList = new ArrayList<Float>();
		researchBook = new InformationLivre();

		// User story 1a: on donne un doi en paramètre
		researchBook = UserStory1a.recupererInfoDocument("10.1007/978-3-662-07964-5");
		// User story 1b
		isbnPpnInfo = UserStory1b.recupererIdentifiantPPN(researchBook.getISBN(), researchBook);
		// User story 1c
		UserStory1c.recupererLIstBUs(isbnPpnInfo.getResult().get(0), listLibraryParPpn);
		// User story 1d
		user = UserStory1d.recupererCoordonneeGeographiqueAvecAdressePostale("15 rue Paul Decamps, Toulouse");
		// User story 1e
		distanceList = UserStory1e.recupererDistanceVolOiseau(user, listLibraryParPpn.get(0).getListLibrary());
	}
	
	

	@Test
	public void testIntegration(){
		// isbn
		assertEquals(isbnPpnInfo.getResult().get(0), "156358263");
		assertEquals(isbnPpnInfo.getResultLength(), 1);

		// listLibraryParPpn
		assertEquals(listLibraryParPpn.get(0).getListLibrary().get(0).getLatitude(), 43.56755709999999, 0.001);
		assertEquals(listLibraryParPpn.get(0).getListLibrary().get(1).getShortname(), "METZ-UL-BU METZ MOSELLE");

		// user
		assertEquals(user.getLongitude(), 1.4170895, 0.001);
		assertEquals(user.getAdressePostale(),
				"15, Rue Paul Décamps, Fontaine Bayonne - Cartoucherie, Toulouse Rive Gauche, Toulouse, Haute-Garonne, Occitanie, 31300, France");

		// distanceList
		assertEquals(distanceList.get(1), 7.2797475, 0.01);

	}
}
