package csye6200.service;

import java.util.List;

import csye6200.entity.ClassRoom;
import csye6200.entity.Course;
import csye6200.entity.Teacher;

public interface TeacherService {
	 	List<Teacher> getTeacher();
	    Teacher getTeacherByID(String id);
	    List<Course> getCourse();
	    List<ClassRoom>getClassroom();
	    List<Integer> getCredits();
	    List<String> getId();
	    
	    boolean addTeacher(Teacher teacher);
	    boolean removeTeacher(String id);
	    boolean addCourse(List<Course> courses);
	    boolean removeCourse(List<Integer> list);
	    boolean addClassroom(List<ClassRoom>classrooms);
	    boolean removeClassroom(List<Integer>list);
}
