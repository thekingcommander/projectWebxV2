package webx.client_jersey.generatedClasses;


import javax.xml.bind.annotation.XmlRootElement;


@XmlRootElement
public class RequestType {


    private String doi;
    private String adresse;

    
  //Constructor
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
