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
 * Note: Classroom serves as a class which is not related to course
 */
public interface ClassroomService {
    // Get the list of classrooms
     List<ClassRoom> getClassrooms();
     
     // Get certain classroom object by Id
     ClassRoom getClassroomById(String id);
     
     List<ClassRoom> getClassroomsByCapacity(int cap);
     // Get the list of students assigned to certain classroom
     List<Student> getStudentsInClassroom(String id);
     
     int getCurrentStudentNumber(String id);
     
     // Get the list of teacher assigned to certain classroom
     List<Teacher> getTeachersInClassroom(String id);
     
     int getCurrentTeacherNumber();

     // Add a new classroom to the sytem
     String addClassroom(ClassRoom classroom);
     
     // Remove a classroom from the sytem
     String removeClassroom(String id);
     
     boolean updateClassroom(ClassRoom classroom);

     String addTeacher(Teacher teacher,String id);

     String removeTeacher(String teacherId, String id);

     boolean IsFull(String id);
     
     boolean isTeacherInAClassroom(String tid);

     ClassRoom getClassRoomByTeacherId(String teacherId);
}
