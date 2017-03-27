package iaws.multiLivre.ws.contractfirst;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.Namespace;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;
import org.springframework.ws.server.endpoint.annotation.XPathParam;
import org.w3c.dom.Element;

import iaws.multiLivre.ws.generatedClasses.RequestType;
import iaws.multiLivre.ws.generatedClasses.ResponseType;
import iaws.multiLivre.ws.interfaceService.MultiLivreService;
import webx.client_jersey.utils.TraitementServiceJersey;

@Endpoint
public class multiLivreEndPoint {

	private MultiLivreService multiLivreService;
	private static final String NAMESPACE_URI = "https://example.com/webx/multi-livre";

	// the multiLivreService business service is injected into this endpoint.
	@Autowired
	public multiLivreEndPoint(MultiLivreService multiLivreService) {
		this.multiLivreService = multiLivreService;
	}

	// Nom de l'élément racine
	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "Request")
	@Namespace(prefix = "rn", uri = NAMESPACE_URI)
	// espace de nom pour les expressions XPath ci-dessous
	@ResponsePayload
	public ResponseType handleMultiLivreRequest(@RequestPayload RequestType request) throws Exception {

		ResponseType resp =  new ResponseType();
		String resultat = "";
		String doiC = request.getDoi();
		String adresseC = request.getAdresse();

		// Invoque le service "multiLivreService" pour récupérer les objets recherchés :
		multiLivreService.findAllResultTypesForDoiAndAdresse(doiC, adresseC);

		// Transforme en élément XML ad-hoc pour le retour
		resultat = TraitementServiceJersey.traitementServiceGeneratioXML(doiC, adresseC);
		Element elt = XmlHelper.getRootElementFromFileInClasspath("ResponseType.xml");

		return resp;

	}

}