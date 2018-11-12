package csye6200.facade.impl;

import com.google.common.base.Strings;
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
        if(!Strings.isNullOrEmpty(student.getId())){
            // remove student from previous teacher
            List<Registration> records = registerService.getRegistrationRecordsByStudentId(student.getId());
            if(records == null || records.isEmpty()){
                result.setMessage("No registration record found for student : "+student.getId());
                return result;
            }
            LocalDate lastRegisterTime = records.get(records.size()-1).getRegisterTime();
            LocalDate now = LocalDate.now();
            int monthDiff = (now.getYear() - lastRegisterTime.getYear())*12 + (now.getMonthValue() - lastRegisterTime.getMonthValue());
            if(monthDiff < Constants.REGISTRATION_DIVIDED_MONTH){
                result.setMessage(String.format("Student %s already registered this year!",student.getId()));
                return result;
            }
            student = studentService.getStudentByID(student.getId());
            removeStudentFromPreviousTeacher(student);
            student.setAge(student.getAge() + monthDiff);
            studentService.updateStudent(student);
        }
        Result<String> re  = addStudentToTeacher(student);
        if(!re.isSuccess()){
            result.setMessage("No available teacher");
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
    public Result<String> removeStudentFromPreviousTeacher(Student student){
        Result<String> result = new Result<>();
        if(Strings.isNullOrEmpty(student.getId())){
            return result;
        }
        List<Teacher>  teachers = teacherService.getTeachersByAgeRange(student.getAge());
        for(Teacher teacher : teachers){
            List<Student> students = teacher.getStudents();
            for(Student stu : students){
                if(student.getId().equals(stu.getId())){
                    teacherService.deleteStudent(student.getId(),teacher.getId());
                    result.setSuccess(true);
                    result.setData(stu.getId());
                    return result;
                }
            }
        }
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
                String id = student.getId();
                if (Strings.isNullOrEmpty(id)) {
                    id = studentService.addStudent(student);
                    student.setId(id);
                }
                teacherService.addStudent(student,t);
                result.setData(id);
                result.setSuccess(true);
                return result;
            }
        }
        return result;
    }


}
