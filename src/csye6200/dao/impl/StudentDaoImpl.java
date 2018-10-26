package csye6200.dao.impl;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import com.google.common.base.Splitter;
import com.google.common.collect.Lists;

import csye6200.constants.Constants;
import csye6200.dao.StudentDao;
import csye6200.entity.Student;
import csye6200.service.StudentService;
import csye6200.exception.DatabaseException;
import csye6200.util.FileUtil;

public class StudentDaoImpl implements StudentDao {
    /**
     * student csv format
     * lName, fName, gender, age, id, fatherName, motherName, immDate
     */
	
    @Override
    public List<Student> readStudents() {
        List<Student> students = Lists.newArrayList();
        List<String> contents;
        try {
            contents = FileUtil.readContents(Constants.STUDENT_FILE_NAME);
        } catch (DatabaseException e) {
            e.printStackTrace();
            return students;
        }
        for (String s : contents) {
            //split items by ","
            List<String> contentString = Splitter.on(Constants.STRING_DIVIDER).trimResults().splitToList(s);
            if (contentString.size() < 8) {
                System.out.println("wrong format of data :" + Arrays.toString(contentString.toArray()));
                continue;
            }
            Student student = new Student(contentString.get(0), contentString.get(1),contentString.get(2), Integer.parseInt(contentString.get(3)),
            		contentString.get(4), contentString.get(5),contentString.get(6), contentString.get(7));
            students.add(student);
        }
        return students;
    }

	@Override
	public boolean writeStudent(List<Student> students) {

		List<String> contents = this.transferStudentToString(students);
		try {
			FileUtil.writeToFile(Constants.STUDENT_FILE_NAME, contents);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
    public List<String> transferStudentToString(List<Student> students){
        if(students==null||students.isEmpty()){
            System.out.println("Students content is empty");
            return Lists.newArrayList();
        }
        List<String> contents = Lists.newArrayList();
        for(Student student : students){
            StringBuilder sb = new StringBuilder();
            sb.append(student.getFatherName()).append(Constants.STRING_DIVIDER);
            sb.append(student.getMotherName()).append(Constants.STRING_DIVIDER);
            sb.append(student.getImmDate());
            contents.add(sb.toString());

        }
        return contents;
    }
    
	// Initialize an Id for a new student
	public String initNewID(List<Student> students) {
		if (students == null || students.isEmpty()) {
			return "1";
		}
		Collections.sort(students);
		String lastId = students.get(students.size() - 1).getId();
		String newId = Constants.PREFFIX_STUDENT_ID + String.valueOf(Integer.parseInt(lastId.substring(1)) + 1);
		return newId;
	}

}
