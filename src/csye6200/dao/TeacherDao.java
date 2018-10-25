package csye6200.dao;

import java.util.List;

import csye6200.entity.Teacher;

public interface TeacherDao {

	// read from the Teacher.cvs and return a list of Teacher objects
	List<Teacher> readTeacher();
	
	
	// write a list of Teacher objects into classroom.cvs
	boolean writeTeacher(List<Teacher> teachers);
}
