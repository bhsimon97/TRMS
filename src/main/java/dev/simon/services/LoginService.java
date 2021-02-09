package dev.simon.services;

import dev.simon.models.Employee;
import dev.simon.repositories.EmployeeRepository;
import dev.simon.repositories.EmployeeRepositoryImpl;

public class LoginService {
	
	private EmployeeRepository er = new EmployeeRepositoryImpl();
	
	public Employee getEmployee(String username, String password) {
		return er.getEmployee(username, password);
	}
	
	public Employee getEmployee(int id) {
		return er.getEmployee(id);
	}
	
	public boolean updateBalance(int id, double balance) {
		return er.updateBalance(id, balance);
	}

}
