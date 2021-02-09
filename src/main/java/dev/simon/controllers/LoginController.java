package dev.simon.controllers;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;

import dev.simon.models.Employee;
import dev.simon.services.LoginService;

public class LoginController {
	
	public static Gson gson = new Gson();
	public static LoginService ls = new LoginService();
	
	public static void login(HttpServletRequest request, HttpServletResponse response) throws IOException{
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		Employee e = ls.getEmployee(username, password);
		HttpSession sess = request.getSession();
		sess.setAttribute("loggedInUser", e);
		
		response.getWriter().append((e != null) ? gson.toJson(e) : "{}");
		
		System.out.println(e.toString());
		
		
	}
	
	public static void getLoggedInUser(HttpServletRequest request, HttpServletResponse response) throws IOException {
		HttpSession sess = request.getSession();
		Employee e = (Employee) sess.getAttribute("loggedInUser");
		Employee e2 = ls.getEmployee(e.getId());
		System.out.println(e.toString());
		
		response.getWriter().append((e2 != null) ? gson.toJson(e2) : "{}");
	}

}
