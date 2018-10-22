package csye6200.service.impl;

import com.google.common.base.Strings;
import com.google.common.collect.Lists;
import csye6200.constants.Constants;
import csye6200.entity.Course;
import csye6200.entity.Teacher;
import csye6200.service.CourseService;
import csye6200.util.FileUtil;
import csye6200.dao.CourseDao;
import csye6200.dao.impl.CourseDaoImpl;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class CourseServiceImpl implements CourseService {


    /**
     * course data :  id,ageRange,[teacherId1,teacherId2],name
     * @return
     */

    @Override
    public List<Course> getCourses(){
        CourseDao courseDao = new CourseDaoImpl();
        return courseDao.getCourses();
    }




    @Override
    public List<Course>getCoursesByAgeRange(int age){
        //TODO
        return null;
    }

    @Override
    public Course getCourseById(String id){
        if(Strings.isNullOrEmpty(id)){
            return null;
        }
        Map<String,Course> map = this.getCourses().stream().collect(Collectors.toMap(x->x.getId(),x->x));

        return map.get(id);
    }



    @Override
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

    @Override
    public List<Teacher> getTeachersInCourse(String id){
        if(Strings.isNullOrEmpty(id)){
            return null;
        }
        Course course = this.getCourseById(id);
        return course.getTeachers();
    }



    @Override
    public String addCourse(Course course){
        //TODO
        if(course==null || Strings.isNullOrEmpty(course.getName())){
            return "";
        }
        List<Course> courses = this.getCourses();

        if(courses == null) {
            courses = Lists.newArrayList();
        }
        String newId = initNewID(courses);
        course.setId(newId);
        courses.add(course);
        CourseDao courseDao = new CourseDaoImpl();
        courseDao.updateCourses(courses);
        return newId;
    }

    private String initNewID(List<Course> courses){
        if(courses == null || courses.isEmpty()){
            return Constants.PREFFIX_COURSE_ID+"1";
        }
        Collections.sort(courses);
        String lastId = courses.get(courses.size()-1).getId();
        String newId = Constants.PREFFIX_COURSE_ID + String.valueOf(Integer.parseInt(lastId.substring(1))+1);
        return newId;
    }

    @Override
    public boolean removeCourse(String id) {
        if (Strings.isNullOrEmpty(id)) {
            return false;
        }
        List<Course> courses = this.getCourses();
        for (Course course : courses) {
            if (id.equals(course.getId())) {
                courses.remove(course);
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean addTeachers(List<Teacher> teachers,String id){
        //TODO
        List<Course> courses = this.getCourses();
        return true;
    }

    @Override
    public boolean removeTeachers(List<Integer> list,String id){
        //TODO
        return true;
    }

}
