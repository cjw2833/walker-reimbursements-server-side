package com.walker.servlets;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.walker.controllers.Controller;
import com.walker.controllers.CreateReimbsController;
import com.walker.controllers.EmpReimbsController;
import com.walker.controllers.FmReimbsController;
import com.walker.controllers.LoginController;
import com.walker.controllers.UpdateReimbsController;
import com.walker.enums.Options;

public class FrontControllerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
		Map<Options, Controller> controllerRegistry = new HashMap<Options, Controller>();
		
		public void init() {
			Controller LoginController = new LoginController();
			Controller UpdateReimbsController = new UpdateReimbsController();
			Controller FmReimbsController = new FmReimbsController();
			Controller EmpReimbsController = new EmpReimbsController();
			Controller CreateReimbsController = new CreateReimbsController();
			
			controllerRegistry.put(Options.LOGIN, LoginController);
			controllerRegistry.put(Options.UPDATE, UpdateReimbsController);
			controllerRegistry.put(Options.CREATE, CreateReimbsController);
			controllerRegistry.put(Options.EMP, EmpReimbsController);
			controllerRegistry.put(Options.FM, FmReimbsController);
		}

		public Controller getController(HttpServletRequest request) {
			// parsing string to get resource part
			String uri = request.getRequestURI();
			
			String[] strings = uri.split("/");
			System.out.println(uri);
			String resource = null;
			System.out.println(strings[2]);
			if(strings.length > 1) {
				// get resource if available
				resource = strings[2];
			}
			
			// Get an enumerated value from the enum
			Options opt = Options.getOptions(resource);
			
			return controllerRegistry.get(opt);
		}
		
		
		public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			System.out.println("Service 58 running");
			response.addHeader("Access-Control-Allow-Origin", "*");
			response.addHeader("Access-Control-Allow-Headers", "content-type");
			
			Controller controller = getController(request);
			System.out.println(controller);
			if (controller == null) {
				response.sendError(404);
				return;
			}
			request.setAttribute("controller", controller);
			try {
				super.service(request, response);
			} catch(Exception e) {
				e.printStackTrace();
			}
		}
		
		@Override
		protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			Controller controller = (Controller) request.getAttribute("controller");
			controller.handleGet(request, response);
		}
		
		@Override
		protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			System.out.println("Do Post 89 running");
			Controller controller = (Controller) request.getAttribute("controller");
			controller.handlePost(request, response);
		}
		
	}

//
//private static final long serialVersionUID = 8760459445237366153L;
//Map<String, Controller> controllerMap = Resources.map;
//
//private Controller getController(HttpServletRequest request) {
//	String uri = request.getRequestURI();
//	String requestedEndpoint = UriUtility.getEndpoint(uri);
//	
//	System.out.println("uri: " + requestedEndpoint); 	// debug
//	ArrayList<String> resources = new ArrayList<String>(controllerMap.keySet());
//	System.out.println(resources);
//	for(int i = 0; i < resources.size(); i++) {
//		String res = resources.get(i); //Application Resource
//		if(requestedEndpoint.equals(res)) {
//			System.out.println("Map controller to resource!");	// debug
//			System.out.println(controllerMap.get(res));
//			return controllerMap.get(res);
//		}
//	}
//	
//	// return to default not found controller
//	// response.sendError(404);
//	return null;
//}
//
//public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//	// addCORSHeaders();
//	response.addHeader("Access-Control-Allow-Origin", "http://localhost:4200");
//	response.addHeader("Access-Control-Allow-Headers", "content-type");
//	
//	Controller controller = getController(request);
//	request.setAttribute("controller", controller);
//	super.service(request, response);
//}
//
//@Override
//protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//	Controller controller = (Controller) request.getAttribute("controller");
//	controller.handleGet(request, response);
//}
//
//@Override
//protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//	Controller controller = (Controller) request.getAttribute("controller");
//	controller.handlePost(request, response);
//}