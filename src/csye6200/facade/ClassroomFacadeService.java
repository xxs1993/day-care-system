package csye6200.facade;

import csye6200.entity.ClassRoom;
import csye6200.entity.Teacher;
import csye6200.facade.dto.Result;

import java.util.List;

public interface ClassroomFacadeService {
    Result<String> addTeacherToClassroom(ClassRoom classRoom, List<Teacher> teacherList);
}
