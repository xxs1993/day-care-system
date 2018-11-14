package csye6200.dao;

import java.util.List;

public interface CourseDao {
    List<Course> getCourses();

    void updateCourses(List<Course> courses);

}
