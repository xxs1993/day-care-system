package src.csye6200.util;

import com.google.common.base.Splitter;
import com.google.common.collect.Lists;

import java.util.List;

public class TransferUtil {

    public static CourseTransfer() {
        private List<csye6200.entity.Course> transferStringToCourse (List < String > contents) {
            List<csye6200.entity.Course> courses = Lists.newArrayList();
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
                    csye6200.entity.Teacher teacher = new csye6200.entity.Teacher("", "", "", 0, s1, "");
                    teachersInCourse.add(teacher);
                }
                course.setTeachers(teachersInCourse);
                courses.add(course);

            }
            return courses;

            public List<String> transferCourseToString (List < csye6200.entity.Course > courses) {
                if (courses == null || courses.isEmpty()) {
                    System.out.println("Courses content is empty");
                    return Lists.newArrayList();
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
                return contents;
            }
        }
    }
}

    public static TeacherTransfer(){

            public List<String> transferTeacherToString(List< csye6200.entity.Teacher > teachers) {
                    if (teachers == null || teachers.isEmpty()) {
                        System.out.println("Teachers content is empty");
                        return Lists.newArrayList();
                    }
                    List<String> contents = Lists.newArrayList();
                    for (csye6200.entity.Teacher t : teachers) {
                        StringBuilder sb = new StringBuilder();
                        sb.append(t.getId()).append(csye6200.constants.Constants.STRING_DIVIDER);
                        sb.append(t.getAgeRange()).append(csye6200.constants.Constants.STRING_DIVIDER);
                        sb.append(csye6200.constants.Constants.ARRAY_DIVIDER_LEFT);
                        List<csye6200.entity.Student> students = t.getStudents();
                        if (students != null && !students.isEmpty()) {
                            for (csye6200.entity.Student student : students) {
                                sb.append(student.getId()).append(csye6200.constants.Constants.STRING_DIVIDER);
                            }
                            sb.deleteCharAt(sb.length() - 1);
                        }
                        sb.append(csye6200.constants.Constants.ARRAY_DIVIDER_RIGHT).append(csye6200.constants.Constants.STRING_DIVIDER);
                        sb.append(t.getName());
                        contents.add(sb.toString());

                    }
                    return contents;


                }
}
