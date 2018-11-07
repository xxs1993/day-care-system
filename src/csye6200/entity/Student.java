package csye6200.entity;

public class Student extends Person {
	
    private String fatherName;
    private String motherName;

	public Student(String lName, String fName, String gender, int age, String id, String fatherName, String motherName
			) {
		super(lName, fName, gender, age, id);
		this.fatherName = fatherName;
		this.motherName = motherName;
	}

	public Student() {
	}

        public static int compareById(Student s1, Student s2){
            StringBuilder sb1 = new StringBuilder();
            int i = Integer.parseInt(sb1.append(s1.getId().substring(1)).toString());
            StringBuilder sb2 = new StringBuilder();
            int i2 = Integer.parseInt(sb2.append(s2.getId().substring(1)).toString());
            
            
            
            return i - i2;
        }

        public static int compareByAge(Student s1, Student s2){
            return s1.getAge() - s2.getAge();
        }
        
        public static int compareByGender(Student s1, Student s2){
            return s1.getGender().compareTo(s2.getGender());
        }
        
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

	@Override
	public String toString() {
		return "Student [fatherName=" + fatherName + ", motherName=" + motherName +"]";
	}


}
