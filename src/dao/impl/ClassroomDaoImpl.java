package dao.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.google.common.base.Splitter;
import com.google.common.base.Strings;
import com.google.common.collect.Lists;

import csye6200.constants.Constants;

import csye6200.entity.*;
import csye6200.exception.DatabaseException;
import csye6200.service.TeacherService;
import csye6200.util.FileUtil;
import dao.ClassroomDao;

public class ClassroomDaoImpl implements ClassroomDao {
	
	// read from the classroom.cvs and return a list of classroom objects
	public List<ClassRoom> readClassrooms() {
		List<ClassRoom> classrooms = new ArrayList();
		try {
			List<String> classContent = FileUtil.readContents(Constants.CLASSROOM_FILE_NAME);
			if (classContent == null || classContent.isEmpty()) {
				return classrooms;
			}
			// TODO: use teacher service impl
			TeacherService teacherService = null;
			List<Teacher> teachers = teacherService.getTeacher();
			Map<String, Teacher> teacherMap = teachers.stream().collect(Collectors.toMap(x -> x.getId(), x -> x));

			for (String cr : classContent) {
				List<String> contentString = Splitter.on(",").trimResults().splitToList(cr);
				// Handle wrong cvs data format
				if (contentString.size() < 4) {
					System.out.println("wrong format of data :" + contentString.toArray().toString());
					continue;
				}
				ClassRoom classroom = new ClassRoom(contentString.get(0), Integer.parseInt(contentString.get(1)),
						Integer.parseInt(contentString.get(3)));
				// Get the teacher list string
				String idString = contentString.get(3).replace(Constants.ARRAY_DIVIDER_RIGHT, "")
						.replace(Constants.ARRAY_DIVIDER_RIGHT, "").trim();
				if (idString.isEmpty()) {
					continue;
				}
				// Get each teacher id
				List<String> idList = Splitter.on(";").trimResults().splitToList(idString);
				// Get teacher objects by id
				List<Teacher> teachersInClassroom = Lists.newArrayList();
				for (String t : idList) {
					Teacher teacher;
					if ((teacher = teacherMap.get(t)) != null) {
						teachersInClassroom.add(teacher);
					}
				}
				classroom.setTeachers(teachersInClassroom);
				classrooms.add(classroom);
			}
		} catch (DatabaseException e) {
			e.printStackTrace();
		}
		return classrooms;
	}

	@Override
	// write a list of classroom objects into classroom.cvs
	public boolean writeClassroom(List<ClassRoom> classrooms) {

		List<String> contents = this.transferClassroomToString(classrooms);
		try {
			FileUtil.writeToFile(Constants.CLASSROOM_FILE_NAME, contents);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
	// Transfer List<ClassRoom> to List<String>
	public List<String> transferClassroomToString(List<ClassRoom> classrooms) {
		if (classrooms == null || classrooms.isEmpty()) {
			System.out.println("Classroom content is empty");
			return Lists.newArrayList();
		}
		List<String> contents = Lists.newArrayList();
		for (ClassRoom classroom : classrooms) {
			StringBuilder sb = new StringBuilder();
			sb.append(classroom.getId()).append(Constants.STRING_DIVIDER);
			sb.append(classroom.getAgeRange()).append(Constants.STRING_DIVIDER);
			sb.append(Constants.ARRAY_DIVIDER_LEFT);
			List<Teacher> teachers = classroom.getTeachers();
			if (teachers != null && !teachers.isEmpty()) {
				for (Teacher teacher : teachers) {
					sb.append(teacher.getId()).append(Constants.STRING_DIVIDER);
				}
				sb.deleteCharAt(sb.length() - 1);
			}
			sb.append(Constants.ARRAY_DIVIDER_RIGHT).append(Constants.STRING_DIVIDER);
			sb.append(classroom.getCapacity());
			contents.add(sb.toString());

		}
		return contents;
	}
	
	// Initialize an Id for a new classroom
	public String initNewID(List<ClassRoom> classrooms) {
		if (classrooms == null || classrooms.isEmpty()) {
			return Constants.PREFFIX_COURSE_ID + "1";
		}
		Collections.sort(classrooms);
		String lastId = classrooms.get(classrooms.size() - 1).getId();
		String newId = Constants.PREFFIX_COURSE_ID + String.valueOf(Integer.parseInt(lastId.substring(1)) + 1);
		return newId;
	}

}
