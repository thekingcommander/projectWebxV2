package iaws.multiLivre.ws.interfaceService;

import java.io.UnsupportedEncodingException;

import org.json.JSONException;

import iaws.multiLivre.ws.generatedClasses.ResponseType;



public interface MultiLivreService {

	public ResponseType findAllResultTypesForDoiAndAdresse(String doi, String adresse)
			throws UnsupportedEncodingException, JSONException;
}
