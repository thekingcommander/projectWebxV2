package scenarioClasses;

import java.util.ArrayList;
import java.util.List;

public class PpnLivre {
	
	private String isbn;
	private List<String> result =  new ArrayList<String>();
	private List<String> resultNoHolding =  new ArrayList<String>();
	
	//Constructors
	public PpnLivre(String isbn){	
		this.isbn =  isbn;
	}
	
	public PpnLivre(){	
	}
	
	
	//Getters and setters
	public String getIsbn() {
		return isbn;
	}
	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}
	public List<String> getResult() {
		return result;
	}
	public void setResult(List<String> result) {
		this.result = result;
	}
	
	//ajout dans les listes
	public void addPpnResult(String ppn){
		result.add(ppn);
	}
	
	public void addppnResultNoHoldingr(String ppn){
		resultNoHolding.add(ppn);
	}
	
	public int getResultLength(){	
		return result.size();
	}
	
	public int getResultNoHolding(){
		return resultNoHolding.size();
	}
	
	

}
