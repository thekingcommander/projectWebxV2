package webx.client_jersey_tests;

import static org.junit.Assert.*;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;

import org.glassfish.grizzly.http.server.HttpServer;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import webx.client_jersey.traitement_Requete.Main;
import webx.client_jersey.utils.TraitementServiceJersey;

public class MyResourceTest {

	private HttpServer server;
	private WebTarget target;
	private String requeteFormatXML;
	private String resultatAttendu;

	@Before
	public void setUp() throws Exception {
		// requête
		requeteFormatXML = "<requestType><adresse>15 rue Paul Decamps</adresse><doi>10.1007/978-3-662-07964-5</doi></requestType>";
		// reponse attendue
		resultatAttendu = TraitementServiceJersey.resultatAttenduWIthFirstDOIGiven();

		// start the server
		server = Main.startServer();
		// create the client
		Client c = ClientBuilder.newClient();
		target = c.target(Main.BASE_URI);
	}

	@SuppressWarnings("deprecation")
	@After
	public void tearDown() throws Exception {
		server.stop();
	}

	/**
	 * Test to see that the message "Got it!" is sent in the response.
	 */
	@Test
	public void testGetIt() {
		// Envoi de la requête
		String resultat = target.path("myresource").request(MediaType.APPLICATION_XML).accept(MediaType.TEXT_PLAIN)
				.post(Entity.xml(requeteFormatXML), String.class);
		
	}
}
