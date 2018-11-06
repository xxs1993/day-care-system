package csye6200.facade;

import csye6200.entity.Student;
import csye6200.facade.dto.Result;

public interface StudentFacadeService {
    Result<String> register(Student student);

    Result<String> addStudentToTeacher(Student student);
}
