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
