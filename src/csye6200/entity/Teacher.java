package csye6200.entity;

import java.util.List;

public class Teacher extends Person {
    private int credits;
    private String ageRange;
    private List<Student> students;

    
    public int getCredits() {
        return credits;
    }

    public void setCredits(int credits) {
        this.credits = credits;
    }
    
    
    
    public int getGrade() {
		//return ageRange;
	}

	public void setGrade(int grade) {
		//this.ageRange = grade;
	}

	@Override
	public String toString() {
		return "Teacher [credits=" + credits + ", grade=" + ageRange + "]";
	}



	public Teacher(String lName, String fName, String gender, int age, String id,String ageRange) {
		super(lName, fName, gender, age, id);
		this.ageRange = ageRange;

	}


}
