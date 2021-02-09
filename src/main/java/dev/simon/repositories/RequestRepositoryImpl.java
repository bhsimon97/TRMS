package dev.simon.repositories;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import java.sql.ResultSet;
import java.util.ArrayList;

import dev.simon.models.Employee;
import dev.simon.models.Request;
import dev.simon.util.JDBCConnection;

public class RequestRepositoryImpl implements RequestRepository{
	
	public static Connection conn = JDBCConnection.getConnection();

	@Override
	public boolean addRequest(Request r, Employee e) {
		try {			
			String sql = "CALL add_request(?,?,?,?,?,?,?,?,?,?,?,?)";
			CallableStatement cs = conn.prepareCall(sql);
			cs.setInt(1, e.getId());
			cs.setInt(2, e.getSupervisorId());
			cs.setInt(3, e.getDhId());
			cs.setInt(4, e.getBencoId());
			cs.setString(5, r.getCourseType());
			cs.setDouble(6, r.getAmountRequested());
			cs.setString(7, r.getGradingFormat());
			cs.setString(8, r.getLocation());
			cs.setString(9, r.getDateRequested());
			cs.setDouble(10, r.getHoursMissed());
			cs.setString(11, r.getMiscInfo());
			cs.setString(12, r.getDateCompleted());
			
			cs.execute();
			
			return true;
		}catch(SQLException ex) {
			ex.printStackTrace();
		}
		return false;
	}

