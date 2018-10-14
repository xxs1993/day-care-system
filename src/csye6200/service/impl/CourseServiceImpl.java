package csye6200.service.impl;

import com.google.common.base.Splitter;
import com.google.common.base.Strings;
import com.google.common.collect.Lists;
import csye6200.constants.Constants;
import csye6200.entity.Course;
import csye6200.entity.Teacher;
import csye6200.exception.DatabaseException;
import csye6200.service.CourseService;
import csye6200.service.TeacherService;
import csye6200.util.FileUtil;

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
        List<Course> courses = Lists.newArrayList();
        //TODO: use teacher service impl
        try {
            List<String> courseContent = FileUtil.readContents(Constants.COURSE_FILE_NAME);
            if(courseContent == null||courseContent.isEmpty()){
                return courses;
            }
//            List<Teacher> teachers = teacherService.getTeacher();
//            Map<String,Teacher> map = teachers.stream().collect(Collectors.toMap(x->x.getId(),x->x));
            courses = transferStringToCourse(courseContent);

        }catch (DatabaseException e){
            e.printStackTrace();
        }
       return courses;
    }

    private List<Course> transferStringToCourse(List<String> contents){
        List<Course> courses = Lists.newArrayList();
        for(String s : contents){
            List<String> contentString = Splitter.on(Constants.STRING_DIVIDER).trimResults().splitToList(s);
            if(contentString.size()<4){
                System.out.println("wrong format of data :" + contentString.toArray().toString());
                continue;
            }
            Course course = new Course(contentString.get(0),contentString.get(3),Integer.parseInt(contentString.get(1)));
            String idString = contentString.get(2).replace(Constants.ARRAY_DIVIDER_LEFT,"").replace(Constants.ARRAY_DIVIDER_RIGHT,"").trim();
            if(idString.isEmpty()){
                continue;
            }
            List<String> idList = Splitter.on(Constants.ARRAY_STRING_DIVIDER).trimResults().splitToList(idString);
            List<Teacher> teachersInCourse = Lists.newArrayList();
            for(String s1:idList){
                Teacher teacher = new Teacher("","","",0,s1,"");
                teachersInCourse.add(teacher) ;
            }
            course.setTeachers(teachersInCourse);
            courses.add(course);

        }
        return courses;
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

    public List<String> transferCourseToString(List<Course> courses){
        if(courses==null||courses.isEmpty()){
            System.out.println("Courses content is empty");
            return Lists.newArrayList();
        }
        List<String> contents = Lists.newArrayList();
        for(Course course : courses){
            StringBuilder sb = new StringBuilder();
            sb.append(course.getId()).append(Constants.STRING_DIVIDER);
            sb.append(course.getAgeRange()).append(Constants.STRING_DIVIDER);
            sb.append(Constants.ARRAY_DIVIDER_LEFT);
            List<Teacher> teachers = course.getTeachers();
            if(teachers!=null && !teachers.isEmpty()){
                for(Teacher teacher:teachers){
                    sb.append(teacher.getId()).append(Constants.STRING_DIVIDER);
                }
                sb.deleteCharAt(sb.length()-1);
            }
            sb.append(Constants.ARRAY_DIVIDER_RIGHT).append(Constants.STRING_DIVIDER);
            sb.append(course.getName());
            contents.add(sb.toString());

        }
        return contents;
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
        List<String> contents = this.transferCourseToString(courses);
        try {
            FileUtil.writeToFile(Constants.COURSE_FILE_NAME, contents);
        }catch (Exception e){
            e.printStackTrace();
            return "";
        }


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
    public boolean removeCourse(int id){
        //TODO
        return true;
    }

    @Override
    public boolean addTeachers(List<Teacher> teachers,String id){
        //TODO
        return true;
    }

    @Override
    public boolean removeTeachers(List<Integer> list,String id){
        //TODO
        return true;
    }

}
