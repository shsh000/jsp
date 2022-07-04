package co.micol.prj;

public class EmpVO {

	private String employeeID;
	private String firstName;
	private String salary;

	// 생성자
	public EmpVO(String employeeID, String firstName, String salary) {
		super();
		this.employeeID = employeeID;
		this.firstName = firstName;
		this.salary = salary;
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

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getSalary() {
		return salary;
	}

	public void setSalary(String salary) {
		this.salary = salary;
	}
}
