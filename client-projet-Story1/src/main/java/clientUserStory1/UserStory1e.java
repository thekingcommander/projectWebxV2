package clientUserStory1;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.core.MediaType;

import org.json.JSONException;

import parserResponse.ParserJSONDistance;
import scenarioClasses.Library;
import scenarioClasses.UserInformation;

public class UserStory1e {
	
	
	public static List<Float> recupererDistanceVolOiseau(UserInformation user,List<Library> listPpnLibrary) throws UnsupportedEncodingException, JSONException{
		
		//Attribut
      	Client client = ClientBuilder.newClient();
      	String param1, param2, cheminVoulu, information;
      	List<Float> distanceList = new ArrayList<Float>();
      	StringBuilder pathCoordonnee = new StringBuilder();

		 //encoding
		 param1 = "4326";
		 param2 = "";
		 pathCoordonnee.append(URLEncoder.encode("[", "UTF-8"));

		 
		 //Test
		 int value;
		 
		 if (listPpnLibrary.size() > 20)
			 value = 20;
		 else 
			 value = listPpnLibrary.size();
		 
		 for (int i=0; i < value; i++)
		 { 
				 param2 = URLEncoder.encode("{\"paths\":[[[" + user.getLongitude() +"," + user.getLatitude() + "],[" 
						 					+ listPpnLibrary.get(i).getLongitude() + "," + listPpnLibrary.get(i).getLatitude() + "]]]}", "UTF-8");				 
				 pathCoordonnee.append(param2);
				 
				 //rajout de la virgule encodée
				 if (i != value - 1)
					 pathCoordonnee.append(URLEncoder.encode(",", "UTF-8"));				 			 
		 }		 
		 
		 //Ajout du crochet fermant
		 pathCoordonnee.append(URLEncoder.encode("]", "UTF-8"));
		 //Concaténation de l'uri
		 cheminVoulu =  "http://sampleserver1.arcgisonline.com/ArcGIS/rest/services/Geometry/GeometryServer/lengths?sr=" + param1 + "&polylines=" + pathCoordonnee + "&f=json";
		 
		 //Envoi de la requête
		 information = client.target(cheminVoulu)
	              .request(MediaType.APPLICATION_JSON)
	              .get(String.class);
		 
		 distanceList = ParserJSONDistance.parserInfoDocument(information);   
		 return distanceList;
	}	 
}
