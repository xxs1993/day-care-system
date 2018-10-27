package csye6200.dao.impl;

import com.google.common.base.Splitter;
import com.google.common.collect.Lists;
import csye6200.constants.Constants;
import csye6200.entity.Course;
import csye6200.entity.Teacher;
import csye6200.exception.DatabaseException;
import csye6200.util.FileUtil;
import csye6200.dao.CourseDao;

import java.util.List;

public class CourseDaoImpl implements CourseDao {
    /**
     * course csv format
     * id,ageRange,[teacherId1;TeacherId2],name
     */


    @Override
    public List<Course> getCourses() {
        List<Course> courses = Lists.newArrayList();
        List<String> contents;
        try {
            contents = FileUtil.readContents(Constants.COURSE_FILE_NAME);
        } catch (DatabaseException e) {
            e.printStackTrace();
            return courses;
        }
        for (String s : contents) {
            //split items by ","
            List<String> contentString = Splitter.on(Constants.STRING_DIVIDER).trimResults().splitToList(s);
            if (contentString.size() < 4) {
                System.out.println("wrong format of data :" + contentString.toArray().toString());
                continue;
            }
            Course course = new Course(contentString.get(0), contentString.get(3), Integer.parseInt(contentString.get(1)));
            //get teacher id string and remove [ ]
            String idString = contentString.get(2).replace(Constants.ARRAY_DIVIDER_LEFT, "").replace(Constants.ARRAY_DIVIDER_RIGHT, "").trim();
            if (!idString.isEmpty()) {
                List<String> idList = Splitter.on(Constants.ARRAY_STRING_DIVIDER).trimResults().splitToList(idString);
                List<Teacher> teachersInCourse = Lists.newArrayList();
                for (String s1 : idList) {
                    Teacher teacher = new Teacher(s1, "", "", "", 0, 0);
                    teachersInCourse.add(teacher);
                }
                course.setTeachers(teachersInCourse);
            }
            //get id list by splitting ";"

            courses.add(course);

        }

        return courses;
    }


    @Override
    public void updateCourses(List<Course> courses) {
        if (courses == null || courses.isEmpty()) {
            System.out.println("Courses content is empty");
            return;
        }
        List<String> contents = Lists.newArrayList();
        for (Course course : courses) {
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
        } catch (DatabaseException e) {
            e.printStackTrace();
        }
    }
}
