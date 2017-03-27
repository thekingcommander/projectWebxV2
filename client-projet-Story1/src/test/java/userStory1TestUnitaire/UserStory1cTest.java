package userStory1TestUnitaire;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONException;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import clientUserStory1.UserStory1c;
import scenarioClasses.ListLibraryPpn;


public class UserStory1cTest {

	private static List<ListLibraryPpn> listLibraryParPpn;

	@BeforeClass
	public static void initTest() {
		listLibraryParPpn =  new ArrayList<ListLibraryPpn>();
	}

	@Before
	public void beforeEachTest() {
		UserStory1c.recupererLIstBUs("156358263", listLibraryParPpn);
	}
	

	@Test
	public void testlatitudeIndex0(){
		assertEquals(listLibraryParPpn.get(0).getListLibrary().get(0).getLatitude(), 43.56755709999999, 0.001);
	}

	@Test
	public void testLongitudeIndex1(){
		assertEquals(listLibraryParPpn.get(0).getListLibrary().get(1).getLongitude(), 6.164786, 0.001);
	}

	@Test
	public void testListSize(){
		assertEquals(listLibraryParPpn.get(0).getListPpn(), 2);
	}
	
	@Test
	public void testShortnameIndex1(){
		assertEquals(listLibraryParPpn.get(0).getListLibrary().get(1).getShortname(), "METZ-UL-BU METZ MOSELLE");
	}
}
