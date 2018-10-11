package csye6200.entity;

public abstract class Person implements Comparable<Person> {
   private String lName;
   
   private String fName;
   
   private String gender;

   private int age;

   private String id;

	@Override
	public int compareTo(Person person){
		Integer id1 = Integer.parseInt(this.id.substring(1));
		Integer id2 = Integer.parseInt(person.getId().substring(1));
		return id1.compareTo(id2);

	}

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return lName;
    }

    public void setName(String name) {
        this.lName = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
    
    

    public String getlName() {
		return lName;
	}

	public void setlName(String lName) {
		this.lName = lName;
	}

	public String getfName() {
		return fName;
	}

	public void setfName(String fName) {
		this.fName = fName;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	


    @Override
	public String toString() {
		return "Person [lName=" + lName + ", fName=" + fName + ", gender=" + gender + ", age=" + age + ", id=" + id
				+ "]";
	}


	protected Person(String lName, String fName, String gender, int age, String id) {
		this.lName = lName;
		this.fName = fName;
		this.gender = gender;
		this.age = age;
		this.id = id;
	}
	
}
