package clientUserStory1;

import java.net.URLEncoder;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.core.MediaType;

import parserResponse.ParserXMLUserAdress;
import scenarioClasses.UserInformation;


public class UserStory1d {
	
	@SuppressWarnings("deprecation")
	public static UserInformation recupererCoordonneeGeographiqueAvecAdressePostale(String adresse){	
		 //Attribut
      	 Client client = ClientBuilder.newClient();
      	 StringBuilder pathTmp = new StringBuilder();
      	 String person;
      	UserInformation user;
      	
      	 //Encoder l'adresse avant de l'envoyer
    	 String adressePostale = adresse;
       	 adressePostale = URLEncoder.encode(adressePostale);

       	 
       	 //reset notre stringbuilder
       	 pathTmp.setLength(0);
       	 pathTmp.append(adressePostale);
       	 pathTmp.append("&format=xml&polygon=1&addressdetails=1");
      	
      	//Envoi de la requête
      	 person = client.target("http://nominatim.openstreetmap.org/search?q=" + pathTmp)
  				.path(pathTmp.toString())
                 .request(MediaType.APPLICATION_ATOM_XML)
                 .get(String.class);
	 	 	 
    	 //récupérer les informations du user
       	 user = ParserXMLUserAdress.parserAdresse(person);		 
		 return user;
	}		 	 
}