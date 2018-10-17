package dao.impl;

import com.google.common.base.Splitter;
import com.google.common.collect.Lists;
import csye6200.constants.Constants;
import csye6200.entity.Course;
import csye6200.entity.Teacher;
import csye6200.exception.DatabaseException;
import csye6200.util.FileUtil;
import dao.CourseDao;

import java.util.List;

public class CourseDaoImpl implements CourseDao {

    @Override
    public  List<Course> getCourses(){
        List<Course> courses = Lists.newArrayList();
        List<String> contents ;
        try {
            contents = FileUtil.readContents(Constants.COURSE_FILE_NAME);
        }catch (DatabaseException e){
            e.printStackTrace();
            return courses;
        }
        for (String s : contents) {
            List<String> contentString = Splitter.on(csye6200.constants.Constants.STRING_DIVIDER).trimResults().splitToList(s);
            if (contentString.size() < 4) {
                System.out.println("wrong format of data :" + contentString.toArray().toString());
                continue;
            }
            csye6200.entity.Course course = new csye6200.entity.Course(contentString.get(0), contentString.get(3), Integer.parseInt(contentString.get(1)));
            String idString = contentString.get(2).replace(csye6200.constants.Constants.ARRAY_DIVIDER_LEFT, "").replace(csye6200.constants.Constants.ARRAY_DIVIDER_RIGHT, "").trim();
            if (idString.isEmpty()) {
                continue;
            }
            List<String> idList = Splitter.on(csye6200.constants.Constants.ARRAY_STRING_DIVIDER).trimResults().splitToList(idString);
            List<csye6200.entity.Teacher> teachersInCourse = Lists.newArrayList();
            for (String s1 : idList) {
                csye6200.entity.Teacher teacher = new Teacher(s1, "", "", "", 0, 0);
                teachersInCourse.add(teacher);
            }
            course.setTeachers(teachersInCourse);
            courses.add(course);

        }

        return courses;
    }


    @Override
    public void updateCourses(List<Course> courses){
        if (courses == null || courses.isEmpty()) {
            System.out.println("Courses content is empty");
            return ;
        }
        List<String> contents = Lists.newArrayList();
        for (csye6200.entity.Course course : courses) {
            StringBuilder sb = new StringBuilder();
            sb.append(course.getId()).append(csye6200.constants.Constants.STRING_DIVIDER);
            sb.append(course.getAgeRange()).append(csye6200.constants.Constants.STRING_DIVIDER);
            sb.append(csye6200.constants.Constants.ARRAY_DIVIDER_LEFT);
            List<csye6200.entity.Teacher> teachers = course.getTeachers();
            if (teachers != null && !teachers.isEmpty()) {
                for (csye6200.entity.Teacher teacher : teachers) {
                    sb.append(teacher.getId()).append(csye6200.constants.Constants.STRING_DIVIDER);
                }
                sb.deleteCharAt(sb.length() - 1);
            }
            sb.append(csye6200.constants.Constants.ARRAY_DIVIDER_RIGHT).append(csye6200.constants.Constants.STRING_DIVIDER);
            sb.append(course.getName());
            contents.add(sb.toString());

        }
        try {
            FileUtil.writeToFile(Constants.COURSE_FILE_NAME, contents);
        }catch (DatabaseException e){
            e.printStackTrace();
        }
    }
}
