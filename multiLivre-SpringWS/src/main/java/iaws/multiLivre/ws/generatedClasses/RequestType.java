package iaws.multiLivre.ws.generatedClasses;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name="RequestType")
public class RequestType {


    private String doi;
    private String adresse;

    
    public RequestType(){
    	
    }

    public String getDoi() {
        return doi;
    }

    public void setDoi(String value) {
        this.doi = value;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String value) {
        this.adresse = value;
    }

}
