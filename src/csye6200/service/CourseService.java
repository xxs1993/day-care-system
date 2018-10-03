package csye6200.service;

import csye6200.entity.Course;
import csye6200.entity.Student;
import csye6200.entity.Teacher;

import java.util.Vector;

public interface CourseService {

     boolean addCourse(Course course);

     boolean removeCourse(int id);

     boolean addStudents(Vector<Student> students);

     boolean addTeachers(Vector<Teacher> teachers);

     boolean removeTeachers(Vector<Integer> list);

     boolean removeStudents(Vector<Integer> list);
}
