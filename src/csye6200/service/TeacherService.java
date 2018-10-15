package csye6200.service;

import java.util.List;

import csye6200.entity.ClassRoom;
import csye6200.entity.Course;
import csye6200.entity.Student;
import csye6200.entity.Teacher;

public interface TeacherService {
	List<Teacher> getTeacher();
    String addTeacher(Teacher teacher);
    List<Student> addStudent(String id);
    List<Student> getStudent(String id);
    boolean deleteTeacher();
    boolean deleteStudent(List<String> idList);
}
