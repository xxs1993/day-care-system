package csye6200.dao;

import java.util.List;

import csye6200.entity.ClassRoom;

public interface ClassroomDao {
	
	// read from the classroom.cvs and return a list of classroom objects
	List<ClassRoom> readClassrooms();
	
	// write a list of classroom objects into classroom.cvs
	boolean writeClassroom(List<ClassRoom> classrooms);
	
}

