package dev.simon.servlets;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dev.simon.controllers.LoginController;
import dev.simon.controllers.RequestController;

public class RequestHelper {
	
	public static void process(HttpServletRequest request, HttpServletResponse response) throws IOException {
		
		String uri = request.getRequestURI();
		
		switch(uri) {
		
		case "/Project1/login.do":{
			LoginController.login(request, response);			
			break;
		}
		case "/Project1/account.do":{
			RequestController.getLoggedInUsersRequests(request, response);
			break;
		}
		case "/Project1/approvedRequests.do":{
			RequestController.getAllApprovedRequests(request, response);
			break;
		}
		case "/Project1/approvableRequests.do":{
			RequestController.getAllApprovableRequests(request, response);
			break;
		}
		case "/Project1/deniedRequests.do":{
			RequestController.getAllDeniedRequests(request, response);
			break;
		}
		case "/Project1/updateRequest.do":{
			RequestController.updateRequests(request, response);
			break;
		}
		case "/Project1/createRequest.do":{
			RequestController.createRequest(request, response);
			break;			
		}
		case "/Project1/logout.do":{
			HttpSession sess = request.getSession();
			sess.invalidate();
			response.sendRedirect("http://localhost:8080/Project1/index.html");
			break;
		}
		case "/Project1/currentUser.do":{
			LoginController.getLoggedInUser(request, response);
			break;
		}
		default:{
			response.sendError(418, "Cannot brew coffee, is teapot.");
			break;
		}
	}
}
}
