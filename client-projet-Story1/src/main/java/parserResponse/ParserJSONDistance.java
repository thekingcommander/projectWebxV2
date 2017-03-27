package parserResponse;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;


public class ParserJSONDistance {
	
	
	public static List<Float>  parserInfoDocument(String parsedDoc) throws JSONException{
		//Attribut
		List<Float> distanceTab = new ArrayList<Float>();	
		//parser
		JSONObject json  = new JSONObject(parsedDoc);
		JSONArray jsonarr= json.getJSONArray("lengths");
		
		for (int i = 0; i< jsonarr.length(); i++)
			distanceTab.add((float) jsonarr.getDouble(i));
				
				
		return distanceTab;
	}
}
