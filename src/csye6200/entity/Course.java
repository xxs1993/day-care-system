package csye6200.entity;


public class Course extends CourseItem{

    private String name;

    private int type;// students age range

    public Course(String id, String name, int type) {
        super(id);
        this.name = name;
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
