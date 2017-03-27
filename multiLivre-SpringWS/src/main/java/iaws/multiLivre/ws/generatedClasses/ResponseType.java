package iaws.multiLivre.ws.generatedClasses;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


@XmlRootElement(name="ResponseType")
public class ResponseType {

    private ErrorType error;
    private ResultType result;

    
    public ResponseType(){
    	
    }
 
    public ErrorType getError() {
        return error;
    }

    @XmlElement 
    public void setError(ErrorType value) {
        this.error = value;
    }

 
    public ResultType getResult() {
        return result;
    }

    @XmlElement 
    public void setResult(ResultType value) {
        this.result = value;
    }

}
