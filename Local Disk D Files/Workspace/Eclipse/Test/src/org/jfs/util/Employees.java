package org.jfs.util;

import java.util.Objects;

import org.jfs.day01.Designation;
import org.jfs.day01.Employee;

public class Employees {
	public static Employee getEmployeeForDeptBuckets(int eNo,String eName,int deptNo,Designation desg) {
		return new Employee(eNo,eName,deptNo,desg) {
			@Override
			public int hashCode() {
				return deptNo;
			}
		};
	}
	
	public static Employee getEmployeeForDeptBucketsCustom(int eNo,String eName,int deptNo,Designation desg) {
		return new Employee(eNo,eName,deptNo,desg) {
			@Override
			public int hashCode() {
				if(deptNo == 10) return -1;
				else if(deptNo == 20 || deptNo == 30) return 0;
				else return 1;
			}
			
		};
	}
	
	public static Employee getEmployeeForDesignationBuckets(int eNo,String eName,int deptNo,Designation desg) {
		return new Employee(eNo,eName,deptNo,desg) {
			@Override
			public int hashCode() {
				return Objects.hash(desg);
			}
		};
	}
}
