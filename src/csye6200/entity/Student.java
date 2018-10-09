package csye6200.entity;


import java.util.Map;

public class Student extends Person {


    //Key: course id.value: grade
    private Map<Integer,Double> grade;

    private int courseCount;

    public static final int max_courses_capaticy = 5;

    public Student(String name, int age, int grade, String id) {
        super(name, age,id);
    }


    public int getCourseCount() {
        return courseCount;
    }

    public void setCourseCount(int courseCount) {
        this.courseCount = courseCount;
    }

    public Map<Integer,Double> getGrade() {
        return grade;
    }

    public void setGrade(Map<Integer,Double> grade) {
        this.grade = grade;
    }

    @Override
    public String toString() {
        return "Student{" +
                "grade=" + grade +
                '}';
    }
}
