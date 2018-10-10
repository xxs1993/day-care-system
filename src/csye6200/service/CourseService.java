package csye6200.service;

import csye6200.entity.Course;
import csye6200.entity.Student;
import csye6200.entity.Teacher;

import java.util.List;
import java.util.Vector;

public interface CourseService {

     List<Course> getCourses();

     Course getCourseById(String id);

     List<String> getStudentsIdByCourseId(String id);

     List<Student> getStudentsInCourse(String id);

     List<String> getTeachersIdByCourseId(String id);

     List<Teacher> getTeachersInCourse(String id);

     String addCourse(Course course);

     boolean removeCourse(int id);

     boolean addStudents(List<Student> students,String id);

     boolean addTeachers(List<Teacher> teachers,String id);

     boolean removeTeachers(List<Integer> list,String id);

     boolean removeStudents(List<Integer> list,String id);
}
