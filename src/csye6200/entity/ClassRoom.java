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

    public static int compareById(ClassRoom c1, ClassRoom c2){
            StringBuilder sb1 = new StringBuilder();
            int i1 = Integer.parseInt(sb1.append(c1.getId().substring(1)).toString());
            StringBuilder sb2 = new StringBuilder();
            int i2 = Integer.parseInt(sb2.append(c2.getId().substring(1)).toString());
            return i1 - i2;
        }

        public static int compareByCapacity(ClassRoom c1, ClassRoom c2){
            return Integer.compare(c1.getCapacity(),c2.getCapacity());
        }
        
        public static int compareByAgeRange(ClassRoom c1, ClassRoom c2){
            return c1.getAgeRange()-c2.getAgeRange();
        }
    
}
