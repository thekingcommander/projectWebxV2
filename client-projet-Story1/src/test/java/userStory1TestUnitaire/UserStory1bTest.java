package userStory1TestUnitaire;

import static org.junit.Assert.*;

import org.json.JSONException;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import clientUserStory1.UserStory1a;
import clientUserStory1.UserStory1b;
import scenarioClasses.InformationLivre;
import scenarioClasses.PpnLivre;

public class UserStory1bTest {

	private static InformationLivre researchBook;
	private static PpnLivre isbnPpnInfo;

	@BeforeClass
	public static void initTest() {
		researchBook = new InformationLivre();
		isbnPpnInfo = new PpnLivre();
	}

	@Before
	public void beforeEachTest() throws JSONException {
		researchBook = UserStory1a.recupererInfoDocument("10.1007/978-3-662-07964-5");
		isbnPpnInfo = UserStory1b.recupererIdentifiantPPN(researchBook.getISBN(), researchBook);
	}

	@Test
	public void testPpn(){
		assertEquals(isbnPpnInfo.getResult().get(0), "156358263");
	}

	@Test
	public void testResulttNoHoldingSize() {
		assertEquals(isbnPpnInfo.getResultNoHolding(), 0);
	}

	@Test
	public void testResultSize(){
		assertEquals(isbnPpnInfo.getResultLength(), 1);
	}

}
