package csye6200.entity;


public class ClassRoom extends CourseItem{


    private int capacity;//capacity for students

    public ClassRoom(String id,int capacity,int ageRange) {
        super(id,ageRange);
        this.capacity = capacity;
    }

    public ClassRoom() {
	}

	public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity){
        this.capacity = capacity;
    }

	@Override
	public String toString() {
		return "ClassRoom [ID=" + this.getId() + "capacity=" + capacity + "ageRange=" + this.getAgeRange() + "teacherList=" + this.getTeachers() + "]";
	}

    
    
}
