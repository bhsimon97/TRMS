package dev.simon.controllers;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;
import com.google.gson.JsonIOException;
import com.google.gson.JsonSyntaxException;

import dev.simon.models.Employee;
import dev.simon.models.Request;
import dev.simon.services.LoginService;
import dev.simon.services.RequestService;

public class RequestController {
	
	public static Gson gson = new Gson();
	public static RequestService rs = new RequestService();
	public static LoginService ls = new LoginService(); 
	
	public static void getLoggedInUsersRequests(HttpServletRequest request, HttpServletResponse response) throws IOException{
		HttpSession sess = request.getSession();
		Employee e = (Employee) sess.getAttribute("loggedInUser");
		
		List<Request> loggedInUsersRequests = rs.getSingleEmployeesRequests(e.getId());
		
		response.getWriter().append((loggedInUsersRequests != null) ? gson.toJson(loggedInUsersRequests) : "{}");
		System.out.println(loggedInUsersRequests);
	}
	
	public static void getBencoApprovableRequests(HttpServletRequest request, HttpServletResponse response) throws IOException {
		HttpSession sess = request.getSession();
		Employee e = (Employee) sess.getAttribute("loggedInUser");
		
		List<Request> bencoApprovableRequests = rs.getBencoApprovableRequests(e.getId());
		
		response.getWriter().append((bencoApprovableRequests != null) ? gson.toJson(bencoApprovableRequests) : "{}");
	}
	
	public static void getDhApprovableRequests(HttpServletRequest request, HttpServletResponse response) throws IOException {
		HttpSession sess = request.getSession();
		Employee e = (Employee) sess.getAttribute("loggedInUser");
		
		List<Request> dhApprovableRequests = rs.getDepartmentHeadApprovableRequests(e.getId());
		
		response.getWriter().append((dhApprovableRequests != null) ? gson.toJson(dhApprovableRequests) : "{}");
	}
	
	public static void getSupervisorApprovableRequests(HttpServletRequest request, HttpServletResponse response) throws IOException {
		HttpSession sess = request.getSession();
		Employee e = (Employee) sess.getAttribute("loggedInUser");
		
		List<Request> superApprovableRequests = rs.getSupervisorApprovableRequests(e.getId());
		
		response.getWriter().append((superApprovableRequests != null) ? gson.toJson(superApprovableRequests) : "{}");
	}
	
	public static void getAllApprovableRequests(HttpServletRequest request, HttpServletResponse response) throws IOException{
		HttpSession sess = request.getSession();
		Employee e = (Employee) sess.getAttribute("loggedInUser");
		
		List<Request> allApprovableRequests = rs.getAllApprovableRequests(e.getId());
		
		response.getWriter().append((allApprovableRequests != null) ? gson.toJson(allApprovableRequests) : "{}");
	}
	
	public static void getAllApprovedRequests(HttpServletRequest request, HttpServletResponse response) throws IOException {
		HttpSession sess = request.getSession();
		Employee e = (Employee) sess.getAttribute("loggedInUser");
		
		List<Request> approvedRequests = rs.getAllApprovedRequests(e.getId());
		
		response.getWriter().append((approvedRequests != null) ? gson.toJson(approvedRequests) : "{}");
	}
	
	public static void getAllDeniedRequests(HttpServletRequest request, HttpServletResponse response) throws IOException {
		HttpSession sess = request.getSession();
		Employee e = (Employee) sess.getAttribute("loggedInUser");
		
		List<Request> deniedRequests = rs.getAllDeniedRequests(e.getId());
		
		response.getWriter().append((deniedRequests != null) ? gson.toJson(deniedRequests) : "{}");
	}
	
	public static void updateRequests(HttpServletRequest request, HttpServletResponse response) throws JsonSyntaxException, JsonIOException, IOException {
		Request r = gson.fromJson(request.getReader(), Request.class);
		rs.updateRequest(r);
		Employee e = ls.getEmployee(r.getEmployeeId());
		
		if(r.getSupervisorApproval() == 2 || r.getDhApproval() == 2 || r.getBencoApproval() == 2) {
			ls.updateBalance(e.getId(), (e.getBalance() + r.getAmountRequested()));
		}
		
	}
	
	public static void createRequest(HttpServletRequest request, HttpServletResponse respose) throws JsonSyntaxException, JsonIOException, IOException {
		Request r = gson.fromJson(request.getReader(), Request.class);
		HttpSession sess = request.getSession();
		Employee e = (Employee) sess.getAttribute("loggedInUser");
		rs.addRequest(r, e);
		ls.updateBalance(e.getId(), (e.getBalance() - r.getAmountRequested()));
		System.out.println(r.toString());
		System.out.println(e.toString());
	}


	/*
	 * TODO:
	 * Get approvable requests for Benco, DH, and Supervisor - done but must check if works
	 * Then add those into the RequestHelper
	 * Create methods for creating a new request
	 * I think all that's left after that is to just do the front-end implementation of 
	 * all the request things? Remember loggedInUser is stored in the session as username
	 * 
	 * Also browser automation testing and maybe JDBC testing?
	 */
}
