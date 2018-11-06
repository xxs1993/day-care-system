package csye6200.service;

import java.util.List;

import csye6200.entity.Student;
import csye6200.entity.Teacher;

public interface TeacherService {
	 // Get the list of Teacher;
	List<Teacher> getTeacher();
    // Get certain Teacher object by Id
	Teacher getTeacherById(String id);
	// Add a new teacher to the system;
    Teacher addTeacher(Teacher teacher);
   // delete a teacher from system;
    boolean deleteTeacher(String id);
    
    // add a student to teacher;
    String addStudent(Student student,String id);

    String addStudent(Student student,Teacher teacher);
    //delete a student from teacher;
    String deleteStudent(String studentId, String id);
    //get the student list;
    List<Student> getStudentByTeacherId(String id);

    boolean updateTeacher(Teacher teacher);

    List<Teacher> getTeachersByAgeRange(int ageRange);

    List<Teacher> getTeachersByFirstName(String fName);




    }
