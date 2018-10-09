package csye6200.entity;


public class ClassRoom extends CourseItem{


    private int capacity;//capacity for students

    public ClassRoom(String id, int capacity) {
        super(id);
        this.capacity = capacity;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCredits(int credits){
        //TODO: add credits for teachers
    }

    
    
}
