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
 * Note: Classroom serves as a class(�༶) which is not related to course
 */
public interface ClassroomService {
    // Get the list of classrooms
     List<ClassRoom> getClassroom();
     
     // Get certain classroom object by Id
     ClassRoom getClassroomById(String id);
     
     // Get the list of students assigned to certain classroom
     List<Student> getStudentsInClassroom(String id);
          
     // Get the Id of students who are in certain classroom by the classroom Id
//     List<String> getStudentsIdByClassroomId(String id);
//     List<String> getTeachersIdByClassroomId(String id);
     
     int getCurrentStudentNumber();
     
     // Get current number of students assigned to certain classroom by age
     int getStudentNumberByAge(int age);
     
     // Get the max number of students that can be assigned to this classroom by age
     int getMaxStudentNumberInRoomByAge(int age);
     
     // Get the list of teacher assigned to certain classroom
     List<Student> getTeachersInClassroom(String id);
     
     int getCurrentTeacherNumber();

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
     
     // Check if a teacher can be assigned to this classroom
     boolean isTeacherNeeded();
     
     // Check if student group number of certain age reaches the upper limit based on the regulation
     boolean isGroupMaxByAge(int age);
     
     // Check if student of certain age can be assgined to this classroom
     boolean isStudentAvailableByAge(int age);
}
