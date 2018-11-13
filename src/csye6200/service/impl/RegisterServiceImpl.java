package csye6200.service.impl;

import com.google.common.base.Strings;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import csye6200.constants.Constants;
import csye6200.entity.Registration;
import csye6200.service.RegisterService;
import csye6200.dao.RegistrationDao;
import csye6200.dao.impl.RegistrationDaoImpl;
import csye6200.util.DateUtil;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class RegisterServiceImpl implements RegisterService {


    @Override
    public List<Registration> getAllRegistration() {
        RegistrationDao registrationDao = new RegistrationDaoImpl();
        return registrationDao.getAllRegistration();
    }

    @Override
    public Map<String, List<Registration>> getStudentIdRegistrationMap() {
        Map<String, List<Registration>> map = Maps.newHashMap();
        List<Registration> list = this.getAllRegistration();
        if (list == null || list.isEmpty()) {
            return map;
        }
        for (Registration re : list) {
            List<Registration> temp = map.get(re.getStudentId());
            if (temp == null) {
                temp = Lists.newArrayList();
            }
            temp.add(re);
            map.put(re.getStudentId(), temp);
        }
        return map;
    }

    @Override
    public List<String> getUnregisteredStudentsId() {
        List<String> studentIdList = Lists.newArrayList();
        Map<String, List<Registration>> map = this.getStudentIdRegistrationMap();
        if (map == null || map.isEmpty()) {
            return studentIdList;
        }
        for (Map.Entry<String, List<Registration>> entry : map.entrySet()) {
            List<Registration> list = entry.getValue();
            String studentId = entry.getKey();
            if (list == null || list.isEmpty()) {
                studentIdList.add(studentId);
                continue;
            }
            //get the newest record and compare the year of the record with current year
            if (list.get(list.size() - 1).getRegisterTime().getYear() < LocalDate.now().getYear()) {
                studentIdList.add(studentId);
            }
        }
        return studentIdList;
    }

    @Override
    public List<Registration> getRegistrationRecordsByStudentId(String studentId) {
        Map<String, List<Registration>> map = this.getStudentIdRegistrationMap();
        if (map == null || map.isEmpty()) {
            return null;
        }
        return map.get(studentId);
    }

    @Override
    public void addRegistrationRecord(Registration reg) {
        if (reg == null || Strings.isNullOrEmpty(reg.getStudentId()) || Strings.isNullOrEmpty(reg.getTimeDisplay())) {
            return;
        }
        RegistrationDao registrationDao = new RegistrationDaoImpl();
        List<Registration> list = this.getAllRegistration();
        if (list == null) {
            list = Lists.newArrayList();
        }
        list.add(reg);
        registrationDao.updateRegistration(list);
    }

    @Override
    public  List<Registration> getRegisteredStudentsByTime(LocalDate time){
        if(time ==  null){
            return null;
        }
        List<Registration> list = this.getAllRegistration();
        return list.stream().filter((x)->{
            return DateUtil.isTheSameSemester(x.getRegisterTime(),time);
        }).collect(Collectors.toList());
    }

}
