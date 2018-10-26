package csye6200.dao.impl;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.google.common.base.Splitter;
import com.google.common.collect.Lists;

import csye6200.constants.Constants;
import csye6200.dao.TeacherDao;
import csye6200.entity.Student;
import csye6200.entity.Teacher;
import csye6200.exception.DatabaseException;
import csye6200.service.StudentService;
import csye6200.service.impl.StudentServiceImpl;
import csye6200.util.FileUtil;

public class TeacherDaoImpl implements TeacherDao {

	public TeacherDaoImpl() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public List<Teacher> readTeacher() {
		// TODO Auto-generated method stub
		List<Teacher> teacherList = Lists.newArrayList();
        StudentService ss = new StudentServiceImpl();
			try {
				 List<String> teacherContent = FileUtil.readContents(Constants.TEACHER_FILE_NAME);
		            if(teacherContent == null||teacherContent.isEmpty()){
		                return teacherList;
		            }
		            List<Student> student = ss.getStudent();
		            Map<String,Student> map = student.stream().collect(Collectors.toMap(x->x.getId(),x->x));
		            for(String s : teacherContent) {
		            	List<String> teacherString = Splitter.on(",").trimResults().splitToList(s);
		            	
		            	// deal with wrong csv format;
		            	if(teacherString.size() < 8) {
                            System.out.println("wrong format of data :" + Arrays.toString(teacherString.toArray()));
		            		continue;
		            	}
		            	Teacher t = new Teacher(teacherString.get(0),teacherString.get(1),teacherString.get(2),teacherString.get(3),Integer.parseInt(teacherString.get(4)),
		            		Integer.parseInt(teacherString.get(6)));
		            	//get students list string;
		            	String studentsID = teacherString.get(8).replace(Constants.ARRAY_DIVIDER_LEFT,"").replace(Constants.ARRAY_DIVIDER_RIGHT,"").trim();
		            	if(studentsID.isEmpty()){
		            		continue;
		            	}
		            	// get students id;
		            	List<String> idList = Splitter.on(",").trimResults().splitToList(studentsID);
		            	
		            	//get students objects by id;
		            	List<Student> studentsWithTC = Lists.newArrayList();
		            	for(String id : idList) {
			            	Student st;
			            	if((st = map.get(id))!=null){
		                        studentsWithTC.add(st);
			            	}
		            	}
		            	t.setStudents(studentsWithTC);
		            	teacherList.add(t);
		            }
			}catch (DatabaseException e){
	            e.printStackTrace();
	        }
	       return teacherList;
	    }
	

	@Override
	public boolean writeTeacher(List<Teacher> teachers) {
		// TODO Auto-generated method stub
		List<String> contents = this.transferTeacherToString(teachers);
		try {
			FileUtil.writeToFile(Constants.CLASSROOM_FILE_NAME, contents);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
	
	// Transfer List<Teacher> to List<String>
	 public List<String> transferTeacherToString(List<Teacher> teachers){
	        if(teachers==null||teachers.isEmpty()){
	            System.out.println("Teachers content is empty");
	            return Lists.newArrayList();
	        }
	        List<String> contents = Lists.newArrayList();
	        for(Teacher t : teachers){
	            StringBuilder sb = new StringBuilder();
	            sb.append(t.getId()).append(Constants.STRING_DIVIDER);
	            sb.append(t.getAgeRange()).append(Constants.STRING_DIVIDER);
	            sb.append(Constants.ARRAY_DIVIDER_LEFT);
	            List<Student> students = t.getStudents();
	            if(students!=null && !students.isEmpty()){
	                for(Student student:students){
	                    sb.append(student.getId()).append(Constants.STRING_DIVIDER);
	                }
	                sb.deleteCharAt(sb.length()-1);
	            }
	            sb.append(Constants.ARRAY_DIVIDER_RIGHT).append(Constants.STRING_DIVIDER);
	            sb.append(t.getName());
	            contents.add(sb.toString());

	        }
	        return contents;
	    }
	// Initialize an Id for a new Teacher 
	 public String initNewID(List<Teacher> teachers){
	        if(teachers == null || teachers.isEmpty()){
	            return Constants.PREFFIX_COURSE_ID+"1";
	        }
	        Collections.sort(teachers);
	        String lastId = teachers.get(teachers.size()-1).getId();
	        String newId = Constants.PREFFIX_COURSE_ID + String.valueOf(Integer.parseInt(lastId.substring(1))+1);
	        return newId;
	    }

}
