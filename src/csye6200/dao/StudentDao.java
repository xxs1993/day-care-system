package csye6200.dao;

import java.util.List;

import csye6200.entity.Student;

public interface StudentDao {
	
	// read from the students.cvs and return a list of student objects
	List<Student> readStudents();
	
	// write a list of students objects into student.cvs
	boolean writeStudent(List<Student> students);



}