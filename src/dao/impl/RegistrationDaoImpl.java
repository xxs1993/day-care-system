package dao.impl;

import com.google.common.base.Splitter;
import com.google.common.collect.Lists;
import csye6200.constants.Constants;
import csye6200.entity.Registration;
import csye6200.exception.DatabaseException;
import csye6200.util.DateUtil;
import csye6200.util.FileUtil;
import dao.RegistrationDao;

import java.util.List;

public class RegistrationDaoImpl implements RegistrationDao {

    /**
     * registration csv format :
     * studentId,timeString
     */

    @Override
    public List<Registration> getAllRegistration() {
        List<Registration> registrations = Lists.newArrayList();
        List<String> contents;
        try {
            contents = FileUtil.readContents(Constants.REGISTRATION_FILE_NAME);
        } catch (DatabaseException e) {
            e.printStackTrace();
            return registrations;
        }
        for (String s : contents) {
            //split items by ","
            List<String> contentString = Splitter.on(Constants.STRING_DIVIDER).trimResults().splitToList(s);
            if (contentString.size() < 2) {
                System.out.println("wrong format of data :" + contentString.toArray().toString());
                continue;
            }
            Registration registration = new Registration(contentString.get(0));
            registration.setTimeDisplay(contents.get(1));
            registration.setRegisterTime(DateUtil.stringToDate(contents.get(1)));
            registrations.add(registration);
        }
        return registrations;
    }


    @Override
    public void updateRegistration(List<Registration> list) {
        if (list == null || list.isEmpty()) {
            System.out.println("Courses content is empty");
            return;
        }
        List<String> contents = Lists.newArrayList();
        for (Registration re : list) {
            StringBuilder sb = new StringBuilder();
            sb.append(re.getStudentId()).append(Constants.STRING_DIVIDER);
            sb.append(re.getTimeDisplay());
            contents.add(sb.toString());
        }
        try {
            FileUtil.writeToFile(Constants.REGISTRATION_FILE_NAME, contents);
        } catch (DatabaseException e) {
            e.printStackTrace();
        }
    }
}
