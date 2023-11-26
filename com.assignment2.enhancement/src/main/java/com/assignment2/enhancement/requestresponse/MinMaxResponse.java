package com.assignment2.enhancement.requestresponse;

import com.fasterxml.jackson.annotation.JsonProperty;


public class MinMaxResponse {
	@JsonProperty("max")
	private int max;
	@JsonProperty("min")
	private int min;
	public MinMaxResponse(int i, int j) {
		// TODO Auto-generated constructor stub
	}
	public MinMaxResponse() {
		// TODO Auto-generated constructor stub
	}
	public int getMax() {
		return max;
	}
	public void setMax(int max) {
		this.max = max;
	}
	public int getMin() {
		return min;
	}
	public void setMin(int min) {
		this.min = min;
	}

	
}

