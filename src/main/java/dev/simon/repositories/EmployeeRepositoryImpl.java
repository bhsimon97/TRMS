package dev.simon.repositories;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dev.simon.models.Employee;
import dev.simon.util.JDBCConnection;

public class EmployeeRepositoryImpl implements EmployeeRepository{
	
	public static Connection conn = JDBCConnection.getConnection();

	@Override 
	public Employee getEmployee(int id) {
		try {
			String sql = "SELECT * FROM employees WHERE employee_id = ?";
			
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, Integer.toString(id));
			
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()) {
				Employee e = new Employee();
				e.setId(rs.getInt("EMPLOYEE_ID"));
				e.setUsername(rs.getString("USERNAME"));
				e.setPassword(rs.getString("PASSWORD"));
				e.setFirstName(rs.getString("FIRST_NAME"));
				e.setLastName(rs.getString("LAST_NAME"));
				e.setDepartmentId(rs.getInt("DEPARTMENT_ID"));
				e.setEmail(rs.getString("EMAIL"));
				e.setBalance(rs.getDouble("BALANCE"));
				e.setPosition(rs.getInt("POSITION"));
				e.setBencoId(rs.getInt("BENCO_ID"));
				
				return e;
				
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	@Override
	public Employee getEmployee(String username, String password) {
		try {
			String sql = "SELECT * FROM employees WHERE username = ? AND password = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, username);
			ps.setString(2, password);
			
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()) {
				Employee e = new Employee();
				e.setId(rs.getInt("EMPLOYEE_ID"));
				e.setUsername(rs.getString("USERNAME"));
				e.setPassword(rs.getString("PASSWORD"));
				e.setFirstName(rs.getString("FIRST_NAME"));
				e.setLastName(rs.getString("LAST_NAME"));
				e.setDepartmentId(rs.getInt("DEPARTMENT_ID"));
				e.setEmail(rs.getString("EMAIL"));
				e.setBalance(rs.getDouble("BALANCE"));
				e.setPosition(rs.getInt("POSITION"));
				e.setSupervisorId(rs.getInt("SUPERVISOR_ID"));
				e.setBencoId(rs.getInt("BENCO_ID"));
				e.setDhId(rs.getInt("DH_ID"));
				
				return e;	
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	@Override
	public Employee getEmployee(String username) {
		try {
			String sql = "SELECT * FROM employees WHERE username = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, username);
			
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()) {
				Employee e = new Employee();
				e.setId(rs.getInt("EMPLOYEE_ID"));
				e.setUsername(rs.getString("USERNAME"));
				e.setPassword(rs.getString("PASSWORD"));
				e.setFirstName(rs.getString("FIRST_NAME"));
				e.setLastName(rs.getString("LAST_NAME"));
				e.setDepartmentId(rs.getInt("DEPARTMENT_ID"));
				e.setEmail(rs.getString("EMAIL"));
				e.setBalance(rs.getDouble("BALANCE"));
				e.setPosition(rs.getInt("POSITION"));
				
				return e;	
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public boolean addEmployee(Employee e) {
		try {
			String sql = "CALL add_employee(?,?,?,?,?,?,?,?)";
			CallableStatement cs = conn.prepareCall(sql);
			cs.setString(1, e.getFirstName());
			cs.setString(2, e.getLastName());
			cs.setInt(3, e.getPosition());
			cs.setString(4, e.getEmail());
			cs.setInt(5, e.getDepartmentId());
			cs.setInt(6, e.getSupervisorId());
			cs.setString(7, e.getUsername());
			cs.setString(8, e.getPassword());
			
			cs.execute();
			return true;
		}catch(SQLException ex) {
			ex.printStackTrace();
		}
		return false;
	}

	@Override
	public List<Employee> getAllEmployees() {
		List<Employee> allEmployees = new ArrayList<Employee>();
		
		try {
			String sql = "SELECT * FROM employees";
			PreparedStatement ps = conn.prepareStatement(sql);
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				Employee e = new Employee();
				
				e.setBalance(rs.getDouble("BALANCE"));
				e.setDepartmentId(rs.getInt("DEPARTMENT_ID"));
				e.setEmail(rs.getString("EMAIL"));
				e.setFirstName(rs.getString("FIRST_NAME"));
				e.setId(rs.getInt("ID"));
				e.setLastName(rs.getString("LAST_NAME"));
				e.setPassword(rs.getString("PASSWORD"));
				e.setPosition(rs.getInt("POSITION"));
				e.setSupervisorId(rs.getInt("SUPERVISOR_ID"));
				e.setUsername(rs.getString("USERNAME"));
				
				allEmployees.add(e);
			}
		}catch(SQLException ex) {
			ex.printStackTrace();
		}
		return allEmployees;
	}

	@Override
	public boolean updateEmployee(Employee change) {
		try {
			String sql = "UPDATE employees SET first_name = ?, last_name = ?, username = ?, password = ?, department_id = ?, position = ?, email = ?, supervisor_id = ? WHERE id = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, change.getFirstName());
			ps.setString(2, change.getLastName());
			ps.setString(3, change.getUsername());
			ps.setString(4, change.getPassword());
			ps.setInt(5, change.getDepartmentId());
			ps.setInt(6, change.getPosition());
			ps.setString(7, change.getEmail());
			ps.setInt(8, change.getSupervisorId());
			ps.setInt(9, change.getId());
			
			ps.executeQuery();
			return true;
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	
	@Override
	public boolean updateBalance(int id, double balance) {
		try {
			String sql = "UPDATE employees SET balance = ? WHERE employee_id = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setDouble(1, balance);
			ps.setInt(2, id);
			
			ps.executeQuery();
			return true;
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean deleteEmployee(int id) {
		try {
			String sql = "DELETE employees WHERE id = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			
			ps.setInt(1, id);
			
			ps.executeQuery();
			return true;
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

}
