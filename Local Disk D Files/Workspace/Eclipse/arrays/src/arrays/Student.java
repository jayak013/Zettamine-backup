package arrays;

import java.util.Objects;

public class Student {
	private static int count;
	
	private int stuId;
	private String stuName;
	
	public Student() {}
	
	public Student(int stuId, String stuName) {
		super();
		count++;
		this.stuId = stuId;
		this.stuName = stuName;
	}

	@Override
	public String toString() {
		return "Student [stuId=" + stuId + ", stuName=" + stuName + "]";
	}


	public static int getCount() {
		return count;
	}

	public static void setCount(int count) {
		Student.count = count;
	}

	public int getStuId() {
		return stuId;
	}

	public void setStuId(int stuId) {
		this.stuId = stuId;
	}

	public String getStuName() {
		return stuName;
	}

	public void setStuName(String stuName) {
		this.stuName = stuName;
	}
	
	
	
	
}
