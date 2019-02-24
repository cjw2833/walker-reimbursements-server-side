package com.walker.controllers;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.walker.dto.CreateReimbDTO;
import com.walker.services.ReimbursementService;

public class CreateReimbsController implements Controller {
	private ReimbursementService reimbService = new ReimbursementService();
	
	public void handleGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
		System.out.println("get create reimbs");
	}

	public void handlePost(HttpServletRequest request, HttpServletResponse response) throws IOException {
		System.out.println("post create reimbs");
		CreateReimbDTO cr = new CreateReimbDTO();
		ObjectMapper om = new ObjectMapper();
		
//		http://localhost:8080/WalkerReimbursements/walker-reimbursements-create
		// create reimb in database
		try {
			cr = om.readValue(request.getReader(), CreateReimbDTO.class);
			System.out.println("cr" + cr);  // debug
			reimbService.createReimbursementById(cr);
			
		} catch (JsonParseException e) {
			e.printStackTrace();
		} catch (JsonMappingException e) {
			e.printStackTrace();
		}
	}
}
