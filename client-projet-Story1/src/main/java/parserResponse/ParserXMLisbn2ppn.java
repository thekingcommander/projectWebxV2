package parserResponse;

import java.io.StringReader;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;

import scenarioClasses.PpnLivre;

public class ParserXMLisbn2ppn {
	
	public static PpnLivre parserISBN2PPN(String parsedDoc, String isbn){

		//creation de classe résultat
  	  PpnLivre isbnResult =  new PpnLivre(isbn);
  	  
	      try {	  
	    	  DocumentBuilder db = DocumentBuilderFactory.newInstance().newDocumentBuilder();
	    	    InputSource is = new InputSource();
	    	    is.setCharacterStream(new StringReader(parsedDoc));
	    	    Document doc = db.parse(is);
	    	    	    
	         NodeList nList = doc.getElementsByTagName("query");
	         
	         for (int temp = 0; temp < nList.getLength(); temp++) {
	        	 Node nNode = nList.item(temp);
	        	 
		         if (nNode.getNodeType() == Node.ELEMENT_NODE) {
		        	 
		        	 Element eElement = (Element) nNode;
		             NodeList resultGeneral = eElement.getElementsByTagName("result");
		             Element resultline = (Element) resultGeneral.item(0);
		             
		             for (int i = 0; i < resultline.getElementsByTagName("ppn").getLength(); i++)
		            	 isbnResult.addPpnResult(resultline.getElementsByTagName("ppn").item(i).getTextContent());
		             
		             
		             NodeList resultNoHolding = eElement.getElementsByTagName("resultNoHolding");   
		             //S'assurer que le champ resultNoHolding existe
		             if (eElement.getElementsByTagName("resultNoHolding").getLength() > 0)
		             {	 
			             Element ppnNoHolding = (Element) resultNoHolding.item(0);
			             
			             for (int i = 0; i < ppnNoHolding.getElementsByTagName("ppn").getLength(); i++)
			            	 isbnResult.addppnResultNoHoldingr(ppnNoHolding.getElementsByTagName("ppn").item(i).getTextContent());
			             
		             }     

		         }             	 
	         }
	      } catch (Exception e) {
		         e.printStackTrace();
		  }
	      
	      return isbnResult;        
	}
}
