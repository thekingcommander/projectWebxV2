package iaws.multiLivre.ws.generatedClasses;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class ErrorType {


    protected String api;
    protected Integer status;

  
    public ErrorType(){
    	
    }
    
    
    public ErrorType(String api, int status){
    	
    	this.api = api;
    	this.status = status;
    }
    
    
    
    public String getApi() {
        return api;
    }


    public void setApi(String value) {
        this.api = value;
    }


    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer value) {
        this.status = value;
    }

}
