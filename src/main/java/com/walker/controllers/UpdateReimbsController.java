package com.walker.controllers;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.walker.dto.UpdateReimbDTO;
import com.walker.services.ReimbursementService;

public class UpdateReimbsController implements Controller {
	private ReimbursementService reimbService = new ReimbursementService();
	
	public void handleGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
		System.out.println("get update reimb");
	}

	public void handlePost(HttpServletRequest request, HttpServletResponse response) throws IOException {
		System.out.println("post update reimb");
		UpdateReimbDTO ur = new UpdateReimbDTO();
		ObjectMapper om = new ObjectMapper();
		
//		http://localhost:8080/WalkerReimbursements/walker-reimbursements-update
			ur = om.readValue(request.getInputStream(), UpdateReimbDTO.class);
			System.out.println(ur); // debug
			reimbService.updateReimbursementStatus(ur);
			response.setStatus(200);
	}
}
