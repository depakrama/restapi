package com.example.controller;


import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.model.SearchRequest;
import com.example.model.SearchResponse;
import com.example.model.TopCountModel;
import com.example.service.StringSearchRestService;

import com.example.util.WriteCsvResponse;


@RestController
@RequestMapping("/counter/api")
public class StringSearchRestController {
	
	@Autowired
	private StringSearchRestService service;


	@PostMapping(path = "/search", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> countSearchString(@RequestBody SearchRequest request) throws Exception {
		
		SearchResponse response = null;
		HttpStatus status = null;
		try {
			if(request == null || (request.getSearchText() == null || request.getSearchText().isEmpty())) {
				status = HttpStatus.BAD_REQUEST;
				
				response = new SearchResponse();
				response.setMessage("Request is Empty");
				return new ResponseEntity<>(response, status);
			}
			
			response = service.getCountForSearchString(request.getSearchText());
			status = HttpStatus.OK;
			 
		}catch(Exception e) {
			status = HttpStatus.INTERNAL_SERVER_ERROR;
			return new ResponseEntity<>(response, status);
		}
		
		return new ResponseEntity<>(response, status);
	}
	
	
	@GetMapping(path = "/top/{count}", produces = "text/csv")
	public void getTopCount(@PathVariable("count") Integer count, HttpServletResponse response) {
		try {
			
			List<TopCountModel> listTopCountModel = service.getTopSearchString(count);
			
			WriteCsvResponse.writeResponse(response.getWriter(), listTopCountModel);
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}
}