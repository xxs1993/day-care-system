package csye6200.entity;

import java.util.List;

public class Teacher extends Person {
    private int credits;
    private int ageRange;
    private List<Student> students;

    
    public int getCredits() {
        return credits;
    }

    public void setCredits(int credits) {
        this.credits = credits;
    }
    
    
    
    public int getAgeRange() {
		return ageRange;
    
	}
    
    public int setAgeRange(int ageRange) {
    	return this.ageRange = ageRange;
    }

	
	public void setStudents(List<Student> student) {
		this.students = student;
	}
	
	public List<Student> getStudents() {
		return students;
	}

	@Override
	public String toString() {
		return "Teacher [credits=" + credits + ", grade=" + ageRange + "]";
	}


	public Teacher() {
	}

	public Teacher(String id, String lName, String fName, String gender, int age, int ageRange) {
		super(lName, fName, gender, age, id);
		this.ageRange = ageRange;

	}


}
