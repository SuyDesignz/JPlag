package model;

import com.fasterxml.jackson.annotation.JsonProperty;

import de.jplag.JPlagComparison;

public class ResultJsonModel {

	@JsonProperty("functionName")
	private String functionName;
	@JsonProperty("resultSimilarity")
	private float resultSimilarity;
	
	public ResultJsonModel(String functionName, float resultSimilarity)
	{
		this.functionName = functionName;
		this.resultSimilarity = resultSimilarity;
	}
	
	public ResultJsonModel(String functionName, JPlagComparison jPlagComparison)
	{
		this.functionName = functionName;
		resultSimilarity = jPlagComparison.similarity();
		
	}
	public ResultJsonModel()
	{
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
