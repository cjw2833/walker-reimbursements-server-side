package com.walker.controllers;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.walker.dto.LoginDTO;
import com.walker.models.Employee;
import com.walker.services.LoginService;

public class LoginController implements Controller {

	public void handleGet(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("handle login get");		// debug
	}

	public void handlePost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		System.out.println("handle login post"); // debug
		ObjectMapper r = new ObjectMapper();
		LoginService login = new LoginService();
		
			LoginDTO loginDto = r.readValue(request.getInputStream(), LoginDTO.class);
			System.out.println(loginDto); // debug
			Employee emp = login.getEmployeeCredrentials(loginDto.getUsername(), loginDto.getPassword());
			System.out.println(emp);	// Debug
			response.setContentType("application/json");
			response.getWriter().write(r.writeValueAsString(emp));
			response.setStatus(200);
	}
}
