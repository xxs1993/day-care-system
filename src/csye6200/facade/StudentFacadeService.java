package csye6200.facade;

import csye6200.entity.Student;
import csye6200.entity.Vaccine;
import csye6200.facade.dto.Result;

import java.util.List;


public interface StudentFacadeService {
    Result<String> register(Student student);

    Result<String> removeStudentFromPreviousTeacher(Student student);


    Result<String> addStudentToTeacher(Student student);


    Result<List<Vaccine>> getUnimmunizedStudentsId(String type, boolean isImmunized);



}
