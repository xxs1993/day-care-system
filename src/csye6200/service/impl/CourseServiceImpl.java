package csye6200.service.impl;

import com.google.common.base.Splitter;
import com.google.common.base.Strings;
import com.google.common.collect.Lists;
import csye6200.constants.Constants;
import csye6200.entity.Course;
import csye6200.entity.Student;
import csye6200.entity.Teacher;
import csye6200.exception.DatabaseException;
import csye6200.service.CourseService;
import csye6200.util.FileUtil;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class CourseServiceImpl implements CourseService {




    public List<Course> getCourses(){
        List<Course> courses = Lists.newArrayList();
        try {
            List<String> courseContent = FileUtil.readContents(Constants.COURSE_FILE_NAME);
            if(courseContent.isEmpty()){
                return courses;
            }
            List<String> teacherContent = FileUtil.readContents(Constants.TEACHER_FILE_NAME);
            List<String> studentContent = FileUtil.readContents(Constants.STUDENT_FILE_NAME);
            //TODO:
            for(String s : courseContent){
                List<String> conentString = Splitter.on(",").trimResults().splitToList(s);
                //TODO:

//                Course
            }
        }catch (DatabaseException e){

        }
       return courses;
    }



    public Course getCourseById(String id){
        if(Strings.isNullOrEmpty(id)){
            return null;
        }
        Map<String,Course> map = this.getCourses().stream().collect(Collectors.toMap(x->x.getId(),x->x));

        return map.get(id);
    }

    public List<String> getStudentsIdByCourseId(String id){
        if(Strings.isNullOrEmpty(id)){
            return null;
        }
        Course course = this.getCourseById(id);
        if(course == null || course.getStudents() == null){
            return null;
        }
        List<String> ids = Lists.transform(course.getStudents(),(x)->x.getId());
        return Lists.newArrayList(ids);
    }

    public List<Student> getStudentsInCourse(String id){
        if(Strings.isNullOrEmpty(id)){
            return null;
        }
        Course course = this.getCourseById(id);

        return course.getStudents();
    }

    public List<String> getTeachersIdByCourseId(String id){
        if(Strings.isNullOrEmpty(id)){
            return null;
        }
        Course course = this.getCourseById(id);
        if(course == null || course.getTeachers() == null){
            return null;
        }
        List<String> ids = Lists.transform(course.getTeachers(),(x)->x.getId());
        return Lists.newArrayList(ids);
    }

    public List<Teacher> getTeachersInCourse(String id){
        if(Strings.isNullOrEmpty(id)){
            return null;
        }
        Course course = this.getCourseById(id);
        return course.getTeachers();
    }


    public String addCourse(Course course){
        //TODO
        if(course==null || Strings.isNullOrEmpty(course.getName())){
            return "";
        }

        return "55";
    }

    public boolean removeCourse(int id){
        //TODO
        return true;
    }

    public boolean addStudents(List<Student> students,String id){
        //TODO
        return true;
    }

    public boolean addTeachers(List<Teacher> teachers,String id){
        //TODO
        return true;
    }

    public boolean removeTeachers(List<Integer> list,String id){
        //TODO
        return true;
    }

    public boolean removeStudents(List<Integer> list,String id){
        //TODO
        return true;
    }
}