	@Override
	public Request getRequest(int id) {
		try {
			String sql = "SELECT * FROM requests WHERE request_id = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			
			ps.setInt(1, id);
			
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()) {
				Request r = new Request();
				r.setAmountRequested(rs.getDouble("REQ_AMOUNT"));
				r.setBencoApproval(rs.getInt("BENCO_APPROVAL"));
				r.setBencoComments(rs.getString("BENCO_COMMENTS"));
				r.setBencoId(rs.getInt("BENCO_ID"));
				r.setCourseType(rs.getString("COURSE_TYPE"));
				r.setDateCompleted(rs.getString("DATE_COMPLETED"));
				r.setDateRequested(rs.getString("DATE_REQUESTED"));
				r.setDhApproval(rs.getInt("DEPARTMENT_HEAD_APPROVAL"));
				r.setDhComments(rs.getString("DEPARTMENT_HEAD_COMMENTS"));
				r.setDhId(rs.getInt("DEPARTMENT_HEAD_ID"));
				r.setEmployeeId(rs.getInt("EMPLOYEE_ID"));
				r.setGradingFormat(rs.getString("GRADING_FORMAT"));
				r.setHoursMissed(rs.getDouble("HOURS_MISSED"));
				r.setId(rs.getInt("REQUEST_ID"));
				r.setLocation(rs.getString("LOCATION"));
				r.setMiscInfo(rs.getString("MISC_INFO"));
				r.setSupervisorApproval(rs.getInt("SUPERVISOR_APPROVAL"));
				r.setSupervisorId(rs.getInt("SUPERVISOR_ID"));
				r.setSupervisorComments(rs.getString("SUPERVISOR_COMMENTS"));
				
				return r;
			}
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<Request> getAllRequests() {
		List<Request> allRequests = new ArrayList<Request>();
		
		try {
			String sql = "SELECT * FROM requests";
			PreparedStatement ps = conn.prepareStatement(sql);
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				Request r = new Request();
				
				r.setAmountRequested(rs.getDouble("REQ_AMOUNT"));
				r.setBencoApproval(rs.getInt("BENCO_APPROVAL"));
				r.setBencoComments(rs.getString("BENCO_COMMENTS"));
				r.setBencoId(rs.getInt("BENCO_ID"));
				r.setCourseType(rs.getString("COURSE_TYPE"));
				r.setDateCompleted(rs.getString("DATE_COMPLETED"));
				r.setDateRequested(rs.getString("DATE_REQUESTED"));
				r.setDhApproval(rs.getInt("DEPARTMENT_HEAD_APPROVAL"));
				r.setDhComments(rs.getString("DEPARTMENT_HEAD_COMMENTS"));
				r.setDhId(rs.getInt("DEPARTMENT_HEAD_ID"));
				r.setEmployeeId(rs.getInt("EMPLOYEE_ID"));
				r.setGradingFormat(rs.getString("GRADING_FORMAT"));
				r.setHoursMissed(rs.getDouble("HOURS_MISSED"));
				r.setId(rs.getInt("REQUEST_ID"));
				r.setLocation(rs.getString("LOCATION"));
				r.setMiscInfo(rs.getString("MISC_INFO"));
				r.setSupervisorApproval(rs.getInt("SUPERVISOR_APPROVAL"));
				r.setSupervisorId(rs.getInt("SUPERVISOR_ID"));
				r.setSupervisorComments(rs.getString("SUPERVISOR_COMMENTS"));
				
				allRequests.add(r);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return allRequests;
	}

	@Override
	public List<Request> getSingleEmployeesRequests(int employeeId) {
		List<Request> employeesRequests = new ArrayList<Request>();
		try {
			String sql = "SELECT * FROM requests WHERE employee_id = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, employeeId);
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				Request r = new Request();
				r.setAmountRequested(rs.getDouble("REQ_AMOUNT"));
				r.setBencoApproval(rs.getInt("BENCO_APPROVAL"));
				r.setBencoComments(rs.getString("BENCO_COMMENTS"));
				r.setBencoId(rs.getInt("BENCO_ID"));
				r.setCourseType(rs.getString("COURSE_TYPE"));
				r.setDateCompleted(rs.getString("DATE_COMPLETED"));
				r.setDateRequested(rs.getString("DATE_REQUESTED"));
				r.setDhApproval(rs.getInt("DEPARTMENT_HEAD_APPROVAL"));
				r.setDhComments(rs.getString("DEPARTMENT_HEAD_COMMENTS"));
				r.setDhId(rs.getInt("DEPARTMENT_HEAD_ID"));
				r.setEmployeeId(rs.getInt("EMPLOYEE_ID"));
				r.setGradingFormat(rs.getString("GRADING_FORMAT"));
				r.setHoursMissed(rs.getDouble("HOURS_MISSED"));
				r.setId(rs.getInt("REQUEST_ID"));
				r.setLocation(rs.getString("LOCATION"));
				r.setMiscInfo(rs.getString("MISC_INFO"));
				r.setSupervisorApproval(rs.getInt("SUPERVISOR_APPROVAL"));
				r.setSupervisorId(rs.getInt("SUPERVISOR_ID"));
				r.setSupervisorComments(rs.getString("SUPERVISOR_COMMENTS"));
				
				employeesRequests.add(r);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return employeesRequests;
	}
	
	@Override
	public List<Request> getSingleEmployeesRequests(String firstName, String lastName) {
		List<Request> employeesRequests = new ArrayList<Request>();
		try {
			String sql = "SELECT * FROM requests INNER JOIN employees WHERE first_name = ? AND last_name = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, firstName);
			ps.setString(2, lastName);
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				Request r = new Request();
				r.setAmountRequested(rs.getDouble("REQ_AMOUNT"));
				r.setBencoApproval(rs.getInt("BENCO_APPROVAL"));
				r.setBencoComments(rs.getString("BENCO_COMMENTS"));
				r.setBencoId(rs.getInt("BENCO_ID"));
				r.setCourseType(rs.getString("COURSE_TYPE"));
				r.setDateCompleted(rs.getString("DATE_COMPLETED"));
				r.setDateRequested(rs.getString("DATE_REQUESTED"));
				r.setDhApproval(rs.getInt("DEPARTMENT_HEAD_APPROVAL"));
				r.setDhComments(rs.getString("DEPARTMENT_HEAD_COMMENTS"));
				r.setDhId(rs.getInt("DEPARTMENT_HEAD_ID"));
				r.setEmployeeId(rs.getInt("EMPLOYEE_ID"));
				r.setGradingFormat(rs.getString("GRADING_FORMAT"));
				r.setHoursMissed(rs.getDouble("HOURS_MISSED"));
				r.setId(rs.getInt("REQUEST_ID"));
				r.setLocation(rs.getString("LOCATION"));
				r.setMiscInfo(rs.getString("MISC_INFO"));
				r.setSupervisorApproval(rs.getInt("SUPERVISOR_APPROVAL"));
				r.setSupervisorId(rs.getInt("SUPERVISOR_ID"));
				r.setSupervisorComments(rs.getString("SUPERVISOR_COMMENTS"));
				
				employeesRequests.add(r);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return employeesRequests;
	}
	
	@Override
	public List<Request> getSingleEmployeesRequests(String username) {
		List<Request> employeesRequests = new ArrayList<Request>();
		try {
			String sql = "SELECT * FROM requests INNER JOIN employees WHERE username = ? AND last_name = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, username);
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				Request r = new Request();
				r.setAmountRequested(rs.getDouble("REQ_AMOUNT"));
				r.setBencoApproval(rs.getInt("BENCO_APPROVAL"));
				r.setBencoComments(rs.getString("BENCO_COMMENTS"));
				r.setBencoId(rs.getInt("BENCO_ID"));
				r.setCourseType(rs.getString("COURSE_TYPE"));
				r.setDateCompleted(rs.getString("DATE_COMPLETED"));
				r.setDateRequested(rs.getString("DATE_REQUESTED"));
				r.setDhApproval(rs.getInt("DEPARTMENT_HEAD_APPROVAL"));
				r.setDhComments(rs.getString("DEPARTMENT_HEAD_COMMENTS"));
				r.setDhId(rs.getInt("DEPARTMENT_HEAD_ID"));
				r.setEmployeeId(rs.getInt("EMPLOYEE_ID"));
				r.setGradingFormat(rs.getString("GRADING_FORMAT"));
				r.setHoursMissed(rs.getDouble("HOURS_MISSED"));
				r.setId(rs.getInt("REQUEST_ID"));
				r.setLocation(rs.getString("LOCATION"));
				r.setMiscInfo(rs.getString("MISC_INFO"));
				r.setSupervisorApproval(rs.getInt("SUPERVISOR_APPROVAL"));
				r.setSupervisorId(rs.getInt("SUPERVISOR_ID"));
				r.setSupervisorComments(rs.getString("SUPERVISOR_COMMENTS"));
				
				employeesRequests.add(r);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return employeesRequests;
	}

	@Override
	public List<Request> getDhApprovableRequests(int id) {
		List<Request> approvableRequests = new ArrayList<Request>();
		try {
			String sql = "SELECT * FROM requests INNER JOIN employees ON requests.employee_id = employees.employee_id WHERE employees.dh_id = ? AND department_head_approval = 0 AND supervisor_approval = 1";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				Request r = new Request();
				
				r.setAmountRequested(rs.getDouble("REQ_AMOUNT"));
				r.setBencoApproval(rs.getInt("BENCO_APPROVAL"));
				r.setBencoComments(rs.getString("BENCO_COMMENTS"));
				r.setEmployeeFirstName(rs.getString("FIRST_NAME"));
				r.setEmployeeLastName(rs.getString("LAST_NAME"));
				r.setBencoId(rs.getInt("BENCO_ID"));
				r.setCourseType(rs.getString("COURSE_TYPE"));
				r.setDateCompleted(rs.getString("DATE_COMPLETED"));
				r.setDateRequested(rs.getString("DATE_REQUESTED"));
				r.setDhApproval(rs.getInt("DEPARTMENT_HEAD_APPROVAL"));
				r.setDhComments(rs.getString("DEPARTMENT_HEAD_COMMENTS"));
				r.setDhId(rs.getInt("DEPARTMENT_HEAD_ID"));
				r.setEmployeeId(rs.getInt("EMPLOYEE_ID"));
				r.setGradingFormat(rs.getString("GRADING_FORMAT"));
				r.setHoursMissed(rs.getDouble("HOURS_MISSED"));
				r.setId(rs.getInt("REQUEST_ID"));
				r.setLocation(rs.getString("LOCATION"));
				r.setMiscInfo(rs.getString("MISC_INFO"));
				r.setSupervisorApproval(rs.getInt("SUPERVISOR_APPROVAL"));
				r.setSupervisorId(rs.getInt("SUPERVISOR_ID"));
				r.setSupervisorComments(rs.getString("SUPERVISOR_COMMENTS"));
				
				approvableRequests.add(r);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return approvableRequests;
	}
	
	@Override
	public List<Request> getSupervisorApprovableRequests(int id) {
		List<Request> approvableRequests = new ArrayList<Request>();
		try {
			String sql = "SELECT * FROM requests INNER JOIN employees ON requests.employee_id = employees.employee_id WHERE employees.supervisor_id = ? AND supervisor_approval = 0";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				Request r = new Request();
				
				r.setEmployeeFirstName(rs.getString("FIRST_NAME"));
				r.setEmployeeLastName(rs.getString("LAST_NAME"));
				r.setAmountRequested(rs.getDouble("REQ_AMOUNT"));
				r.setBencoApproval(rs.getInt("BENCO_APPROVAL"));
				r.setBencoComments(rs.getString("BENCO_COMMENTS"));
				r.setBencoId(rs.getInt("BENCO_ID"));
				r.setCourseType(rs.getString("COURSE_TYPE"));
				r.setDateCompleted(rs.getString("DATE_COMPLETED"));
				r.setDateRequested(rs.getString("DATE_REQUESTED"));
				r.setDhApproval(rs.getInt("DEPARTMENT_HEAD_APPROVAL"));
				r.setDhComments(rs.getString("DEPARTMENT_HEAD_COMMENTS"));
				r.setDhId(rs.getInt("DEPARTMENT_HEAD_ID"));
				r.setEmployeeId(rs.getInt("EMPLOYEE_ID"));
				r.setGradingFormat(rs.getString("GRADING_FORMAT"));
				r.setHoursMissed(rs.getDouble("HOURS_MISSED"));
				r.setId(rs.getInt("REQUEST_ID"));
				r.setLocation(rs.getString("LOCATION"));
				r.setMiscInfo(rs.getString("MISC_INFO"));
				r.setSupervisorApproval(rs.getInt("SUPERVISOR_APPROVAL"));
				r.setSupervisorId(rs.getInt("SUPERVISOR_ID"));
				r.setSupervisorComments(rs.getString("SUPERVISOR_COMMENTS"));
				
				approvableRequests.add(r);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return approvableRequests;
	}

	@Override
	public List<Request> getBencoApprovableRequests(int id) {
		List<Request> approvableRequests = new ArrayList<Request>();
		try {
			String sql = "SELECT * FROM requests INNER JOIN employees ON requests.employee_id = employees.employee_id WHERE employees.benco_id = ? AND benco_approval = 0 AND department_head_approval = 1";
			
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				Request r = new Request();
				
				r.setEmployeeFirstName(rs.getString("FIRST_NAME"));
				r.setEmployeeLastName(rs.getString("LAST_NAME"));
				r.setAmountRequested(rs.getDouble("REQ_AMOUNT"));
				r.setBencoApproval(rs.getInt("BENCO_APPROVAL"));
				r.setBencoComments(rs.getString("BENCO_COMMENTS"));
				r.setBencoId(rs.getInt("BENCO_ID"));
				r.setCourseType(rs.getString("COURSE_TYPE"));
				r.setDateCompleted(rs.getString("DATE_COMPLETED"));
				r.setDateRequested(rs.getString("DATE_REQUESTED"));
				r.setDhApproval(rs.getInt("DEPARTMENT_HEAD_APPROVAL"));
				r.setDhComments(rs.getString("DEPARTMENT_HEAD_COMMENTS"));
				r.setDhId(rs.getInt("DEPARTMENT_HEAD_ID"));
				r.setEmployeeId(rs.getInt("EMPLOYEE_ID"));
				r.setGradingFormat(rs.getString("GRADING_FORMAT"));
				r.setHoursMissed(rs.getDouble("HOURS_MISSED"));
				r.setId(rs.getInt("REQUEST_ID"));
				r.setLocation(rs.getString("LOCATION"));
				r.setMiscInfo(rs.getString("MISC_INFO"));
				r.setSupervisorApproval(rs.getInt("SUPERVISOR_APPROVAL"));
				r.setSupervisorId(rs.getInt("SUPERVISOR_ID"));
				r.setSupervisorComments(rs.getString("SUPERVISOR_COMMENTS"));
				
				approvableRequests.add(r);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return approvableRequests;
	}
	
	@Override
	public List<Request> getAllApprovableRequests(int id) {
		List<Request> approvableRequests = new ArrayList<Request>();
		try {
			String sql = "SELECT * FROM requests JOIN employees ON requests.employee_id = employees.employee_id WHERE (requests.supervisor_id = ? AND requests.supervisor_approval = 0) OR (requests.department_head_id = ? AND requests.supervisor_approval = 1) OR (requests.benco_id = ? AND requests.department_head_approval = 1)";
			
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			ps.setInt(2, id);
			ps.setInt(3, id);
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				Request r = new Request();
				
				r.setEmployeeFirstName(rs.getString("FIRST_NAME"));
				r.setEmployeeLastName(rs.getString("LAST_NAME"));
				r.setAmountRequested(rs.getDouble("REQ_AMOUNT"));
				r.setBencoApproval(rs.getInt("BENCO_APPROVAL"));
				r.setBencoComments(rs.getString("BENCO_COMMENTS"));
				r.setBencoId(rs.getInt("BENCO_ID"));
				r.setCourseType(rs.getString("COURSE_TYPE"));
				r.setDateCompleted(rs.getString("DATE_COMPLETED"));
				r.setDateRequested(rs.getString("DATE_REQUESTED"));
				r.setDhApproval(rs.getInt("DEPARTMENT_HEAD_APPROVAL"));
				r.setDhComments(rs.getString("DEPARTMENT_HEAD_COMMENTS"));
				r.setDhId(rs.getInt("DEPARTMENT_HEAD_ID"));
				r.setEmployeeId(rs.getInt("EMPLOYEE_ID"));
				r.setGradingFormat(rs.getString("GRADING_FORMAT"));
				r.setHoursMissed(rs.getDouble("HOURS_MISSED"));
				r.setId(rs.getInt("REQUEST_ID"));
				r.setLocation(rs.getString("LOCATION"));
				r.setMiscInfo(rs.getString("MISC_INFO"));
				r.setSupervisorApproval(rs.getInt("SUPERVISOR_APPROVAL"));
				r.setSupervisorId(rs.getInt("SUPERVISOR_ID"));
				r.setSupervisorComments(rs.getString("SUPERVISOR_COMMENTS"));
				
				approvableRequests.add(r);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return approvableRequests;
	}
	
	public List<Request> getAllApprovedRequests(int id){
		List<Request> approvedRequests = new ArrayList<Request>();
		
		try {
			String sql = "SELECT * FROM requests JOIN employees ON employees.employee_id = requests.employee_id WHERE requests.employee_id = ? AND benco_approval = 1";
			PreparedStatement ps = conn.prepareStatement(sql);
			
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				Request r = new Request();
				
				r.setEmployeeFirstName(rs.getString("FIRST_NAME"));
				r.setEmployeeLastName(rs.getString("LAST_NAME"));
				r.setAmountRequested(rs.getDouble("REQ_AMOUNT"));
				r.setBencoApproval(rs.getInt("BENCO_APPROVAL"));
				r.setBencoComments(rs.getString("BENCO_COMMENTS"));
				r.setBencoId(rs.getInt("BENCO_ID"));
				r.setCourseType(rs.getString("COURSE_TYPE"));
				r.setDateCompleted(rs.getString("DATE_COMPLETED"));
				r.setDateRequested(rs.getString("DATE_REQUESTED"));
				r.setDhApproval(rs.getInt("DEPARTMENT_HEAD_APPROVAL"));
				r.setDhComments(rs.getString("DEPARTMENT_HEAD_COMMENTS"));
				r.setDhId(rs.getInt("DEPARTMENT_HEAD_ID"));
				r.setEmployeeId(rs.getInt("EMPLOYEE_ID"));
				r.setGradingFormat(rs.getString("GRADING_FORMAT"));
				r.setHoursMissed(rs.getDouble("HOURS_MISSED"));
				r.setId(rs.getInt("REQUEST_ID"));
				r.setLocation(rs.getString("LOCATION"));
				r.setMiscInfo(rs.getString("MISC_INFO"));
				r.setSupervisorApproval(rs.getInt("SUPERVISOR_APPROVAL"));
				r.setSupervisorId(rs.getInt("SUPERVISOR_ID"));
				r.setSupervisorComments(rs.getString("SUPERVISOR_COMMENTS"));
				
				approvedRequests.add(r);
			}
			
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		
		return approvedRequests;
	}
	
	public List<Request> getAllDeniedRequests(int id){
		List<Request> deniedRequests = new ArrayList<Request>();
		
		try {
			String sql = "SELECT * FROM requests WHERE employee_id = ? AND (benco_approval = 2 OR supervisor_approval = 2 OR department_head_approval = 2)";
			PreparedStatement ps = conn.prepareStatement(sql);
			
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				Request r = new Request();
				
				r.setEmployeeFirstName(rs.getString("FIRST_NAME"));
				r.setEmployeeLastName(rs.getString("LAST_NAME"));
				r.setAmountRequested(rs.getDouble("REQ_AMOUNT"));
				r.setBencoApproval(rs.getInt("BENCO_APPROVAL"));
				r.setBencoComments(rs.getString("BENCO_COMMENTS"));
				r.setBencoId(rs.getInt("BENCO_ID"));
				r.setCourseType(rs.getString("COURSE_TYPE"));
				r.setDateCompleted(rs.getString("DATE_COMPLETED"));
				r.setDateRequested(rs.getString("DATE_REQUESTED"));
				r.setDhApproval(rs.getInt("DEPARTMENT_HEAD_APPROVAL"));
				r.setDhComments(rs.getString("DEPARTMENT_HEAD_COMMENTS"));
				r.setDhId(rs.getInt("DEPARTMENT_HEAD_ID"));
				r.setEmployeeId(rs.getInt("EMPLOYEE_ID"));
				r.setGradingFormat(rs.getString("GRADING_FORMAT"));
				r.setHoursMissed(rs.getDouble("HOURS_MISSED"));
				r.setId(rs.getInt("REQUEST_ID"));
				r.setLocation(rs.getString("LOCATION"));
				r.setMiscInfo(rs.getString("MISC_INFO"));
				r.setSupervisorApproval(rs.getInt("SUPERVISOR_APPROVAL"));
				r.setSupervisorId(rs.getInt("SUPERVISOR_ID"));
				r.setSupervisorComments(rs.getString("SUPERVISOR_COMMENTS"));
				
				deniedRequests.add(r);
			}
			
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		
		return deniedRequests;
	}

	@Override
	public boolean updateRequest(Request r) {
		System.out.println(r);
		
		try {
			String sql = "UPDATE requests SET supervisor_approval = ?, supervisor_comments = ?, department_head_approval = ?, department_head_comments = ?, benco_approval = ?, benco_comments = ?, req_amount = ? WHERE request_id = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			
			ps.setInt(1, r.getSupervisorApproval());
			ps.setString(2, r.getSupervisorComments());
			ps.setInt(3, r.getDhApproval());
			ps.setString(4, r.getDhComments());
			ps.setInt(5, r.getBencoApproval());
			ps.setString(6, r.getBencoComments());
			ps.setDouble(7, r.getAmountRequested());
			ps.setInt(8, r.getId());
			
			ps.executeQuery();
			
			
//			if(r.getBencoApproval() == 1) {
//				String sql2 = "SELECT * FROM employees WHERE employee_id = ?";
//				PreparedStatement ps2 = conn.prepareStatement(sql2);
//				ps2.setInt(1, r.getEmployeeId());
//				ResultSet rs = ps2.executeQuery();
//				Employee e = new Employee();
//	
//				if(rs.next()) {
//					e.setBalance(rs.getDouble("BALANCE") - r.getAmountRequested());
//					e.setId(rs.getInt("EMPLOYEE_ID"));
//					
//					String sql3 = "UPDATE employees SET balance = ? WHERE employee_id = ?";
//					PreparedStatement ps3 = conn.prepareStatement(sql3);
//					ps3.setDouble(1, e.getBalance());
//					ps3.setInt(2, e.getId());
//					
//					System.out.println("Inside the Results Set: " + e.toString());
//				}
//			}
			return true;
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean deleteRequest(Request r) {
		try {
			String sql = "DELETE requests WHERE request_id = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			
			ps.setInt(1,r.getId());
			ps.executeQuery();
			return true;
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

}
