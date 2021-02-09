package dev.simon.repositories;

import java.util.List;

import dev.simon.models.Employee;

public interface EmployeeRepository {
	
	public Employee getEmployee(int id);
	public Employee getEmployee(String username, String password);
	public Employee getEmployee(String username);
	public boolean addEmployee(Employee e);
	public List<Employee> getAllEmployees();
	public boolean updateEmployee(Employee change);
	public boolean updateBalance(int id, double balance);
	public boolean deleteEmployee(int id);

}
