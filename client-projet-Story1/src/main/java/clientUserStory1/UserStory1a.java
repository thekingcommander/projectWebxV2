package clientUserStory1;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.core.MediaType;

import org.json.JSONException;

import parserResponse.ParserJSONInfoDocument;
import scenarioClasses.InformationLivre;

public class UserStory1a {
	
	
	public static InformationLivre recupererInfoDocument(String doi) throws JSONException{
		
		InformationLivre researchBook = new InformationLivre();	
		//Envoi de la requête
		Client client = ClientBuilder.newClient();
		String person = client.target("http://api.crossref.org/works/")
							  .path(doi)
		                      .request(MediaType.APPLICATION_JSON)
		                      .get(String.class);
	
		//parser le résultat
		researchBook =  ParserJSONInfoDocument.parserInfoDocument(person);	
		return researchBook;
	}	
}
