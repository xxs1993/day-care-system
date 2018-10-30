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

    /**
     * Get the list of students
     * @return
     */
    List<Student> getStudent();

    /**
     *  Get certain student object by id
     * @param id
     * @return
     */
    Student getStudentByID(String id);


    /**
     *  add new students to the system
     * @param student
     * @return
     */
    String addStudent(Student student);

    /**
     *  remove students from the system
     * @param id
     * @return
     */
    String removeStudent(int id);

    String showCourses(Student stu);

    String getCourseInfoByAgeRange(int age);

}
