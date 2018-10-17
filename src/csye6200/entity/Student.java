package csye6200.entity;


import java.util.Map;

public class Student extends Person {


    //Key: course id.value: grade
    //private Map<String, Double> grade;
    
    //private int courseCount;

    //private boolean reguStatus;
    
    private String immDate;

	public Student(String lName, String fName, String gender, int age, String id, String immDate) {
		super(lName, fName, gender, age, id);
		this.immDate = immDate;
	}

	public String getImmDate() {
		return immDate;
	}

	public void setImmDate(String immDate) {
		this.immDate = immDate;
	}
    
    private String fatherName;
    
    private String motherName;

	public String getFatherName() {
		return fatherName;
	}

	public void setFatherName(String fatherName) {
		this.fatherName = fatherName;
	}

	public String getMotherName() {
		return motherName;
	}

	public void setMotherName(String motherName) {
		this.motherName = motherName;
	}
    
    
    
    //private double gpa;

/*
	public Student(String lName, String fName, String gender, int age, String id) {
		super(lName, fName, gender, age, id);
	}

	public int getCourseCount() {
        return courseCount;
    }

    public void setCourseCount(int courseCount) {
        this.courseCount = courseCount;
    }

    public Map<String, Double> getGrade() {
        return grade;
    }

    public void setGrade(Map<String, Double> grade) {
        this.grade = grade;
    }
    
    

	public boolean isReguStatus() {
		return reguStatus;
	}

	public void setReguStatus(boolean reguStatus) {
		this.reguStatus = reguStatus;
	}

	public String getImmDate() {
		return immDate;
	}

	public void setImmDate(String immDate) {
		this.immDate = immDate;
	}

	public double getGpa() {
		return gpa;
	}

	public void setGpa(double gpa) {
		this.gpa = gpa;
	}

	@Override
	public String toString() {
		return "Student [grade=" + grade + ", courseCount=" + courseCount + ", reguStatus=" + reguStatus + ", immDate="
				+ immDate + "]";
	}

*/    
}
