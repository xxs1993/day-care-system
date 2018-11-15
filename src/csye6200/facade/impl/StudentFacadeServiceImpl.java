package csye6200.facade.impl;

import com.google.common.base.Strings;
import com.google.common.collect.Lists;
import csye6200.constants.Constants;
import csye6200.entity.*;
import csye6200.facade.StudentFacadeService;
import csye6200.facade.dto.Result;
import csye6200.service.*;
import csye6200.service.impl.*;
import csye6200.util.DateUtil;
import csye6200.util.RegulationUtil;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class StudentFacadeServiceImpl implements StudentFacadeService {
    private final StudentService studentService = new StudentServiceImpl();
    private final RegisterService registerService = new RegisterServiceImpl();
    private final TeacherService teacherService = new TeacherServiceImpl();
    private final VaccineService vaccineService = new VaccineServiceImpl();
    private final ClassroomService classroomService = new ClassroomServiceImpl();

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
            if(DateUtil.isTheSameSemester(now,lastRegisterTime)){
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
            //if teacher is not assigned to a classroom
            if(t.getStudents() == null || t.getStudents().size() < maxStudentAmount){
                ClassRoom classRoom = classroomService.getClassRoomByTeacherId(t.getId());
                if(classRoom == null  ||
                        classroomService.getCurrentStudentNumber(classRoom.getId()) >= classRoom.getCapacity()) continue;
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


    @Override
    public Result<List<Vaccine>> getUnimmunizedStudentsId(String type, boolean isImmunized){
        //1.获得今年打过该种疫苗的人
        //2. 获取今年注册的人
        //如果打过 要筛选未打过的人  如果未打过 要筛选打过的人
        //if true 获取注册人的idlist, 循环idlist， 同时疫苗构建成学生id和疫苗对象的map 通过id get对应对象 如果拿到 表示拿过，没拿到 表示没打过
        //3.筛选出
        Result<List<Vaccine>> result= new Result<>();
        List<Registration>registrations = registerService.getRegisteredStudentsByTime(LocalDate.now());
        List<Vaccine>vaccines = vaccineService.getRegistedStudentVaccineListByType(type);
        if(registrations==null||registrations.isEmpty())
            return result;
        List<Vaccine>vaccineList = Lists.newArrayList();

            if(vaccines==null||vaccines.isEmpty()){
                if(!isImmunized) {
                    vaccineList = Lists.transform(registrations, (x) -> {
                        Vaccine vaccine = new Vaccine();
                        vaccine.setStudentId(x.getStudentId());
                        vaccine.setType(type);
                        return vaccine;
                    });
                    result.setData(vaccineList);
                }

                result.setSuccess(true);
                return result;
        }

        LocalDate now = LocalDate.now();
       Map<String,Vaccine>vaccineMap = vaccines.stream().filter((x)->{
        return  DateUtil.isTheSameSemester(x.getVaccinationTime(),now);
       }).collect(Collectors.toMap(x->x.getStudentId(),x->x));
            for(Registration registration:registrations){
                Vaccine vaccine = vaccineMap.get(registration.getStudentId());
                if(isImmunized &&vaccine!=null){
                    vaccineList.add(vaccine);
                }else if(!isImmunized && vaccine == null){
                    vaccine = new Vaccine();
                    vaccine.setStudentId(registration.getStudentId());
                    vaccine.setType(type);
                    vaccineList.add(vaccine);
                }
            }
            result.setSuccess(true);
            result.setData(vaccineList);
            return result;
    }


//    @Override
//    public Result<String> getImmunizedStudentsId(){
//        return null;
//    }


}
