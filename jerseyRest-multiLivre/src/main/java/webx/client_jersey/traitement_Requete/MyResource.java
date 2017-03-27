package webx.client_jersey.traitement_Requete;

import java.io.UnsupportedEncodingException;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.json.JSONException;
import webx.client_jersey.generatedClasses.RequestType;
import webx.client_jersey.utils.TraitementServiceJersey;

/**
 * Root resource (exposed at "myresource" path)
 */
@Path("myresource")
public class MyResource {

	/**
	 *
	 * @return String that will be returned as a text/plain response.
	 * @throws JSONException
	 * @throws UnsupportedEncodingException
	 */
	@POST
	@Consumes(MediaType.APPLICATION_XML)
	@Produces(MediaType.TEXT_PLAIN)
	public String getIt(RequestType request) throws JSONException, UnsupportedEncodingException {
		String resultXmlDom;
		resultXmlDom = TraitementServiceJersey.traitementServiceGeneratioXML(request.getDoi(), request.getAdresse());
		
		System.out.println(resultXmlDom);

		return resultXmlDom;
	}
}
