package csye6200.service;

import csye6200.entity.Registration;

import java.util.List;
import java.util.Map;

public interface RegisterService {

    List<Registration> getAllRegistration();

    Map<String, List<Registration>> getStudentIdRegistrationMap();

    List<String> getUnregisteredStudentsId();

    List<Registration> getRegistrationRecordsByStudentId(String studentId);

    void addRegistrationRecord(Registration registration);

    List<Registration> getRegisteredStudentsByYear(int year);
}
