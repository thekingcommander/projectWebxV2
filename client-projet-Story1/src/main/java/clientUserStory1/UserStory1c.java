package clientUserStory1;

import java.util.List;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.core.MediaType;

import parserResponse.ParserXMLppnLibrary;
import scenarioClasses.ListLibraryPpn;

public class UserStory1c {
	
	public static void recupererLIstBUs(String ppn, List<ListLibraryPpn> listLibraryParPpn ){	
		//Attribut
      	Client client = ClientBuilder.newClient();
      	String person;
      	
      	//envoie de la requête
      	person = client.target("http://www.sudoc.fr/services/multiwhere/")
				.path(ppn)
				.request(MediaType.APPLICATION_ATOM_XML)
				.get(String.class);
 	 
      	//parser le résultat
      	listLibraryParPpn.add(ParserXMLppnLibrary.parserISBN2PPN(person));
	}  	
}
