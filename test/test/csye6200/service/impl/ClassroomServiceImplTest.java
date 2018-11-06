/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test.csye6200.service.impl;

import com.google.common.collect.Lists;
import csye6200.entity.ClassRoom;
import csye6200.service.impl.ClassroomServiceImpl;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author karen
 */
public class ClassroomServiceImplTest {
    
    public ClassroomServiceImplTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /** 
* 
* Method: getCourses() 
* 
*/ 
@Test
public void testaddClassroom() throws Exception { 
//TODO: Test goes here...
    ClassroomServiceImpl classroomService = new ClassroomServiceImpl();
    List<ClassRoom> classrooms = Lists.newArrayList();
    ClassRoom room1 = new ClassRoom("R1",45,13);
    ClassRoom room2 = new ClassRoom("R6",20,6);
    classroomService.addClassroom(room2);
    classroomService.addClassroom(room1);
    classrooms.forEach(System.out::print);
}
}
