/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test.cste6200.dao.impl;

import com.google.common.collect.Lists;
import csye6200.dao.impl.ClassroomDaoImpl;
import csye6200.entity.ClassRoom;
import csye6200.service.impl.ClassroomServiceImpl;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.junit.Assert.*;
/**
 *
 * @author karen
 */
public class ClassroomDaoImplTest {

    public ClassroomDaoImplTest() {
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

    @Test
    public void testReadClassrooms() throws Exception {
        ClassroomDaoImpl cdimpl = new ClassroomDaoImpl();
        List<ClassRoom> c = cdimpl.readClassrooms();
        c.forEach(System.out::print);
    }

    @Test
    public void testWriteClassrooms() throws Exception {

    }

    @Test
    public void testTransferClassroomToString() throws Exception {
//        ClassroomDaoImpl cdimpl = new ClassroomDaoImpl();
//        List<ClassRoom> c = cdimpl.readClassrooms();
//        List<String> strings = cdimpl.transferClassroomToString(c);
//        for (String s : strings) {
//            System.out.print(s + "\n");
//        }
    }

}
