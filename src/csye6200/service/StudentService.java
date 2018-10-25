/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csye6200.service;
import csye6200.entity.Student;
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
    
    //add new students to the system
    String addStudent(Student student);
    //remove students from the system
    String removeStudent(int id);

}
