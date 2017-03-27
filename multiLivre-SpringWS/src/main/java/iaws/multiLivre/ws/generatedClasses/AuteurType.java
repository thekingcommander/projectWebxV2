package iaws.multiLivre.ws.generatedClasses;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


@XmlRootElement
public class AuteurType {

    
    private String prenom;
    private String nom;
    
    
    public AuteurType(){
    	
    }
    
    public AuteurType(String prenom, String nom){
    	
    	this.prenom = prenom;
    	this.nom = nom;
    }
    
    public String getPrenom() { 
        return prenom; 
     } 

    @XmlElement 
    public void setPrenom(String value) {
        this.prenom = value;
    }


    public String getNom() {
        return nom;
    }

    @XmlElement 
    public void setNom(String value) {
        this.nom = value;
    }

}
