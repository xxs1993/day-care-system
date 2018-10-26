package csye6200.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.google.common.base.Strings;

import csye6200.dao.impl.TeacherDaoImpl;
import csye6200.entity.Student;
import csye6200.entity.Teacher;
import csye6200.service.TeacherService;

public class TeacherServiceImpl implements TeacherService{
	@Override
	public List<Teacher> getTeacher(){
		// instantiate an TeacherDaoImpl object to call read method in TeacherDao
		TeacherDaoImpl td = new TeacherDaoImpl();
		return td.readTeacher();
	    }
	@Override
	public Teacher getTeacherById(String id) {
		if (Strings.isNullOrEmpty(id)) {
			return null;
		}
		// put all Teachers into a Map with structure of <Teacher id, teacher object>
		Map<String, Teacher> map = getTeacher().stream().collect(Collectors.toMap(x -> x.getId(), x -> x));
		return map.get(id);

	};
	
	
	
	
	@Override
	public Teacher addTeacher(Teacher teacher) {
		/*if(teacher == null || Strings.isNullOrEmpty(teacher.getfName())) {
			return "";
		}
		List<Teacher> teachers = this.getTeacher();
		
		if(teachers == null) {
			teachers = Lists.newArrayList();
		}
		
		String teacherID = initNewID(teachers);
		teacher.setId(teacherID);
		teachers.add(teacher);
		List<String> contents = this.transferTeacherToString(teachers);
		try {
			FileUtil.writeToFile(Constants.TEACHER_FILE_NAME, contents);
		}catch (Exception e) {
			e.printStackTrace();
			return "";
		}
		return teacherID;*/
		if (teacher == null) {
			return teacher;
		}
		
		TeacherDaoImpl tdi = new TeacherDaoImpl();
		// read from teacher cvs file
		List<Teacher> teachers = tdi.readTeacher();
		if (teachers == null) {
			teachers = new ArrayList<Teacher>();
		}
		// Initiate an Id for the new teacher
		String newId = tdi.initNewID(teachers);
		teacher.setId(newId);
		teachers.add(teacher);
		// write into Teacher cvs file
		return teacher;
		
	}
	@Override
	public String addStudent(Student student,String id){
		List<Student> studentList = this.getTeacherById(id).getStudents();
		for (Student t : studentList) {
			if (t.getId() == student.getId()) {
				return "Student " + student.getName() + "with Id " + student.getId()
						+ " has been assigned to Teacher " + id;
			}
		}
		studentList.add(student);
		this.getTeacherById(id).setStudents(studentList);
		return "Student" + student.getName() + " has been assigned to Teacher " + id;
	}
	
	
	@Override
	public List<Student> getStudent(String id){
		return this.getTeacherById(id).getStudents();
	}
	//List<Student> getStudent(String id);
	
	@Override
	public boolean deleteTeacher(String id) {
		List<Teacher> list = this.getTeacher();
		list.remove(this.getTeacherById(id));
		// instantiate an TeacherImpl object to call write method in ClassroomDao
		TeacherDaoImpl tdi = new TeacherDaoImpl();
		return tdi.writeTeacher(list);
	}
	
	@Override
	public String deleteStudent(String studentId, String id) {
		List<Teacher> teachers = this.getTeacher();
		Teacher teacher = this.getTeacherById(id);
		TeacherDaoImpl tdi = new TeacherDaoImpl();
		
		if (teachers == null)
			return "Please enter a correct teacher Id!";
		else {
			List<Student> students = this.getStudent(id);
			for(Student t: students) {
				if(t.getId() == studentId) {
					students.remove(t);
					break;
				}
			}
			teacher.setStudents(students);
			for (int i = 0; i < teachers.size(); i++) {
				if (teachers.get(i).getId() == teacher.getId())
					teachers.set(i, teacher);
			}
			tdi.writeTeacher(teachers);
			return "Student " + studentId + " has been removde from Teacher " + id;
		}
	}
	
	
}
