package dev.simon.repositories;

import java.util.List;

import dev.simon.models.Employee;
import dev.simon.models.Request;

public interface RequestRepository {
	
	public boolean addRequest(Request r, Employee e);
	public Request getRequest(int id);
	public List<Request> getAllRequests();
	public List<Request> getSingleEmployeesRequests(int employeeId);
	public List<Request> getSingleEmployeesRequests(String firstName, String lastName);
	public List<Request> getSingleEmployeesRequests(String username);
	public List<Request> getDhApprovableRequests(int id);
	public List<Request> getBencoApprovableRequests(int id);
	public List<Request> getSupervisorApprovableRequests(int id);
	public List<Request> getAllApprovableRequests(int id);
	public List<Request> getAllApprovedRequests(int id);
	public List<Request> getAllDeniedRequests(int id);
	public boolean updateRequest(Request r);
	public boolean deleteRequest(Request r);

}
