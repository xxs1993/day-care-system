/*
  * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csye6200.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.google.common.base.Strings;

import csye6200.entity.Student;
import csye6200.entity.Teacher;
import csye6200.service.ClassroomService;
import dao.impl.ClassroomDaoImpl;
import csye6200.entity.ClassRoom;

/**
 *
 * @author karen classroom data: id,ageRange,capacity,[teacherId1;teacherId2]
 */
public class ClassroomServiceImpl implements ClassroomService {
	@Override
	public List<ClassRoom> getClassrooms() {
		// instantiate an ClassroomDaoImpl object to call read method in ClassroomDao
		ClassroomDaoImpl cdi = new ClassroomDaoImpl();
		return cdi.readClassrooms();
	}

	public ClassRoom getClassroomById(String id) {
		if (Strings.isNullOrEmpty(id)) {
			return null;
		}
		// put all classrooms into a Map with structure of <classroom id, classroom object>
		Map<String, ClassRoom> map = getClassrooms().stream().collect(Collectors.toMap(x -> x.getId(), x -> x));
		return map.get(id);

	};

	public String addTeacher(Teacher teacher, String id) {
		// TODO: use the APIs in TeacherDao
		List<Teacher> teacherList = this.getClassroomById(id).getTeachers();
		for (Teacher t : teacherList) {
			if (t.getId() == teacher.getId()) {
				return "Teacher " + teacher.getName() + "with Id " + teacher.getId()
						+ " has been assigned to classroom " + id;
			}
		}
		teacherList.add(teacher);
		this.getClassroomById(id).setTeachers(teacherList);
		return "Teacher " + teacher.getName() + " has been assigned to classroom " + id;
	}

	public List<Student> getStudentsInClassroom(String id) {
		// TODO: use the APIs in TeacherDao
		// Question: can I call getStudents() here????
		ClassRoom classroom = getClassroomById(id);
		List<Student> students = new ArrayList<>();
		List<Teacher> teacherList = classroom.getTeachers();
		for (Teacher t : teacherList) {
			for (Student s: t.getStudents()) {
				students.add(s);
			}
		}
		return students;
	}

	public int getCurrentStudentNumber(String id) {
		return this.getStudentsInClassroom(id).size();
	}

	/*
	 * @Ziyan Zhu start
	 * 
	 */
	// remove teacher by id, return teacher's name
	public String removeTeacher(String teacherId, String id) {
		// TODO: use the APIs in TeacherDao
		List<ClassRoom> classrooms = this.getClassrooms();
		ClassRoom classroom = this.getClassroomById(id);
		ClassroomDaoImpl cdi = new ClassroomDaoImpl();
		
		if (classroom == null)
			return "Please enter a correct classroom Id!";
		else {
			List<Teacher> teachers = this.getTeachersInClassroom(id);
			for(Teacher t: teachers) {
				if(t.getId() == teacherId) {
					teachers.remove(t);
					break;
				}
			}
			classroom.setTeachers(teachers);
			for (int i = 0; i < classrooms.size(); i++) {
				if (classrooms.get(i).getId() == classroom.getId())
					classrooms.set(i, classroom);
			}
			cdi.writeClassroom(classrooms);
			return "Teacher " + teacherId + " has been removde from classroom " + id;
		}
		
	}

	public List<Teacher> getTeachersInClassroom(String id) {
		return this.getClassroomById(id).getTeachers();
	}

	@Override
	public int getCurrentTeacherNumber() {
		int count = 0;
		List<ClassRoom> list = this.getClassrooms();
		for (ClassRoom classroom : list) {
			count += classroom.getTeachers().size();
		}
		return count;
	}

	@Override
	public boolean addClassroom(ClassRoom classroom) {
		if (classroom == null || Strings.isNullOrEmpty(classroom.getId())) {
			return false;
		}
		
		ClassroomDaoImpl cdi = new ClassroomDaoImpl();
		// read from classroom cvs file
		List<ClassRoom> classrooms = cdi.readClassrooms();
		if (classrooms == null) {
			classrooms = new ArrayList<ClassRoom>();
		}
		// Initiate an Id for the new classroom
		String newId = cdi.initNewID(classrooms);
		classroom.setId(newId);
		classrooms.add(classroom);
		// write into classroom cvs file
		return cdi.writeClassroom(classrooms);

	}

	@Override
	public boolean removeClassroom(String id) {
		List<ClassRoom> list = this.getClassrooms();
		list.remove(this.getClassroomById(id));
		// instantiate an ClassroomDaoImpl object to call write method in ClassroomDao
		ClassroomDaoImpl cdi = new ClassroomDaoImpl();
		return cdi.writeClassroom(list);
	}

	@Override
	public boolean IsFull(String id) {
		// TODO: use the APIs in TeacherDao
		
/*		int cnt = 0;
		List<Teacher> teachers = this.getClassroomById(id).getTeachers();
		cnt += teachers.size();
		for (Teacher teacher : teachers) {
			cnt += new TeacherServiceImpl().getStudentByTeacherId(teacher.getId()).size();
		}
		return (cnt == this.getClassroomById(id).getCapacity());*/
		 
		return false;
	};


}
