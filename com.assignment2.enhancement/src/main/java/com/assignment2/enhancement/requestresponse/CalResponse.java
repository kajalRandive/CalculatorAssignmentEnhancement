package com.assignment2.enhancement.requestresponse;


import com.fasterxml.jackson.annotation.JsonProperty;


public class CalResponse {

	@JsonProperty("answer")
	private Double answer;

	@JsonProperty("detail")
	private String detail;

	/*
	 * public CalResponse(double d, String string) { // TODO Auto-generated
	 * constructor stub } public CalResponse() { // TODO Auto-generated constructor
	 * stub }
	 */
	public Double getAnswer() {
		return answer;
	} 
	public void setAnswer(Double answer) {
		this.answer = answer;
	}

	public String getDetail() {
		return detail;
	}

	public void setDetail(String detail) {
		this.detail = detail;
	}
	public Integer getStatusCodeValue() {
		// TODO Auto-generated method stub
		return null;
	}
}
