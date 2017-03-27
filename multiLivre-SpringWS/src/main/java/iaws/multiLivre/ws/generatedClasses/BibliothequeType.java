package iaws.multiLivre.ws.generatedClasses;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;



@XmlRootElement
@XmlType(propOrder={"nom", "distance"})
public class BibliothequeType {


    private String nom;
    private double distance;
    
    
    public BibliothequeType(){
    	
    }
    
    public BibliothequeType(String nom, double distance){
    	this.nom = nom;
    	this.distance = distance;
    }


    public String getNom() {
        return nom;
    }

    @XmlElement(name = "nom")
    public void setNom(String value) {
        this.nom = value;
    }

  
    public double getDistance() {
        return distance;
    }

    @XmlElement(name = "distance")
    public void setDistance(double value) {
        this.distance = value;
    }

}
