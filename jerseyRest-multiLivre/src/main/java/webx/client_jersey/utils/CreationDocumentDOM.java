package webx.client_jersey.utils;

import java.io.File;
import java.io.StringWriter;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

import webx.client_jersey.generatedClasses.AuteurType;
import webx.client_jersey.generatedClasses.BibliothequeType;

public class CreationDocumentDOM {

	public static String generationDOM(String title, List<AuteurType> auteurList,
			List<BibliothequeType> bibliothequeList) {

		try {

			DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder docBuilder = docFactory.newDocumentBuilder();

			// root elements
			Document doc = docBuilder.newDocument();
			Element rootElement = (Element) doc.createElement("responseType");
			doc.appendChild(rootElement);

			// staff elements
			Element titre = (Element) doc.createElement("titre");
			titre.appendChild(doc.createTextNode(title));
			rootElement.appendChild(titre);

			// génération des auteurs
			for (int i = 0; i < auteurList.size(); i++) {

				Element auteur = (Element) doc.createElement("auteur");
				Element nom = (Element) doc.createElement("nom");
				nom.appendChild(doc.createTextNode(auteurList.get(i).getNom()));
				auteur.appendChild(nom);

				Element prenom = (Element) doc.createElement("prenom");
				prenom.appendChild(doc.createTextNode(auteurList.get(i).getPrenom()));
				auteur.appendChild(prenom);

				rootElement.appendChild(auteur);
			}

			// génération des bibliothèques
			for (int i = 0; i < bibliothequeList.size(); i++) {
				Element bibliotheque = (Element) doc.createElement("bibliotheque");
				Element nom = (Element) doc.createElement("nom");
				nom.appendChild(doc.createTextNode(bibliothequeList.get(i).getNom()));
				bibliotheque.appendChild(nom);

				Element distance = (Element) doc.createElement("distance");
				distance.appendChild(doc.createTextNode(String.valueOf(bibliothequeList.get(i).getDistance())));
				bibliotheque.appendChild(distance);

				rootElement.appendChild(bibliotheque);
			}

			// creation du transformer
			TransformerFactory transformerFactory = TransformerFactory.newInstance();
			Transformer transformer = transformerFactory.newTransformer();
			transformer.setOutputProperty(OutputKeys.OMIT_XML_DECLARATION, "no");
			transformer.setOutputProperty(OutputKeys.METHOD, "xml");
			transformer.setOutputProperty(OutputKeys.INDENT, "yes");
			transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "2");
			transformer.setOutputProperty(OutputKeys.ENCODING, "UTF-8");

			// creation du source et du result
			DOMSource source = new DOMSource(doc);
			StringWriter resultXML = new StringWriter();
			transformer.transform(source, new StreamResult(resultXML));			
			//générer xml file
			StreamResult result = new StreamResult(new File("ResponseType.xml"));
			transformer.transform(source, result);		

			
			return resultXML.toString();

		} catch (Exception ex) {
			throw new RuntimeException("Error converting to String", ex);
		}
	}
}
