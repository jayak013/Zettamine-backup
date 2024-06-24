package colllections;

import java.util.Objects;

public class Student implements Comparable<Student> {

	private int stuId;
	private String StuName;
	private int groupId;
	private int rank;
	
	
	
	public Student(int stuId, String stuName, int groupId, int rank) {
		this.stuId = stuId;
		StuName = stuName;
		this.groupId = groupId;
		this.rank = rank;
	}



	@Override
	public int compareTo(Student other) {
		return this.stuId - other.stuId;
	}



	@Override
	public String toString() {
		return "Student [stuId=" + stuId + ", StuName=" + StuName + ", groupId=" + groupId + ", rank=" + rank + "]";
	}



	public int getStuId() {
		return stuId;
	}



	public void setStuId(int stuId) {
		this.stuId = stuId;
	}



	public String getStuName() {
		return StuName;
	}



	public void setStuName(String stuName) {
		StuName = stuName;
	}



	public int getGroupId() {
		return groupId;
	}



	public void setGroupId(int groupId) {
		this.groupId = groupId;
	}



	public int getRank() {
		return rank;
	}



	public void setRank(int rank) {
		this.rank = rank;
	}



	@Override
	public int hashCode() {
		return Objects.hash(StuName, groupId, rank, stuId);
	}



	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Student other = (Student) obj;
		return Objects.equals(StuName, other.StuName) && groupId == other.groupId && rank == other.rank
				&& stuId == other.stuId;
	}
	
	
	
	
}
