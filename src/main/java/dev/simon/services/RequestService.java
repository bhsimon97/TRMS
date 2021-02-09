package dev.simon.services;

import java.util.List;

import dev.simon.models.Employee;
import dev.simon.models.Request;
import dev.simon.repositories.RequestRepository;
import dev.simon.repositories.RequestRepositoryImpl;

public class RequestService {
	
	private RequestRepository rr = new RequestRepositoryImpl();
	
	public boolean addRequest(Request r, Employee e) {
		return rr.addRequest(r, e);
	}
	
	public List<Request> getSingleEmployeesRequests(int id) {
		return rr.getSingleEmployeesRequests(id);
	}
	
	public List<Request> getSingleEmployeesRequests(String firstName, String lastName){
		return rr.getSingleEmployeesRequests(firstName, lastName);
	}
	
	public List<Request> getSingleEmployeesRequests(String username){
		return rr.getSingleEmployeesRequests(username);
	}
	
	public List<Request> getBencoApprovableRequests(int id){
		return rr.getBencoApprovableRequests(id);
	}
	
	public List<Request> getSupervisorApprovableRequests(int id){
		return rr.getSupervisorApprovableRequests(id);
	}
	
	public List<Request> getDepartmentHeadApprovableRequests(int id){
		return rr.getDhApprovableRequests(id);
	}
	
	public List<Request> getAllApprovableRequests(int id){
		return rr.getAllApprovableRequests(id);
	}
	
	public List<Request> getAllApprovedRequests(int id){
		return rr.getAllApprovedRequests(id);
	}
	
	public List<Request> getAllDeniedRequests(int id){
		return rr.getAllDeniedRequests(id);
	}
	
	public boolean updateRequest(Request r) {
		return rr.updateRequest(r);
	}

}
