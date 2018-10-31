package csye6200.service.impl;

import com.google.common.base.Strings;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import csye6200.entity.Vaccine;
import csye6200.service.VaccineService;
import csye6200.dao.VaccineDao;
import csye6200.dao.impl.VaccineDaoImpl;

import java.time.LocalDate;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;


public class VaccineServiceImpl implements VaccineService {
    private VaccineDao vaccineDao = new VaccineDaoImpl();

    @Override
    public List<Vaccine> getAllVaccination(){
        return vaccineDao.getAllVaccination();
    }

    @Override
    public Map<String, List<Vaccine>> getStudentIdVaccinationMap(){
        Map<String, List<Vaccine>> map = Maps.newHashMap();
        List<Vaccine> list = this.getAllVaccination();
        if (list == null || list.isEmpty()) {
            return map;
        }
        for (Vaccine vc : list) {
            List<Vaccine> temp = map.get(vc.getStudentId());
            if (temp == null) {
                temp = Lists.newArrayList();
            }
            temp.add(vc);
            map.put(vc.getStudentId(), temp);
        }
        return map;
    }
    @Override
    public List<List<Vaccine>>getVaccineRecordByStudentId(String studentId){
        List<List<Vaccine>> res = new ArrayList<>();
        List<Vaccine> list = this.getAllVaccination();
        if (list == null || list.isEmpty()) {
            return res;
        }
        for (Vaccine vaccine : list) {
            List<Vaccine> temp = Lists.newArrayList();
            if (vaccine.getStudentId()==studentId) {
                temp.add(vaccine);
                res.add(temp);
            }

        }
        return res;
    }

    @Override
    public void addVaccineRecord(Vaccine vaccine){
        if (vaccine == null || Strings.isNullOrEmpty(vaccine.getType()) || Strings.isNullOrEmpty(vaccine.getStudentId()) || Strings.isNullOrEmpty(vaccine.getTimeDisplay())) {
            return;
        }
        List<Vaccine> list = Lists.newArrayList();
        if (list == null) {
            list = Lists.newArrayList();
        }
        list.add(vaccine);
        vaccineDao.updateVaccination(list);
    }

    @Override
    public List<String> getUnimmunizedStudentsId(){
        List<String> studentIdList = Lists.newArrayList();
        Map<String, List<Vaccine>> map = this.getStudentIdVaccinationMap();
        if (map == null || map.isEmpty()) {
            return studentIdList;
        }
        for (Map.Entry<String, List<Vaccine>> entry : map.entrySet()) {
            List<Vaccine> list = entry.getValue();
            String studentId = entry.getKey();
            if (list == null || list.isEmpty()) {
                studentIdList.add(studentId);
                continue;
            }
            //get the newest record and compare the year of the record with current year
            if (list.get(list.size() - 1).getVaccinationTime().getYear() < LocalDate.now().getYear()) {
                studentIdList.add(studentId);
            }
        }
        return studentIdList;
    }

}
