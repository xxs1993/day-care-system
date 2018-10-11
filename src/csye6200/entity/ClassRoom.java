package csye6200.entity;


public class ClassRoom extends CourseItem{


    private int capacity;//capacity for students

    public ClassRoom(String id,int ageRange, int capacity) {
        super(id,ageRange);
        this.capacity = capacity;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity){
        this.capacity = capacity;
    }

    
    
}
