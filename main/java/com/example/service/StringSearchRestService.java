package com.example.service;

import java.util.List;

import com.example.model.SearchResponse;
import com.example.model.TopCountModel;

public interface StringSearchRestService {
	
	public SearchResponse getCountForSearchString(List<String> request) throws  Exception;
	
	public List<TopCountModel> getTopSearchString(Integer count) throws Exception; 
	

}
