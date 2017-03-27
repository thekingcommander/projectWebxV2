package scenarioClasses;

import java.util.ArrayList;
import java.util.List;

public class Author {
	
	
	private String oRCID;
	private String given;
	private String family;
	private List<String> affiliation = new ArrayList<String>();
	
	
	//Constructor
	public Author(String orcid, String given, String family, List<String> aff){
		
		this.oRCID = orcid;
		this.given = given;
		this.family = family;
		this.affiliation = aff;
	}
	
	
	//Getters and setters
	public String getoRCID() {
		return oRCID;
	}
	public void setoRCID(String oRCID) {
		this.oRCID = oRCID;
	}
	public String getGiven() {
		return given;
	}
	public void setGiven(String given) {
		this.given = given;
	}
	public String getFamily() {
		return family;
	}
	public void setFamily(String family) {
		this.family = family;
	}
	public List<String> getAffiliation() {
		return affiliation;
	}
	public void setAffiliation(List<String> affiliation) {
		this.affiliation = affiliation;
	}
}
