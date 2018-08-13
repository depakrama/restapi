package com.example.model;

import java.util.Map;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;


@JsonInclude(JsonInclude.Include.NON_EMPTY)
@JsonPropertyOrder({
"counts","message"
})
public class SearchResponse {

	
	@JsonProperty("counts")
	private Map<String, Long> counts;
	
	@JsonProperty("message")
	private String message;

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Map<String, Long> getCounts() {
		return counts;
	}

	public void setCounts(Map<String, Long> counts) {
		this.counts = counts;
	}

	
}
