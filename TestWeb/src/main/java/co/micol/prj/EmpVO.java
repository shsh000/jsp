package co.micol.prj;

public class EmpVO {

	private String employeeID;
	private String lastName;
	private String email;
	private String hireDate;
	private String jobID;

	// 생성자
	public EmpVO(String employeeID, String lastName, String email, String hireDate, String jobID) {
		super();
		this.employeeID = employeeID;
		this.lastName = lastName;
		this.email = email;
		this.hireDate = hireDate;
		this.jobID = jobID;
	}

	// 기본 생성자
	public EmpVO() {
		super();
	}

	// getters, setters
	public String getEmployeeID() {
		return employeeID;
	}

	public void setEmployeeID(String employeeID) {
		this.employeeID = employeeID;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getHireDate() {
		return hireDate;
	}

	public void setHireDate(String hireDate) {
		this.hireDate = hireDate;
	}

	public String getJobID() {
		return jobID;
	}

	public void setJobID(String jobID) {
		this.jobID = jobID;
	}

}
