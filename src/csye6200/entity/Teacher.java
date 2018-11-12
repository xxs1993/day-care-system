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
        public static int compareById(Teacher t1, Teacher t2){
            StringBuilder sb1 = new StringBuilder();
            int i1 = Integer.parseInt(sb1.append(t1.getId().substring(1)).toString());
            StringBuilder sb2 = new StringBuilder();
            int i2 = Integer.parseInt(sb2.append(t2.getId().substring(1)).toString());
            
            
            
            return i1 - i2;
        }

        public static int compareByLastName(Teacher t1, Teacher t2){
            return t1.getlName().compareTo(t2.getlName());
        }
        
        public static int compareByAgeRange(Teacher t1, Teacher t2){
            return t1.getAgeRange()-t2.getAgeRange();
        }


}
