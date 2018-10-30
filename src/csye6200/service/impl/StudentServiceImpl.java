package csye6200.service.impl;

import java.util.Collections;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.List;

import com.google.common.base.Strings;
import com.google.common.collect.Lists;

import csye6200.constants.Constants;
import csye6200.dao.StudentDao;
import csye6200.dao.impl.StudentDaoImpl;
import csye6200.entity.Student;
import csye6200.service.StudentService;



public class StudentServiceImpl implements StudentService{

    @Override
    public List<Student> getStudent() {
		StudentDaoImpl sd = new StudentDaoImpl();
		return sd.readStudents();
    }



	@Override
    public Student getStudentByID(String id) {
        if(Strings.isNullOrEmpty(id)){
            return null;
        }
        Map<String,Student> map = this.getStudent().stream().collect(Collectors.toMap(x->x.getId(),x->x));

        return map.get(id);
    }

    @Override
    public String addStudent(Student student) {
        if(student==null || Strings.isNullOrEmpty(student.getfName())){
            return "";
        }
        List<Student> students = this.getStudent();

        if(students == null) {
            students = Lists.newArrayList();
        }
        StudentDao studentDao = new StudentDaoImpl();
        String newId = initNewID(students);
        student.setId(newId);
        students.add(student);
        studentDao.writeStudent(students);
        return newId;
    }

    @Deprecated
    @Override
    public String removeStudent(int id) {
       //
        return "not done yet.";
    }
    
    private String initNewID(List<Student> students){
        if(students == null || students.isEmpty()){
            return Constants.PREFFIX_STUDENT_ID+"1";
        }
        Collections.sort(students);
        String lastId = students.get(students.size()-1).getId();
        String newId = Constants.PREFFIX_STUDENT_ID + String.valueOf(Integer.parseInt(lastId.substring(1))+1);
        return newId;
    }


    @Override
    public String showCourses(Student stu){
        int stuAge = stu.getAge();
        return getCourseInfoByAgeRange(stuAge);
    }

    @Override
    public String getCourseInfoByAgeRange(int age){
        return "";
    }
    
}
