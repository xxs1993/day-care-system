package test.csye6200.service.impl; 

import com.google.common.collect.Lists;
import csye6200.entity.Course;
import csye6200.entity.Teacher;
import csye6200.service.impl.CourseServiceImpl;
import org.junit.Test;
import org.junit.Before; 
import org.junit.After;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/** 
* CourseServiceImpl Tester. 
* 
* @author <Authors name> 
* @since <pre>Ê®ÔÂ 9, 2018</pre> 
* @version 1.0 
*/ 
public class CourseServiceImplTest { 

@Before
public void before() throws Exception { 
} 

@After
public void after() throws Exception { 
} 

/** 
* 
* Method: getCourses() 
* 
*/ 
@Test
public void testGetCourses() throws Exception { 
//TODO: Test goes here...
    CourseServiceImpl courseService = new CourseServiceImpl();
    List<Course> courses = Lists.newArrayList();
    Course course1 = new Course("C1","123",13);
    Course course2 = new Course("C2","234",23);
    List<Teacher> teachers = Lists.newArrayList();
    teachers.add(new Teacher("123","333","male",123,"T23",1));
    teachers.add(new Teacher("123","333","female",123,"T3",1));
    Collections.sort(teachers);
    course2.setTeachers(teachers);
    courses.add(course2);
    courses.add(course1);
    Collections.sort(courses);
    System.out.println(courseService.addCourse(course1));
}

/** 
* 
* Method: getCourseById(String id) 
* 
*/ 
@Test
public void testGetCourseById() throws Exception { 
//TODO: Test goes here... 
} 

/** 
* 
* Method: getStudentsIdByCourseId(String id) 
* 
*/ 
@Test
public void testGetStudentsIdByCourseId() throws Exception { 
//TODO: Test goes here... 
} 

/** 
* 
* Method: getStudentsInCourse(String id) 
* 
*/ 
@Test
public void testGetStudentsInCourse() throws Exception { 
//TODO: Test goes here... 
} 

/** 
* 
* Method: getTeachersIdByCourseId(String id) 
* 
*/ 
@Test
public void testGetTeachersIdByCourseId() throws Exception { 
//TODO: Test goes here... 
} 

/** 
* 
* Method: getTeachersInCourse(String id) 
* 
*/ 
@Test
public void testGetTeachersInCourse() throws Exception { 
//TODO: Test goes here... 
} 

/** 
* 
* Method: addCourse(Course course) 
* 
*/ 
@Test
public void testAddCourse() throws Exception { 
//TODO: Test goes here... 
} 

/** 
* 
* Method: removeCourse(int id) 
* 
*/ 
@Test
public void testRemoveCourse() throws Exception { 
//TODO: Test goes here... 
} 

/** 
* 
* Method: addStudents(List<Student> students) 
* 
*/ 
@Test
public void testAddStudents() throws Exception { 
//TODO: Test goes here... 
} 

/** 
* 
* Method: addTeachers(List<Teacher> teachers) 
* 
*/ 
@Test
public void testAddTeachers() throws Exception { 
//TODO: Test goes here... 
} 

/** 
* 
* Method: removeTeachers(List<Integer> list) 
* 
*/ 
@Test
public void testRemoveTeachers() throws Exception { 
//TODO: Test goes here... 
} 

/** 
* 
* Method: removeStudents(List<Integer> list) 
* 
*/ 
@Test
public void testRemoveStudents() throws Exception { 
//TODO: Test goes here... 
} 


} 
