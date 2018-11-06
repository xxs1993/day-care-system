package csye6200.facade.impl;

import csye6200.constants.Constants;
import csye6200.entity.Registration;
import csye6200.entity.Student;
import csye6200.entity.Teacher;
import csye6200.facade.StudentFacadeService;
import csye6200.facade.dto.Result;
import csye6200.service.RegisterService;
import csye6200.service.StudentService;
import csye6200.service.TeacherService;
import csye6200.service.impl.RegisterServiceImpl;
import csye6200.service.impl.StudentServiceImpl;
import csye6200.service.impl.TeacherServiceImpl;
import csye6200.util.DateUtil;
import csye6200.util.RegulationUtil;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

public class StudentFacadeServiceImpl implements StudentFacadeService {
    private final StudentService studentService = new StudentServiceImpl();
    private final RegisterService registerService = new RegisterServiceImpl();
    private final TeacherService teacherService = new TeacherServiceImpl();

    @Override
    public Result<String> register(Student student){
        Result<String> result = new Result<>();
        if(student ==null ){
            result.setData("");
            result.setMessage("Empty student info");
            return result;
        }
        Result<String> re = addStudentToTeacher(student);

        if(!re.isSuccess()){
            result.setData("No available teacher");
            return result;
        }
        String id = re.getData();
        Registration registration = new Registration();
        registration.setStudentId(id);
        LocalDate now = LocalDate.now();
        registration.setStudentId(id);
        registration.setRegisterTime(now);
        registration.setTimeDisplay(DateUtil.dateToString(now));
        registerService.addRegistrationRecord(registration);
        result.setData(id);
        result.setSuccess(true);
        return result;

    }



    @Override
    public Result<String> addStudentToTeacher(Student student){
        Result<String> result = new Result<>();
        result.setSuccess(false);
        List<Teacher> teachers = teacherService.getTeachersByAgeRange(student.getAge());
        if(teachers == null || teachers.isEmpty()){
            return result;
        }
        Map<String,Integer> regulationMap = RegulationUtil.getRegulationMap(student.getAge());
        if(regulationMap == null || regulationMap.isEmpty()){
            return result;
        }
        int maxStudentAmount = regulationMap.get(Constants.MAX_STUDENT_AMOUNT);
        for(Teacher t : teachers){
            if(t.getStudents() == null || t.getStudents().size() < maxStudentAmount){
                String id = studentService.addStudent(student);
                student.setId(id);
                teacherService.addStudent(student,t);
                result.setData(id);
                result.setSuccess(true);
                return result;
            }
        }
        return result;
    }


}
