package assignmentz;

import java.io.Serializable;
import java.util.Objects;

public class Employee implements Comparable<Employee>, Serializable {
	private int empId;
	private String empName;
	private int dNo;
	
	public Employee() {} 

	public Employee(int empId, String empName, int dNo) {
		super();
		this.empId = empId;
		this.empName = empName;
		this.dNo = dNo;
	}


	@Override
	public int compareTo(Employee o) {
		return 0;
	}

	@Override
	public int hashCode() {
		return Objects.hash(dNo, empId, empName);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Employee other = (Employee) obj;
		return dNo == other.dNo && empId == other.empId && Objects.equals(empName, other.empName);
	}

	public int getEmpId() {
		return empId;
	}

	public void setEmpId(int empId) {
		this.empId = empId;
	}

	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	public int getdNo() {
		return dNo;
	}

	public void setdNo(int dNo) {
		this.dNo = dNo;
	}

	@Override
	public String toString() {
		return "Employee [empId = " + empId + ", empName = " + empName + ", dNo = " + dNo + "]";
	}

	
}
