package parserResponse;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import scenarioClasses.Author;
import scenarioClasses.InformationLivre;

public class ParserJSONInfoDocument {
	
	
	
	public static InformationLivre  parserInfoDocument(String parsedDoc) throws JSONException{
	
		String nom, orcid, given;
		InformationLivre researchBook = new InformationLivre();
		String isbn = "";
		
		//parser
		JSONObject json  = new JSONObject(parsedDoc);
		JSONObject jsonarr= json.getJSONObject("message");
		
		//Récupération des attributs
		JSONArray jsontitle= jsonarr.getJSONArray("title");
		JSONArray jsonauthor= jsonarr.getJSONArray("author");
		JSONArray jsonISBN;
		
		if (jsonarr.has("ISBN"))
		{	
			jsonISBN= jsonarr.getJSONArray("ISBN");	
			//Dans le cas où l'isbn n'est pas directement donné sous forme de nombre mais sous forme d'adresse
			if (jsonISBN.getString(0).contains("isbn"))
			{	
				String[] parts = jsonISBN.getString(0).split("isbn/");
				isbn = parts[1];
			}
			else
				isbn = jsonISBN.getString(0);	
			//On remplit notre isbn
			researchBook.setISBN(isbn);
		}
		
	
		//remplir notre classe
		researchBook.setTitle(jsontitle.getString(0));
		
		for (int i=0; i < jsonauthor.length(); i++)
		{
			nom = jsonauthor.getJSONObject(i).getString("family");
			
			if (jsonauthor.getJSONObject(i).has("ORCID"))
				orcid = jsonauthor.getJSONObject(i).getString("ORCID");
			else 
				orcid = null;
			
			given = jsonauthor.getJSONObject(i).getString("given");	
			researchBook.addAuthor(new Author(orcid, given, nom, null));
		}
		
		return researchBook;
	}
}
