package webx.client_jersey.utils;

import java.io.StringReader;
import java.io.StringWriter;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

import javax.xml.transform.OutputKeys;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;

import org.json.JSONException;

import clientUserStory1.UserStory1a;
import clientUserStory1.UserStory1b;
import clientUserStory1.UserStory1c;
import clientUserStory1.UserStory1d;
import clientUserStory1.UserStory1e;
import scenarioClasses.InformationLivre;
import scenarioClasses.ListLibraryPpn;
import scenarioClasses.PpnLivre;
import scenarioClasses.UserInformation;
import webx.client_jersey.generatedClasses.AuteurType;
import webx.client_jersey.generatedClasses.BibliothequeType;
import webx.client_jersey.generatedClasses.ResponseType;
import webx.client_jersey.generatedClasses.ResultType;

public class TraitementServiceJersey {

	public static String traitementServiceGeneratioXML(String doi, String adresse)
			throws UnsupportedEncodingException, JSONException {

		ResponseType result = new ResponseType();
		String resultRequeteResponseDom;

		// Ajout des auteurs
		InformationLivre researchBook = new InformationLivre();
		researchBook = UserStory1a.recupererInfoDocument(doi);

		List<AuteurType> auteurList = new ArrayList<AuteurType>();
		for (int i = 0; i < researchBook.getListAuteur().size(); i++) {
			auteurList.add(new AuteurType(researchBook.getListAuteur().get(i).getGiven(),
					researchBook.getListAuteur().get(i).getFamily()));
		}

		// Récupérer les ppn de chaque adresse si l'isbn existe bien sûr
		PpnLivre isbnPpnInfo = new PpnLivre();
		isbnPpnInfo = UserStory1b.recupererIdentifiantPPN(researchBook.getISBN(), researchBook);

		// Récupérer liste Bus
		List<ListLibraryPpn> listLibraryParPpn = new ArrayList<ListLibraryPpn>();
		UserStory1c.recupererLIstBUs(isbnPpnInfo.getResult().get(0), listLibraryParPpn);

		// Récupérer les informations du user
		UserInformation user = new UserInformation();
		user = UserStory1d.recupererCoordonneeGeographiqueAvecAdressePostale(adresse);

		// Récupérer les distances dans l'ordre
		List<Float> distanceList = new ArrayList<Float>();
		distanceList = UserStory1e.recupererDistanceVolOiseau(user, listLibraryParPpn.get(0).getListLibrary());

		// Ajout les bibliothèques
		List<BibliothequeType> bibliotheque = new ArrayList<BibliothequeType>();
		for (int i = 0; i < distanceList.size(); i++)
			bibliotheque.add(new BibliothequeType(listLibraryParPpn.get(0).getListLibrary().get(i).getShortname(),
					distanceList.get(i)));

		// Remplir les données
		result.setResult(new ResultType(researchBook.getTitle(), auteurList, bibliotheque));

		// Remplir ErrorType
		// result.setError(new ErrorType("ok", 200));

		// Créer le fichier DOM
		resultRequeteResponseDom = CreationDocumentDOM.generationDOM(researchBook.getTitle(), auteurList, bibliotheque);

		return resultRequeteResponseDom;
	}

	public static String resultatAttenduWIthFirstDOIGiven() {

		String resultat;
		resultat = "  <bibliotheque>"+
    "<nom>METZ-UL-BU METZ MOSELLE</nom>"+
"    <distance>7.278217315673828</distance>"+
"  </bibliotheque>";

		return resultat;
	}
	

}
