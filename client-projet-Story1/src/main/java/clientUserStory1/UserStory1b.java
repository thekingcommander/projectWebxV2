package clientUserStory1;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.core.MediaType;

import parserResponse.ParserXMLisbn2ppn;
import scenarioClasses.InformationLivre;
import scenarioClasses.PpnLivre;

public class UserStory1b {
	
	public static PpnLivre recupererIdentifiantPPN(String isbn, InformationLivre researchBook){		
		//Attribut
      	Client client = ClientBuilder.newClient();
      	PpnLivre isbnPpnInfo = new PpnLivre();
      	String person;
      	
      	//Envoi de la requête
		person = client.target("http://www.sudoc.fr/services/isbn2ppn/")
				.path(isbn)
	            .request(MediaType.APPLICATION_ATOM_XML)
	            .get(String.class);
	 	 	 
		 //Parser le résultat
		 isbnPpnInfo.setIsbn(isbn);
		 isbnPpnInfo = ParserXMLisbn2ppn.parserISBN2PPN(person, researchBook.getISBN());   	 
		 
		 return isbnPpnInfo;
	}		 	 
}