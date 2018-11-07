import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import csye6200.dao.impl.ClassroomDaoImpl;
import csye6200.entity.ClassRoom;
import csye6200.service.impl.ClassroomServiceImpl;

public class ClassroomDaoImplTest {

	@Test
    public void testReadClassrooms() throws Exception {
//        ClassroomDaoImpl cdimpl = new ClassroomDaoImpl();
//        List<ClassRoom> c = cdimpl.readClassrooms();
//        c.forEach(System.out::print);
    }
	
	@Test
	public void testWriteClassrooms() {
	    List<ClassRoom> classrooms = new ArrayList<>();
	    ClassRoom c1 = new ClassRoom("R9", 6, 22);
	    ClassRoom c2 = new ClassRoom("R10", 6, 33);
	    ClassRoom c3 = new ClassRoom("R11", 6, 44);
	    classrooms.add(c1);
	    classrooms.add(c2);
	    classrooms.add(c3);
	    ClassroomDaoImpl cdi = new ClassroomDaoImpl();
	    cdi.writeClassroom(classrooms);
	}

}
