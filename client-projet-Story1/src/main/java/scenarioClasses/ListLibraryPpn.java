package scenarioClasses;

import java.util.ArrayList;
import java.util.List;

public class ListLibraryPpn {
	
	private String ppn;
	private List<Library> listPpnLibrary = new ArrayList<Library>();
	
	
	// Constructors
	public ListLibraryPpn(){
		
	}
	
	public ListLibraryPpn(String ppn, List<Library> lib){	
		this.ppn = ppn;
		lib = listPpnLibrary;
	}
	

	//Getters and Setters
	public String getPpn() {
		return ppn;
	}

	public void setPpn(String ppn) {
		this.ppn = ppn;
	}

	public List<Library> getListLibrary() {
		return listPpnLibrary;
	}

	public void setListLibrary(List<Library> listLibrary) {
		this.listPpnLibrary = listLibrary;
	}

	
	//Méthode en rapport avec la liste
	public int getListPpn(){
		return listPpnLibrary.size();
	}
	
	
	public void addPpnWithLibraries(Library lib){
		
		listPpnLibrary.add(lib);
	}

}
