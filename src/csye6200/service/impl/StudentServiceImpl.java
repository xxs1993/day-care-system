package csye6200.service.impl;

import java.util.Collections;
import java.util.Map;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.List;

import com.google.common.base.Strings;
import com.google.common.collect.Lists;

import csye6200.constants.Constants;
import csye6200.dao.StudentDao;
import csye6200.dao.impl.StudentDaoImpl;
import csye6200.entity.Student;
import csye6200.service.StudentService;
import csye6200.util.RegulationUtil;


public class StudentServiceImpl implements StudentService{

    @Override
    public List<Student> getStudent() {
		StudentDaoImpl sd = new StudentDaoImpl();
		return sd.readStudents();
    }



    @Override
    public Student getStudentByID(String id) {
        if(Strings.isNullOrEmpty(id)){
            return null;
        }
        Map<String,Student> map = this.getStudent().stream().collect(Collectors.toMap(x->x.getId(),x->x));

        return map.get(id);
    }

    @Override
    public String addStudent(Student student) {
        if(student==null || Strings.isNullOrEmpty(student.getfName())){
            return "";
        }
        List<Student> students = this.getStudent();

        if(students == null) {
            students = Lists.newArrayList();
        }
        StudentDao studentDao = new StudentDaoImpl();
        String newId = initNewID(students);
        student.setId(newId);
        students.add(student);
        studentDao.writeStudent(students);
        return newId;
    }


    @Override
    public boolean removeStudent(String id) {
		if(Strings.isNullOrEmpty(id)){
			return false;
		}
		boolean result = false;
		List<Student> list = this.getStudent();
		if(list == null || list.isEmpty()){
			return result;
		}
		for(Student t : list){
			if(id.equals(t.getId())){
				list.remove(t);
				result = true;
				break;
			}
		}
		if(!result) {
			return result;
		}
		// instantiate an TeacherImpl object to call write method in ClassroomDao
		StudentDaoImpl tdi = new StudentDaoImpl();
		return tdi.writeStudent(list);
    }

    
    @Override
    public boolean updateStudent(Student student){
       if(student == null || Strings.isNullOrEmpty(student.getId())){
            return false;
            }
            List<Student> list = this.getStudent();
            if(list == null ||list.isEmpty()){
                return false;
            }
            boolean result = false;
            for(Student t : list){
                if(student.getId().equals(t.getId())){
                    Collections.replaceAll(list,t,student);
                    result = true;
                    break;
                }
            }
            if(!result){
                return false;
            }
            StudentDaoImpl tdi = new StudentDaoImpl();
            return tdi.writeStudent(list);
        
    }
    

    
    private String initNewID(List<Student> students){
        if(students == null || students.isEmpty()){
            return Constants.PREFFIX_STUDENT_ID+"1";
        }
        Collections.sort(students);
        String lastId = students.get(students.size()-1).getId();
        String newId = Constants.PREFFIX_STUDENT_ID + String.valueOf(Integer.parseInt(lastId.substring(1))+1);
        return newId;
    }

    @Override
    public List<Student> getStudentsByFirstName(String fName){
        if(Strings.isNullOrEmpty(fName)){
            return null;
        }
        List<Student> students = this.getStudent();
        List<Student> result = Lists.newArrayList();

        if(students == null || students.isEmpty()){
            return result;
        }
        final Pattern pattern = Pattern.compile(String.format("[a-z]*%s[a-z]*",fName.toLowerCase()));
        result = students.stream().filter((x)->{
            return !Strings.isNullOrEmpty(x.getfName()) && pattern.matcher(x.getfName().toLowerCase()).matches();
        }).collect(Collectors.toList());

        return result;
    }


    @Override
    public List<Student> getStudentsByAgeRange(int ageRange){
        final int type = RegulationUtil.getAgeRangeType(ageRange);
        List<Student> students = this.getStudent();
        if(students == null || students.isEmpty()){
            return null;
        }
        List<Student> result = students.stream().filter((x)->{return type == RegulationUtil.getAgeRangeType(x.getAge());}).collect(Collectors.toList());
        return result;
    }




}
