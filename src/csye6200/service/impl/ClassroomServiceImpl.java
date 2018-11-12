/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csye6200.service.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.google.common.base.Strings;

import csye6200.entity.Student;
import csye6200.entity.Teacher;
import csye6200.service.ClassroomService;
import csye6200.dao.impl.ClassroomDaoImpl;
import csye6200.dao.impl.TeacherDaoImpl;
import csye6200.entity.ClassRoom;

/**
 *
 * @author karen classroom data: id,ageRange,capacity,[teacherId1;teacherId2]
 */
public class ClassroomServiceImpl implements ClassroomService {

    @Override
    public List<ClassRoom> getClassrooms() {
        // instantiate an ClassroomDaoImpl object to call read method in ClassroomDao
        ClassroomDaoImpl cdi = new ClassroomDaoImpl();
        List<ClassRoom> classrooms = cdi.readClassrooms();
        for (ClassRoom cr : classrooms) {
            List<Teacher> crTeachers = cr.getTeachers();
            TeacherServiceImpl teacherServiceImpl = new TeacherServiceImpl();
            List<Teacher> allTeachers = teacherServiceImpl.getTeacher();
            Map<String, Teacher> teacherMap = allTeachers.stream().collect(Collectors.toMap(x -> x.getId(), x -> x));
            if (!crTeachers.isEmpty() || crTeachers != null) {
                for (Teacher t : crTeachers) {
                    if (teacherMap.get(t.getId()) != null) {
                        t = teacherMap.get(t.getId());
                    }
                }
            }
            cr.setTeachers(crTeachers);
        }

        return classrooms;
    }

    public ClassRoom getClassroomById(String id) {
        if (Strings.isNullOrEmpty(id)) {
            return null;
        }
        // put all classrooms into a Map with structure of <classroom id, classroom object>
        Map<String, ClassRoom> map = getClassrooms().stream().collect(Collectors.toMap(x -> x.getId(), x -> x));
        return map.get(id);

    }

    public String addTeacher(Teacher teacher, String id) {
        if(isTeacherInAClassroom(teacher.getId())) return "Duplicate";
        if (Strings.isNullOrEmpty(id) || teacher == null) {
            return null;
        } else if (this.getClassroomById(id) != null) {
            ClassroomDaoImpl cdi = new ClassroomDaoImpl();
            List<ClassRoom> classrooms = cdi.readClassrooms();
            ClassRoom classroom = this.getClassroomById(id);
            List<Teacher> teacherList = classroom.getTeachers();
                teacherList.add(teacher);
                String classId = classroom.getId();
                for(ClassRoom c: classrooms) {
                    if(c.getId().equals(classId)){
                        c.setTeachers(teacherList);
                        break;
                    }
                }
                cdi.writeClassroom(classrooms);
                return teacher.getId();
        } else {
            return null;
        }
    }

    public List<Student> getStudentsInClassroom(String id) {
        if (Strings.isNullOrEmpty(id)) {
            return null;
        }
        ClassRoom classroom = getClassroomById(id);
        List<Student> students = new ArrayList<>();
        List<Teacher> teacherList = classroom.getTeachers();
        if (teacherList != null) {
            for (Teacher t : teacherList) {
                if (t.getStudents() != null) {
                    for (Student s : t.getStudents()) {
                        students.add(s);
                    }
                }

            }
        }
        return students;
    }

    public int getCurrentStudentNumber(String id) {
        if (Strings.isNullOrEmpty(id)) {
            return -1;
        }
        return this.getStudentsInClassroom(id).size();
    }

    /*
     * @Ziyan Zhu start
     * 
     */
    // remove teacher by id, return teacher's name
    public String removeTeacher(String teacherId, String id) {
        if (Strings.isNullOrEmpty(teacherId) || Strings.isNullOrEmpty(id)) {
            return null;
        }
        List<ClassRoom> classrooms = this.getClassrooms();
        ClassRoom classroom = this.getClassroomById(id);
        ClassroomDaoImpl cdi = new ClassroomDaoImpl();

        if (classroom == null) {
            return null;
        } else {
            List<Teacher> teachers = this.getTeachersInClassroom(id);
            for (Teacher t : teachers) {
                if (teacherId == t.getId()) {
                    teachers.remove(t);
                    break;
                }
            }
            classroom.setTeachers(teachers);
            for (int i = 0; i < classrooms.size(); i++) {
                if (classrooms.get(i).getId() == classroom.getId()) {
                    classrooms.set(i, classroom);
                }
            }
            cdi.writeClassroom(classrooms);
            return "Teacher " + teacherId + " has been removde from classroom " + id;
        }

    }

    public List<Teacher> getTeachersInClassroom(String id) {
        return this.getClassroomById(id).getTeachers();
    }

    @Override
    public int getCurrentTeacherNumber() {
        int count = 0;
        List<ClassRoom> list = this.getClassrooms();
        for (ClassRoom classroom : list) {
            count += classroom.getTeachers().size();
        }
        return count;
    }

    @Override
    public String addClassroom(ClassRoom classroom) {
        if (classroom == null) {
            return null;
        }
        ClassroomDaoImpl cdi = new ClassroomDaoImpl();
        // read from classroom cvs file
        List<ClassRoom> classrooms = cdi.readClassrooms();
        if (classrooms == null) {
            classrooms = new ArrayList<ClassRoom>();
        }
        // Initiate an Id for the new classroom
        String newId = cdi.initNewID(classrooms);
        classroom.setId(newId);
        classrooms.add(classroom);
        // write into classroom cvs file
        cdi.writeClassroom(classrooms);
        return classroom.getId();
    }

    @Override
    public String removeClassroom(String id) {
        List<ClassRoom> list = this.getClassrooms();
        list.remove(this.getClassroomById(id));
        // instantiate an ClassroomDaoImpl object to call write method in ClassroomDao
        ClassroomDaoImpl cdi = new ClassroomDaoImpl();
        cdi.writeClassroom(list);
        return id;
    }

    @Override
    public boolean IsFull(String id) {

        /*		int cnt = 0;
         List<Teacher> teachers = this.getClassroomById(id).getTeachers();
         cnt += teachers.size();
         for (Teacher teacher : teachers) {
         cnt += new TeacherServiceImpl().getStudentByTeacherId(teacher.getId()).size();
         }
         return (cnt == this.getClassroomById(id).getCapacity());*/
        return false;
    }

    @Override
    public boolean updateClassroom(ClassRoom classroom) {
        if (classroom == null || Strings.isNullOrEmpty(classroom.getId())) {
            return false;
        }
        List<ClassRoom> list = this.getClassrooms();
        if (list == null || list.isEmpty()) {
            return false;
        }
        boolean result = false;
        for (ClassRoom cr : list) {
            if (classroom.getId().equals(cr.getId())) {
                Collections.replaceAll(list, cr, classroom);
                result = true;
                break;
            }
        }
        if (!result) {
            return false;
        }
        ClassroomDaoImpl cdi = new ClassroomDaoImpl();
        return cdi.writeClassroom(list);
    }

    @Override
    public boolean isTeacherInAClassroom(String tid) {
        ClassroomDaoImpl cdi = new ClassroomDaoImpl();
        List<ClassRoom> classrooms = cdi.readClassrooms();
        for(ClassRoom c : classrooms) {
            List<Teacher> teachers = this.getTeachersInClassroom(c.getId());
            for (Teacher t: teachers) {
            if(t.getId().equals(tid)) return true;
        }
        }
        return false;
    }

}
