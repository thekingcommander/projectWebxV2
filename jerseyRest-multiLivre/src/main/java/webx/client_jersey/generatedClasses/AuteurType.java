package webx.client_jersey.generatedClasses;


import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;



@XmlRootElement
public class AuteurType {

    
    private String prenom;
    private String nom;
    
    
    public AuteurType(){
    	
    }
    
    //Constructor
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
