/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csye6200.service;

import csye6200.entity.ClassRoom;
import csye6200.entity.Course;
import csye6200.entity.Student;
import csye6200.entity.Teacher;
import java.util.List;

/**
 *
 * @author karen
 * Note: Classroom serves as a class(班级) which is not related to course
 */
public interface ClassroomService {
    // Get the list of classrooms
     List<ClassRoom> getClassroom();
     
     // Get certain classroom object by Id
     ClassRoom getClassroomById(String id);
     
     // Get the list of student objects with certain classroom Id
     List<Student> getStudentsInClassroom(String id);
          
     // Get the Id of students who are in certain classroom by the classroom Id
//     List<String> getStudentsIdByClassroomId(String id);
//     List<String> getTeachersIdByClassroomId(String id);
     
     // Get current number of teachers assigned to certain classroom
     int getTeacherNumber();
     
     // Get current number of students assigned to certain classroom by age
     int getStudentNumberByAge(int age);
     
     // Get current available student number by age for certain classroom
     int getStudentAvailableNumberByAge(int age);
     
     // Get the max number of students that can be assigned to this classroom by age
     int getMaxStudentNumberInRoomByAge(int age);
     
     // Get the list of teacher objects with certain classroom Id
     List<Student> getTeachersInClassroom(String id);
     
     // Get the list of course objects with certain classroom Id
     List<Course> getCoursesInClassroom(String id);
     
     // Add a new classroom to the sytem
     boolean addClassroom(ClassRoom classroom);
     
     // Remove a classroom from the sytem
     boolean removeClassroom(int id);
     
     // Add a list of students to a classroom
     boolean assignStudents(List<Student> students);
     
     // Add a list of teachers to a classroom
     boolean assignTeachers(List<Teacher> teachers);
     
     // Remove a list of students from a classroom
     boolean removeStudents(List<Integer> list);
     
     // Remove a list of teachers from a classroom
     boolean removeTeachers(List<Integer> list);
     
     // Check whether a teacher can be assigned to this classroom or not
     boolean isTeacherNeeded();
}
