package parserResponse;

import java.io.StringReader;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;

import scenarioClasses.UserInformation;

public class ParserXMLUserAdress {
	
	public static UserInformation parserAdresse(String parsedDoc){
		
		//String coordonneeTmp;
		//String[] tokens;
	  	 //attributs utilisé pour l'adresse
		UserInformation userInfo = new UserInformation(); 	  
		      try {	  
		    	 DocumentBuilder db = DocumentBuilderFactory.newInstance().newDocumentBuilder();
		    	 InputSource is = new InputSource();
		    	 is.setCharacterStream(new StringReader(parsedDoc));
		    	 Document doc = db.parse(is);	
		         NodeList nList = doc.getElementsByTagName("place");
		         
		         for (int temp = 0; temp < nList.getLength(); temp++) {       	 
		        	 Node nNode = nList.item(temp);  
			         if (nNode.getNodeType() == Node.ELEMENT_NODE) {
			        	 Element eElement = (Element) nNode;
			        	 userInfo.setLatitude(Float.parseFloat(eElement.getAttribute("lat")));
			        	 userInfo.setLongitude(Float.parseFloat(eElement.getAttribute("lon")));
			             userInfo.setAdressePostale(eElement.getAttribute("display_name"));
			         }             	 
		         }        
		      } catch (Exception e) {
			         e.printStackTrace();
			  }     
		      return userInfo;        
		}
}
