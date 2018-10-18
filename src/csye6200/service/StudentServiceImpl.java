package csye6200.service.impl;

import java.util.Collections;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.List;

import com.google.common.base.Splitter;
import com.google.common.base.Strings;
import com.google.common.collect.Lists;

import csye6200.constants.Constants;
import csye6200.entity.Teacher;
import csye6200.exception.DatabaseException;
import csye6200.service.TeacherService;
import csye6200.util.FileUtil;
import csye6200.entity.ClassRoom;
import csye6200.entity.Course;
import csye6200.entity.Student;
import csye6200.service.StudentService;


/**
 *
 * student data: id,age,gender,fName,lName,immDate,fatherName,motherName
 */
public class StudentServiceImpl implements StudentService{

    @Override
    public List<Student> getStudent() {
        List<Student> students = Lists.newArrayList();
        try {
            List<String> studentContent = FileUtil.readContents(Constants.STUDENT_FILE_NAME);
            if(studentContent == null||studentContent.isEmpty()){
                return students;
            }
            students = transferStringToStudent(studentContent);

        }catch (DatabaseException e){
            e.printStackTrace();
        }
       return students;
    }

    
    private List<Student> transferStringToStudent(List<String> studentContent) {
        List<Course> students = Lists.newArrayList();
        for(String s : studentContent){
            List<String> contentString = Splitter.on(Constants.STRING_DIVIDER).trimResults().splitToList(s);
            if(contentString.size() < 8){
                System.out.println("wrong format of data :" + contentString.toArray().toString());
                continue;
            }
            Student student = new Student(contentString.get(0),contentString.get(3),Integer.parseInt(contentString.get(1)));
            students.add(student); //how to handle parameter person class?

        }
        return students;
	}

    public List<String> transferStudentToString(List<Student> students){
        if(students==null||students.isEmpty()){
            System.out.println("Students content is empty");
            return Lists.newArrayList();
        }
        List<String> contents = Lists.newArrayList();
        for(Student student : students){
            StringBuilder sb = new StringBuilder();
            sb.append(student.getId()).append(Constants.STRING_DIVIDER);
            sb.append(student.getAge()).append(Constants.STRING_DIVIDER);
            sb.append(Constants.ARRAY_DIVIDER_LEFT);
            sb.append(Constants.ARRAY_DIVIDER_RIGHT).append(Constants.STRING_DIVIDER);
            sb.append(student.getName());
            contents.add(sb.toString());

        }
        return contents;
    }

	@Override
    public Student getStudentByID(String id) {
        if(Strings.isNullOrEmpty(id)){
            return null;
        }
        Map<String,Student> map = this.getStudent().stream().collect(Collectors.toMap(x->x.getId(),x->x));

        return map.get(id);
    }
/*
    @Override
    public List<Course> getCourse() {
        return null;
    }
*/
	
    @Override
    public List<ClassRoom> getClassroom() {
        return null;
    }

    @Override
    public String addStudent(Student student) {
        if(student==null || Strings.isNullOrEmpty(student.getName())){
            return "";
        }
        List<Student> students = this.getStudent();

        if(students == null) {
            students = Lists.newArrayList();
        }
        String newId = initNewID(students);
        student.setId(newId);
        students.add(student);
        List<String> contents = this.transferStudentToString(students);
        try {
            FileUtil.writeToFile(Constants.COURSE_FILE_NAME, contents);
        }catch (Exception e){
            e.printStackTrace();
            return "";
        }


        return newId;
    }

    @Override
    public String removeStudent(int id) {
       return "not done yet..";
    }
    
    private String initNewID(List<Student> students){
        if(students == null || students.isEmpty()){
            return Constants.PREFFIX_COURSE_ID+"1";
        }
        Collections.sort(students);
        String lastId = students.get(students.size()-1).getId();
        String newId = Constants.PREFFIX_COURSE_ID + String.valueOf(Integer.parseInt(lastId.substring(1))+1);
        return newId;
    }
/*
    @Override
    public boolean addCourse(List<Course> courses) {
       return true;
    }

    @Override
    public boolean removeCourse(List<Integer> list) {
       return true;
    }
*/
    @Override
    public boolean addClassroom(List<ClassRoom> classrooms) {
        return true;
    }

    @Override
    public boolean removeClassroom(List<Integer> list) {
        return true;
    }
    
    
    public String showCourses(Student stu){
        int stuAge = stu.getAge();
        return getCourseInfoByAgeRange(stuAge);
    }
    
    String getCourseInfoByAgeRange(int age){
        return "";
    }
    
}