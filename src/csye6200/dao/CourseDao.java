package csye6200.dao;

import csye6200.entity.Course;

import java.util.List;

public interface CourseDao {
    List<Course> getCourses();

    void updateCourses(List<Course> courses);

}
