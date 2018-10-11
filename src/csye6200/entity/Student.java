package csye6200.entity;


import java.util.Map;

public class Student extends Person {


    //Key: course id.value: grade
    private Map<Integer,Double> grade;
    
    private int courseCount;

    public static final int max_courses_capaticy = 5;
    
    private boolean reguStatus;
    
    private String immDate;
    
    private double gpa;



	public Student(String lName, String fName, String gender, int age, String id, Map<Integer, Double> grade,
			int courseCount, boolean reguStatus, String immDate, double gpa) {
		super(lName, fName, gender, age, id);
		this.grade = grade;
		this.courseCount = courseCount;
		this.reguStatus = reguStatus;
		this.immDate = immDate;
		this.gpa = gpa;
	}

	public int getCourseCount() {
        return courseCount;
    }

    public void setCourseCount(int courseCount) {
        this.courseCount = courseCount;
    }

    public Map<Integer,Double> getGrade() {
        return grade;
    }

    public void setGrade(Map<Integer,Double> grade) {
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

    
}
