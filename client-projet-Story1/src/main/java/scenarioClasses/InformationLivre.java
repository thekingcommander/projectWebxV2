package scenarioClasses;

import java.util.ArrayList;
import java.util.List;

public class InformationLivre {
	
	
	private List<Author> listAuteur = new ArrayList<Author>();
	private String title;
	private String ISBN;
	
	
	//Constructor
	public InformationLivre(String title, String ISBN, List<Author> listAut){	
		this.title = title;
		this.ISBN = ISBN;
		this.listAuteur = listAut;
	}

	public InformationLivre(){
		
	}
	

	//Getters and setters
	public List<Author> getListAuteur() {
		return listAuteur;
	}


	public void setListAuteur(List<Author> listAuteur) {
		this.listAuteur = listAuteur;
	}


	public String getTitle() {
		return title;
	}


	public void setTitle(String title) {
		this.title = title;
	}


	public String getISBN() {
		return ISBN;
	}


	public void setISBN(String iSBN) {
		ISBN = iSBN;
	}
	
	public void addAuthor(Author author){
		listAuteur.add(author);
	}
	
}
