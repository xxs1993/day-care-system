/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csye6200.service;
import csye6200.entity.Student;
import csye6200.entity.ClassRoom;
import csye6200.entity.Course;
import java.util.List;
/**
 *
 * @author Alvin
 */
public interface StudentService {
    //Get the list of students
    List<Student> getStudent();
    //Get certain student object by id
    Student getStudentByID(String id);
    //get the course student registered
    List<Course> getCourse();
    //get classroom for course
    List<ClassRoom>getClassroom();
    
    //add new students to the system
    String addStudent(Student student);
    //remove students from the system
    String removeStudent(int id);

    
    /*
    boolean addCourse(List<Course> courses);
    //student drop courses
    boolean removeCourse(List<Integer> list);
    */
    

    boolean addClassroom(List<ClassRoom> classrooms);
    //not sure lol
    boolean removeClassroom(List<Integer> list);
	//List<Student> getStudent();

}
