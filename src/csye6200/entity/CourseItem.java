package csye6200.entity;

import com.google.common.collect.Lists;

import java.util.List;

public abstract class CourseItem implements Comparable<CourseItem> {

    private String id;

    private int ageRange;

    private List<Teacher> teachers;
    
    public CourseItem() {
    }


    protected CourseItem(String id,int ageRange) {
        this.id = id;
        this.ageRange = ageRange;
    }

    @Override
    public int compareTo(CourseItem item){
        Integer id1 = Integer.parseInt(this.id.substring(1));
        Integer id2 = Integer.parseInt(item.getId().substring(1));
        return id1.compareTo(id2);

    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getAgeRange() {
        return ageRange;
    }

    public void setAgeRange(int ageRange) {
        this.ageRange = ageRange;
    }

    public List<Teacher> getTeachers() {
        return teachers;
    }

    public void setTeachers(List<Teacher> teachers) {
        this.teachers = teachers;
    }

//    public List<Student> getStudents() {
//        return students;
//    }
//    //
//
//    public void setStudents(List<Student> students) {
//        this.students = students;
//    }

    public boolean isTeacherEmpty(){
        return teachers==null || teachers.isEmpty();
    }

    public boolean isTeachersFull(){
        //TODO:
        return true;
    }

//    public boolean isStudentsFull(){
//        //TODO:
//        return true;
//    }

    public void addTeacher(Teacher teacher){
        if(teachers==null){
            teachers = Lists.newArrayList();
        }
        teachers.add(teacher);

    }

//    public void addStudent(Student student){
//        //TODO:add a student to that item
//
//    }
}
