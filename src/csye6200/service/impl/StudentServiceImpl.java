/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csye6200.service.impl;

import csye6200.entity.ClassRoom;
import csye6200.entity.Course;
import csye6200.entity.Student;
import csye6200.service.StudentService;
import java.util.List;

/**
 *
 * @author Alvin
 */
public class StudentServiceImpl implements StudentService{

    @Override
    public List<Student> getStudnet() {
       return null;
    }

    
    @Override
    public Student getStudentByID(String id) {
        return null;
    }

    @Override
    public List<Course> getCourse() {
        return null;
    }

    @Override
    public List<ClassRoom> getClassroom() {
        return null;
    }

    @Override
    public boolean addStudent(Student student) {
        return true;
    }

    @Override
    public boolean removeStudent(int id) {
       return true;
    }

    @Override
    public boolean addCourse(List<Course> courses) {
       return true;
    }

    @Override
    public boolean removeCourse(List<Integer> list) {
       return true;
    }

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
