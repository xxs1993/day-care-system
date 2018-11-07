import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

import csye6200.entity.ClassRoom;
import csye6200.service.impl.ClassroomServiceImpl;

public class ClassroomServiceImplTest {

	@Test
	public void testGetClassrooms() {
		ClassroomServiceImpl classroomService = new ClassroomServiceImpl();
	    List<ClassRoom> classrooms = classroomService.getClassrooms();
	    classrooms.forEach(System.out::print);
	}
	
	

}
