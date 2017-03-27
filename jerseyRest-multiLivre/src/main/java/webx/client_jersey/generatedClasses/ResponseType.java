package webx.client_jersey.generatedClasses;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;


@XmlRootElement
public class ResponseType {

    private ErrorType error;
    private ResultType result;

    
  //Constructor
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
