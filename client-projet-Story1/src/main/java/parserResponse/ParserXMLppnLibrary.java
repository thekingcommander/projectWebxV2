package parserResponse;

import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;

import scenarioClasses.Library;
import scenarioClasses.ListLibraryPpn;

public class ParserXMLppnLibrary {

	
	public static ListLibraryPpn parserISBN2PPN(String parsedDoc){

	 //creation de classe résultat
  	 ListLibraryPpn ppnLibrary = new ListLibraryPpn();
  	 List<Library> listLibrary =  new ArrayList<>();
  	 //attributs utilisé pour la librairie
  	 int crc;
  	 String shortname, elemTmp;
  	 float latitude, longitude;
  	  
	      try {	  
	    	  DocumentBuilder db = DocumentBuilderFactory.newInstance().newDocumentBuilder();
	    	  InputSource is = new InputSource();
	    	  is.setCharacterStream(new StringReader(parsedDoc));
	    	  Document doc = db.parse(is);
	    	    
	         NodeList nList = doc.getElementsByTagName("query");         
	         for (int temp = 0; temp < nList.getLength(); temp++) {
	        	 
	        	 Node nNode = nList.item(temp);		         
		         if (nNode.getNodeType() == Node.ELEMENT_NODE) {
		        	 //ajout du ppn
		        	 Element eElement = (Element) nNode;
		        	 ppnLibrary.setPpn(eElement.getElementsByTagName("ppn").item(0).getTextContent());
		             
		             //récupération du noeud résultat
		             NodeList resultGeneral = eElement.getElementsByTagName("result");
		             Element resultline = (Element) resultGeneral.item(0);
		                    	             
		             for (int i = 0; i < resultline.getElementsByTagName("library").getLength(); i++)
		             { 
		            	 //récupérer la ieme librairie
		            	 Element elem = (Element) resultline.getElementsByTagName("library").item(i);
		            	 
		            	 //récupérer le crc
		            	 elemTmp = elem.getElementsByTagName("rcr").item(0).getTextContent();
		            	 crc =  Integer.parseInt(elemTmp);
		            	 //récupérer le shortname
		            	 shortname = elem.getElementsByTagName("shortname").item(0).getTextContent();
		            	 
		            	 //récupérer la longitude
		            	 elemTmp = elem.getElementsByTagName("longitude").item(0).getTextContent(); 
		            	 //vérifier que la longitude
		            	 if (elemTmp.equals(""))
		            		 longitude = 0.0f;
		            	 else
		            		 longitude =  Float.parseFloat(elemTmp);
		            	 
		            	//récupérer la longitude
		            	 elemTmp = elem.getElementsByTagName("latitude").item(0).getTextContent();
		            	//vérifier que la latitude existe
		            	 if (elemTmp.equals(""))
		            		 latitude = 0.0f;
		            	 else
		            		 latitude =  Float.parseFloat(elemTmp);
		            	 
		            	 //Le rajouter dans la BD
		            	 listLibrary.add(new Library(crc, shortname, latitude, longitude));
		             }             
		         }             	 
	         }
	         ppnLibrary.setListLibrary(listLibrary);
	         
	      } catch (Exception e) {
		         e.printStackTrace();
		  }     
	      return ppnLibrary;        
	}
}
