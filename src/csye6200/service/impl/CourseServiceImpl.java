package csye6200.service.impl;

import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;
import csye6200.constants.FileNameConstants;
import csye6200.entity.Course;
import csye6200.entity.Student;
import csye6200.entity.Teacher;
import csye6200.service.CourseService;

import java.util.List;

public class CourseServiceImpl implements CourseService {




    public List<Course> getCourses(){
       return null;
    }



    public Course getCourseById(String id){
        return null;
    }

    public List<String> getStudentsIdByCourseId(String id){
        return null;
    }

    public List<Student> getStudentsInCourse(String id){
        return null;
    }

    public List<String> getTeachersIdByCourseId(String id){
        return null;
    }

    public List<Student> getTeachersInCourse(String id){
        return null;
    }


    public boolean addCourse(Course course){
        //TODO
        return true;
    }

    public boolean removeCourse(int id){
        //TODO
        return true;
    }

    public boolean addStudents(List<Student> students){
        //TODO
        return true;
    }

    public boolean addTeachers(List<Teacher> teachers){
        //TODO
        return true;
    }

    public boolean removeTeachers(List<Integer> list){
        //TODO
        return true;
    }

    public boolean removeStudents(List<Integer> list){
        //TODO
        return true;
    }
}
