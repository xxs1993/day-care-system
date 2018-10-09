package csye6200.entity;

import java.util.List;

public abstract class CourseItem  {

    private String id;


    private List<Teacher> teachers;

    private List<Student> students;

    protected CourseItem(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }




    public List<Teacher> getTeachers() {
        return teachers;
    }

    public void setTeachers(List<Teacher> teachers) {
        this.teachers = teachers;
    }

    public List<Student> getStudents() {
        return students;
    }
    //

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    public boolean isEmpty(){
        //TODO: Is any teacher in that courseItem
        return true;
    }

    public boolean isTeachersFull(){
        //TODO:
        return true;
    }

    public boolean isStudentsFull(){
        //TODO:
        return true;
    }

    public void addTeacher(Teacher teacher){
        //TODO:add a teacher to that item
    }

    public void addStudent(Student student){
        //TODO:add a student to that item

    }
}
