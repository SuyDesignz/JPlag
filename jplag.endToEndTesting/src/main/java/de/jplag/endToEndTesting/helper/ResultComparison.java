package de.jplag.endToEndTesting.helper;

import java.io.IOException;

import org.json.JSONException;
import org.json.JSONObject;

import de.jplag.endToEndTesting.constants.Constant;

public class ResultComparison {
	private String functionName;
	private float similarity;

	public ResultComparison(String functionName) throws JSONException, IOException {
		if (functionName != null && !functionName.isEmpty()) {
			this.functionName = functionName;
			loadStoredComparativeValues();
		} else {
			throw new IllegalArgumentException("function name cannot be empty");
		}
	}

	public String getFunctionName() {
		return functionName;
	}

	public float getSimilarity() {
		return similarity;
	}

	private void loadStoredComparativeValues() throws JSONException, IOException {
		
		var jsonResultObj = JsonReader.readJsonFromPath(Constant.BASE_PATH_TO_JAVA_RESULT_JSON.toAbsolutePath().toString());
		
		var resultsArray = jsonResultObj.getJSONArray("results");
		
	    for(int i = 0; i < resultsArray.length(); i++) {
	        JSONObject articleObject = resultsArray.getJSONObject(i);
	        if(articleObject.getString(Constant.JSON_TEST_NAME_NODE).equals(functionName))
	        {
	        	similarity = (float) articleObject.getDouble(Constant.JSON_SIMILARITY_NODE);
	        	return;
	        }
	    }
	}
}
