package dev.simon.models;

public class Request {
	
	private int id;
	private int employeeId;
	private String employeeFirstName;
	private String employeeLastName;
	private int supervisorId;
	private int supervisorApproval;
	private String supervisorComments;
	private int dhId;
	private int dhApproval;
	private String dhComments;
	private int bencoId;
	private int bencoApproval;
	private String bencoComments;
	private String courseType;
	private double amountRequested;
	private String gradingFormat;
	private String location;
	private String dateRequested;
	private String dateCompleted;
	private double hoursMissed;
	private String miscInfo;
	private String suptype;
	
	public Request() {
		super();
	}
	
	public Request(int employeeId, String courseType, double amountRequested, String gradingFormat, String location,
			String dateRequested, double hoursMissed, String miscInfo) {
		super();
		this.employeeId = employeeId;
		this.courseType = courseType;
		this.amountRequested = amountRequested;
		this.gradingFormat = gradingFormat;
		this.location = location;
		this.dateRequested = dateRequested;
		this.hoursMissed = hoursMissed;
		this.miscInfo = miscInfo;
	}

	public Request(int employeeId, String courseType, double amountRequested, String gradingFormat, String location,
			String dateRequested, double hoursMissed) {
		super();
		this.employeeId = employeeId;
		this.courseType = courseType;
		this.amountRequested = amountRequested;
		this.gradingFormat = gradingFormat;
		this.location = location;
		this.dateRequested = dateRequested;
		this.hoursMissed = hoursMissed;
	}
	
	

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	public String getEmployeeFirstName() {
		return employeeFirstName;
	}
	
	public void setEmployeeFirstName(String employeeFirstName) {
		this.employeeFirstName = employeeFirstName;
	}
	
	public String getEmployeeLastName() {
		return employeeLastName;
	}
	
	public void setEmployeeLastName(String employeeLastName) {
		this.employeeLastName = employeeLastName;
	}

	public int getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}

	public int getSupervisorId() {
		return supervisorId;
	}

	public void setSupervisorId(int supervisorId) {
		this.supervisorId = supervisorId;
	}

	public int getSupervisorApproval() {
		return supervisorApproval;
	}

	public void setSupervisorApproval(int supervisorApproval) {
		this.supervisorApproval = supervisorApproval;
	}

	public String getSupervisorComments() {
		return supervisorComments;
	}

	public void setSupervisorComments(String supervisorComments) {
		this.supervisorComments = supervisorComments;
	}

	public int getDhId() {
		return dhId;
	}

	public void setDhId(int dhId) {
		this.dhId = dhId;
	}

	public int getDhApproval() {
		return dhApproval;
	}

	public void setDhApproval(int dhApproval) {
		this.dhApproval = dhApproval;
	}

	public String getDhComments() {
		return dhComments;
	}

	public void setDhComments(String dhComments) {
		this.dhComments = dhComments;
	}

	public int getBencoId() {
		return bencoId;
	}

	public void setBencoId(int bencoId) {
		this.bencoId = bencoId;
	}

	public int getBencoApproval() {
		return bencoApproval;
	}

	public void setBencoApproval(int bencoApproval) {
		this.bencoApproval = bencoApproval;
	}

	public String getBencoComments() {
		return bencoComments;
	}

	public void setBencoComments(String bencoComments) {
		this.bencoComments = bencoComments;
	}

	public String getCourseType() {
		return courseType;
	}

	public void setCourseType(String courseType) {
		this.courseType = courseType;
	}

	public double getAmountRequested() {
		return amountRequested;
	}

	public void setAmountRequested(double amountRequested) {
		this.amountRequested = amountRequested;
	}

	public String getGradingFormat() {
		return gradingFormat;
	}

	public void setGradingFormat(String gradingFormat) {
		this.gradingFormat = gradingFormat;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getDateRequested() {
		return dateRequested;
	}

	public void setDateRequested(String dateRequested) {
		this.dateRequested = dateRequested;
	}

	public String getDateCompleted() {
		return dateCompleted;
	}

	public void setDateCompleted(String dateCompleted) {
		this.dateCompleted = dateCompleted;
	}

	public double getHoursMissed() {
		return hoursMissed;
	}

	public void setHoursMissed(double hoursMissed) {
		this.hoursMissed = hoursMissed;
	}

	public String getMiscInfo() {
		return miscInfo;
	}

	public void setMiscInfo(String miscInfo) {
		this.miscInfo = miscInfo;
	}
	
	public String getSuptype() {
		return suptype;
	}
	
	public void setSuptype(String suptype) {
		this.suptype = suptype;
	}

	@Override
	public String toString() {
		return "Request [id=" + id + ", employeeId=" + employeeId + ", employeeFirstName=" + employeeFirstName
				+ ", employeeLastName=" + employeeLastName + ", supervisorId=" + supervisorId + ", supervisorApproval="
				+ supervisorApproval + ", supervisorComments=" + supervisorComments + ", dhId=" + dhId + ", dhApproval="
				+ dhApproval + ", dhComments=" + dhComments + ", bencoId=" + bencoId + ", bencoApproval="
				+ bencoApproval + ", bencoComments=" + bencoComments + ", courseType=" + courseType
				+ ", amountRequested=" + amountRequested + ", gradingFormat=" + gradingFormat + ", location=" + location
				+ ", dateRequested=" + dateRequested + ", dateCompleted=" + dateCompleted + ", hoursMissed="
				+ hoursMissed + ", miscInfo=" + miscInfo + ", suptype=" + suptype + "]";
	}

	
	
	
	

}
