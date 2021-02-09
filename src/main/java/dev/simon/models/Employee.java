package dev.simon.models;

public class Employee {

	private int id;
	private String firstName;
	private String lastName;
	private int departmentId;
	private int position;
	private String email;
	private String username;
	private String password;
	private int supervisorId;
	private double balance;
	private int bencoId;
	private int dhId;
	
	public Employee() {
		super();
	}

	public Employee(String firstName, String lastName, int departmentId, int position, String email, String username,
			String password, int supervisorId, int dhId, int bencoId) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.departmentId = departmentId;
		this.position = position;
		this.email = email;
		this.username = username;
		this.password = password;
		this.supervisorId = supervisorId;
		this.dhId = dhId;
		this.bencoId = bencoId;
	}

	public Employee(String firstName, String lastName, int departmentId, int position, String email, String username,
			String password) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.departmentId = departmentId;
		this.position = position;
		this.email = email;
		this.username = username;
		this.password = password;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	public int getDhId() {
		return dhId;
	}

	public void setDhId(int dhId) {
		this.dhId = dhId;
	}
	
	public int getBencoId() {
		return bencoId;
	}

	public void setBencoId(int bencoId) {
		this.bencoId = bencoId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public int getDepartmentId() {
		return departmentId;
	}

	public void setDepartmentId(int departmentId) {
		this.departmentId = departmentId;
	}

	public int getPosition() {
		return position;
	}

	public void setPosition(int position) {
		this.position = position;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getSupervisorId() {
		return supervisorId;
	}

	public void setSupervisorId(int supervisorId) {
		this.supervisorId = supervisorId;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}
	
	@Override
	public String toString() {
		return "Employee [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", departmentId="
				+ departmentId + ", position=" + position + ", email=" + email + ", username=" + username
				+ ", password=" + password + ", supervisorId=" + supervisorId + ", bencoId = " + bencoId + ", balance=" + balance + "]";
	}
	
	

}
