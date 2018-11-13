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
import java.util.stream.Collectors;


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
    public List<Vaccine>getVaccineRecordByStudentId(String studentId){
        if(Strings.isNullOrEmpty(studentId)){
            return null;
        }
        List<Vaccine> res = new ArrayList<>();
        List<Vaccine> list = this.getAllVaccination();
        if (list == null || list.isEmpty()) {
            return res;
        }
        res = list.stream().filter((x)->{return studentId.equals(x.getStudentId());}).collect(Collectors.toList());

        return res;
    }

    @Override
    public void addVaccineRecord(Vaccine vaccine){
        if (vaccine == null || Strings.isNullOrEmpty(vaccine.getType()) || Strings.isNullOrEmpty(vaccine.getStudentId()) || Strings.isNullOrEmpty(vaccine.getTimeDisplay())) {
            return;
        }
        List<Vaccine> list = this.getAllVaccination();
        if (list == null) {
            list = Lists.newArrayList();
        }
        list.add(vaccine);
        vaccineDao.updateVaccination(list);
    }


    @Override
    public List<Vaccine>getRegistedStudentVaccineListByType(String type){
        if(Strings.isNullOrEmpty(type))
            return null;
        List<Vaccine> vaccines= this.getAllVaccination();
        if(vaccines==null){
            return null;
        }
        LocalDate now = LocalDate.now();
        return vaccines.stream().filter((x)->{
            return x.getVaccinationTime().getYear()==now.getYear()&&type.equals(x.getType());
        }).collect(Collectors.toList());

    }



}
