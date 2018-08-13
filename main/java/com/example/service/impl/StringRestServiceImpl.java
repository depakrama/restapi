package com.example.service.impl;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.example.model.SearchResponse;
import com.example.model.TopCountModel;
import com.example.service.StringSearchRestService;

@Service
public class StringRestServiceImpl implements StringSearchRestService{
	
	@Override
	public SearchResponse getCountForSearchString(List<String> request) throws Exception {
		
		//load the text from file
		
		Path path = Paths.get(getClass().getClassLoader().getResource("search.txt").toURI());
		
		String inputStr = new String(Files.readAllBytes(path));
		
		Map<String, Long> result = Arrays.asList(inputStr.split("\\s+")).stream().map(String::toLowerCase).filter(w -> request.contains(w)).collect(Collectors.groupingBy(w -> w, Collectors.counting())); 
		
		for (String searchText : request) {
			if(result.get(searchText) == null) {
				result.put(searchText, 0L);
			}
		}
		
		
		SearchResponse response = new SearchResponse();
		response.setCounts(result);
		return response;

	}

	@Override
	public List<TopCountModel> getTopSearchString(Integer count) throws Exception {
	Path path = Paths.get(getClass().getClassLoader().getResource("search.txt").toURI());
		
		String inputStr = new String(Files.readAllBytes(path));
		 
		Map<String, Long> result = Arrays.asList(inputStr.split("\\s+")).stream().map(String::toLowerCase).collect(Collectors.groupingBy(w -> w, Collectors.counting()));
		
		List<TopCountModel> listTopCountModel = new ArrayList<TopCountModel>();
		
		for(String str:result.keySet()) {
			TopCountModel model = new TopCountModel();
			model.setTopString(str);
			model.setTopStringCount(result.get(str));
			listTopCountModel.add(model);
		}
		
		Comparator<TopCountModel> comparator = (t1, t2) -> t2.getTopStringCount().compareTo(t1.getTopStringCount());
		
		listTopCountModel.sort(comparator);
	
		return listTopCountModel.stream().limit(count).collect(Collectors.toList());
		
		//listTopCountModel.re
		
	}
		

}
