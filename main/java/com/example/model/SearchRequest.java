package com.example.model;

import java.util.List;
import java.util.stream.Collectors;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
"searchText"
})
public class SearchRequest {

@JsonProperty("searchText")
private List<String> searchText = null;

@JsonProperty("searchText")
public List<String> getSearchText() {
return searchText;
}

@JsonProperty("searchText")
public void setSearchText(List<String> searchText) {
this.searchText = searchText.stream().map(String::toLowerCase).collect(Collectors.toList());
}


}
