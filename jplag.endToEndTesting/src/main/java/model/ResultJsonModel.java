package model;

import com.fasterxml.jackson.annotation.JsonProperty;

import de.jplag.JPlagComparison;

public class ResultJsonModel {

	@JsonProperty("function_name")
	private String functionName;
	@JsonProperty("result_similarity")
	private float resultSimilarity;
	
	public ResultJsonModel(String functionName, float resultSimilarity)
	{
		this.functionName = functionName;
		this.resultSimilarity = resultSimilarity;
	}
	
	public ResultJsonModel()
	{
	}
	
	public ResultJsonModel(String functionName, JPlagComparison jplagComparison) {
		this.functionName = functionName;
		resultSimilarity = jplagComparison.similarity();
	}

	public float similarity()
	{
		return resultSimilarity;
	}
	
	public String getFunctionName()
	{
		return functionName;
	}
}
