package com.walker.controllers;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface Controller {
	public default void handleGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		response.sendError(404);
		return;
	}
	
	public default void handlePost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		response.sendError(404);
		return;
	}
}