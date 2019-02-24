package com.walker.controllers;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.walker.models.Reimbursement;
import com.walker.services.ReimbursementService;

public class FmReimbsController implements Controller {
	private ReimbursementService reimbService = new ReimbursementService();
	
	public void handleGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
		System.out.println("get fm reimbs ");
		System.out.println(request.getRequestURL());
		List<Reimbursement> rList = null;
	
//		http://localhost:8080/WalkerReimbursements/walker-reimbursements-all?s=1
		// get all reimbs by status ==> request parameters: status=s
		int status = Integer.parseInt(request.getParameter("s"));
		rList = reimbService.getReimbursementsByStatus(status);
		
		// write reimb list to response
		ObjectMapper om = new ObjectMapper();
		om.writeValue(response.getWriter(), rList);
		//send(rList, response);
	}

	public void handlePost(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("post fm reimbs");
	}
	
}