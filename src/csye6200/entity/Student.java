package csye6200.entity;

public class Student extends Person {
	
    private String fatherName;
    private String motherName;
    private String immDate;

	public Student(String lName, String fName, String gender, int age, String id, String fatherName, String motherName,
			String immDate) {
		super(lName, fName, gender, age, id);
		this.fatherName = fatherName;
		this.motherName = motherName;
		this.immDate = immDate;
	}

	public String getImmDate() {
		return immDate;
	}

	public void setImmDate(String immDate) {
		this.immDate = immDate;
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
		return "Student [fatherName=" + fatherName + ", motherName=" + motherName + ", immDate=" + immDate + "]";
	}


}
