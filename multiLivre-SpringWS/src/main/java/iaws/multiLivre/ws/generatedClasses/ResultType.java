package iaws.multiLivre.ws.generatedClasses;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


@XmlRootElement
@XmlType(propOrder={"titre", "auteur", "bibliotheque"})
public class ResultType {

 
    private String titre;
    private List<AuteurType> auteur;
    private List<BibliothequeType> bibliotheque;

    
    public ResultType(){
    	
    }
    
    public ResultType(String titre, List<AuteurType> auteur, List<BibliothequeType> bibliotheque){ 	
    	this.titre = titre;
    	this.auteur = auteur;
    	this.bibliotheque = bibliotheque;
    }
 
    public String getTitre() {
        return titre;
    }

    @XmlElement(name = "titre")
    public void setTitre(String value) {
        this.titre = value;
    }

 
    public List<AuteurType> getAuteur() {
        if (auteur == null) {
            auteur = new ArrayList<AuteurType>();
        }
        return this.auteur;
    }


    public List<BibliothequeType> getBibliotheque() {
        if (bibliotheque == null) {
            bibliotheque = new ArrayList<BibliothequeType>();
        }
        return this.bibliotheque;
    }

    @XmlElement(name = "auteur")
	public void setAuteur(List<AuteurType> auteur) {
		this.auteur = auteur;
	}
    
    
    @XmlElement(name = "bibliotheque")
	public void setBibliotheque(List<BibliothequeType> bibliotheque) {
		this.bibliotheque = bibliotheque;
	}
    
    
    
    
    
    
}
