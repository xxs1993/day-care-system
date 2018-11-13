package csye6200.service;

import csye6200.entity.Vaccine;

import java.util.List;
import java.util.Map;
public interface VaccineService {

    List<Vaccine> getAllVaccination();

    List<Vaccine>getVaccineRecordByStudentId(String studentId);
    Map<String, List<Vaccine>> getStudentIdVaccinationMap();

    List<Vaccine>getRegistedStudentVaccineListByType(String type);

    void addVaccineRecord(Vaccine vaccine);

    //List<String> getUnimmunizedStudentsId();

}
