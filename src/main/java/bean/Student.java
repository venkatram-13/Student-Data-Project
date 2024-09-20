package bean;

public class Student {
	private String registeredNo ;
	private String studentName ;
	private String DOB ;
	private String branch ;
	private String gender ;
	private int year ;
	private String semester ;
	private String collegeName ;
	public String getRegisteredNo() {
		return registeredNo;
	}
	public void setRegisteredNo(String registeredNo) {
		this.registeredNo = registeredNo;
	}
	public String getStudentName() {
		return studentName;
	}
	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}
	public String getDOB() {
		return DOB;
	}
	public void setDOB(String dOB) {
		DOB = dOB;
	}
	public String getBranch() {
		return branch;
	}
	public void setBranch(String branch) {
		this.branch = branch;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	public String getSemester() {
		return semester;
	}
	public void setSemester(String semester) {
		this.semester = semester;
	}
	public String getCollegeName() {
		return collegeName;
	}
	public void setCollegeName(String collegeName) {
		this.collegeName = collegeName;
	}
	@Override
	public String toString() {
		return "Student [registeredNo=" + registeredNo + ", studentName=" + studentName + ", DOB=" + DOB + ", branch="
				+ branch + ", gender=" + gender + ", year=" + year + ", semester=" + semester + ", collegeName="
				+ collegeName + "]";
	}
	
	public Student() {
	    super();
	}

	
	public Student(String registeredNo, String studentName, String DOB, String gender, String branch, int year, String semester, String collegeName) {
	    this.registeredNo = registeredNo;
	    this.studentName = studentName;
	    this.DOB = DOB;
	    this.gender = gender;
	    this.branch = branch;
	    this.year = year;
	    this.semester = semester;
	    this.collegeName = collegeName;
	}
}
