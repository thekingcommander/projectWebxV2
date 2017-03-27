package iaws.multiLivre.ws.implmInterface;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

import org.json.JSONException;
import org.springframework.stereotype.Service;

import clientUserStory1.UserStory1a;
import clientUserStory1.UserStory1b;
import clientUserStory1.UserStory1c;
import clientUserStory1.UserStory1d;
import clientUserStory1.UserStory1e;
import iaws.multiLivre.ws.generatedClasses.AuteurType;
import iaws.multiLivre.ws.generatedClasses.BibliothequeType;
import iaws.multiLivre.ws.generatedClasses.ResponseType;
import iaws.multiLivre.ws.generatedClasses.ResultType;
import iaws.multiLivre.ws.interfaceService.MultiLivreService;
import scenarioClasses.InformationLivre;
import scenarioClasses.ListLibraryPpn;
import scenarioClasses.PpnLivre;
import scenarioClasses.UserInformation;


@Service
public class ImplMultiLivreService implements MultiLivreService {

	/**
	 * Retourne tous les le resultat de la requête
	 *
	 * @param doi
	 * @param adresse
	 * @return le resultType contenant le titre du document, les auteurs et les
	 *         bibliothèques
	 * @throws JSONException 
	 * @throws UnsupportedEncodingException 
	 */
	public ResponseType findAllResultTypesForDoiAndAdresse(String doi, String adresse) throws UnsupportedEncodingException, JSONException {
		
		ResponseType result = new ResponseType();


		// Ajout des auteurs
		InformationLivre researchBook = new InformationLivre();
		// researchBook =
		// UserStory1a.recupererInfoDocument("10.1007/978-3-662-07964-5");
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
		// user =
		// UserStory1d.recupererCoordonneeGeographiqueAvecAdressePostale("10 Rue
		// de la Forge, Bondoufle", user);
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
		
		return result;
	}
		
		
		
	}
		
	
