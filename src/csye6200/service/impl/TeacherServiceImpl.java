package csye6200.service.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.google.common.base.Strings;

import com.google.common.collect.Lists;
import csye6200.dao.impl.StudentDaoImpl;
import csye6200.dao.impl.TeacherDaoImpl;
import csye6200.entity.Student;
import csye6200.entity.Teacher;
import csye6200.service.TeacherService;

public class TeacherServiceImpl implements TeacherService{


	@Override
	public List<Teacher> getTeacher(){
		// instantiate an TeacherDaoImpl object to call read method in TeacherDao
		TeacherDaoImpl td = new TeacherDaoImpl();
		List<Teacher> teachers = td.readTeacher();
		StudentDaoImpl sdl = new StudentDaoImpl();
		List<Student> students = sdl.readStudents();
		final Map<String,Student> map = students.stream().collect(Collectors.toMap(x->x.getId(),x->x));
		if(map == null || map.isEmpty()){
			return teachers;
		}
		for(Teacher t: teachers){
			List<Student> temp = t.getStudents();
			if(temp == null || temp.isEmpty()){
				continue;
			}
			for(Student s :temp){
				s = map.get(s.getId());
			}
			t.setStudents(temp);
		}
		return teachers;
	    }
	@Override
	public Teacher getTeacherById(String id) {
		if (Strings.isNullOrEmpty(id)) {
			return null;
		}
		// put all Teachers into a Map with structure of <Teacher id, teacher object>
		List<Teacher> list = this.getTeacher().stream().filter((x)->{
			if(id.equals(x.getId())) return true;
			return false;
		}).collect(Collectors.toList());
		if(list == null || list.isEmpty()){
			return null;
		}
		return list.get(0);

	}
	
	
	
	
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
        tdi.writeTeacher(teachers);
		// write into Teacher cvs file
		return teacher;
		
	}
	@Override
	public String addStudent(Student student,String id){
		if(student == null || Strings.isNullOrEmpty(id)){
			return "Invalid params";
		}
		Teacher teacher = this.getTeacherById(id);
		if(teacher == null){
			return String.format("No teacher record found by id:%s",id);
		}
		List<Student> studentList = teacher.getStudents();
		if(studentList == null){
			studentList = Lists.newArrayList();
		}
		for (Student t : studentList) {
			if (t.getId() == student.getId()) {
				return "Student " + student.getlName()+student.getfName() + "with Id " + student.getId()
						+ " has been assigned to Teacher " + id;
			}
		}
		studentList.add(student);
		teacher.setStudents(studentList);
		this.updateTeacher(teacher);
		return "Student" + student.getlName()+student.getfName() + " has been assigned to Teacher " + id;
	}
	
	
	@Override
	public List<Student> getStudent(String id){
		return this.getTeacherById(id).getStudents();
	}
	//List<Student> getStudent(String id);
	
	@Override
	public boolean deleteTeacher(String id) {
		if(Strings.isNullOrEmpty(id)){
			return false;
		}
		boolean result = false;
		List<Teacher> list = this.getTeacher();
		if(list == null || list.isEmpty()){
			return result;
		}
		for(Teacher t : list){
			if(id.equals(t.getId())){
				list.remove(t);
				result = true;
				break;
			}
		}
		if(!result) {
			return result;
		}
		// instantiate an TeacherImpl object to call write method in ClassroomDao
		TeacherDaoImpl tdi = new TeacherDaoImpl();
		return tdi.writeTeacher(list);
	}
	
	@Override
	public String deleteStudent(String studentId, String id) {
		List<Teacher> teachers = this.getTeacher();
		Teacher teacher = this.getTeacherById(id);

		if (teachers == null)
			return "Please enter a correct teacher Id!";
		else {
			List<Student> students = this.getStudent(id);
			if(students == null || students.isEmpty()){
			    return "No students found";
            }
			for(Student t: students) {
				if(t.getId().equals(studentId)) {
					students.remove(t);
					break;
				}
			}
			teacher.setStudents(students);
			this.updateTeacher(teacher);
			return "Student " + studentId + " has been removde from Teacher " + id;
		}
	}

	@Override
	public boolean updateTeacher(Teacher teacher){
		if(teacher == null || Strings.isNullOrEmpty(teacher.getId())){
			return false;
		}
		List<Teacher> list = this.getTeacher();
		if(list == null ||list.isEmpty()){
			return false;
		}
		boolean result = false;
		for(Teacher t : list){
			if(teacher.getId().equals(t.getId())){
				Collections.replaceAll(list,t,teacher);
				result = true;
				break;
			}
		}
		if(!result){
			return false;
		}
		TeacherDaoImpl tdi = new TeacherDaoImpl();
		return tdi.writeTeacher(list);
	}
	
	
}
