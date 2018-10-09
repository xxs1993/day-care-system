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

     List<Student> getTeachersInCourse(String id);

     boolean addCourse(Course course);

     boolean removeCourse(int id);

     boolean addStudents(List<Student> students);

     boolean addTeachers(List<Teacher> teachers);

     boolean removeTeachers(List<Integer> list);

     boolean removeStudents(List<Integer> list);
}
