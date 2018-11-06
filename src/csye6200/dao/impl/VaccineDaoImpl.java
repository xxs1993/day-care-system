package csye6200.dao.impl;


import com.google.common.base.Splitter;
import com.google.common.collect.Lists;
import csye6200.constants.Constants;
import csye6200.dao.VaccineDao;
import csye6200.entity.Vaccine;
import csye6200.exception.DatabaseException;
import csye6200.util.DateUtil;
import csye6200.util.FileUtil;

import java.util.List;

public class VaccineDaoImpl implements VaccineDao {

    /**
     * vaccine csv format :
     * type,timeString,studentId
     */
    @Override
    public List<Vaccine> getAllVaccination(){
        List<Vaccine> vaccines = Lists.newArrayList();
        List<String> contents;
        try {
            contents = FileUtil.readContents(Constants.VACCINE_FILE_NAME);
        } catch (DatabaseException e) {
            e.printStackTrace();
            return vaccines;
        }
        if (contents == null) {
            System.out.println("No content found for vaccine records");
            return vaccines;
        }
        for (String s : contents) {
            //split items by ","
            List<String> contentString = Splitter.on(Constants.STRING_DIVIDER).trimResults().splitToList(s);
            if (contentString.size() < 3) {
                System.out.println("wrong format of data :" + contentString.toArray().toString());
                continue;
            }
            Vaccine vaccine = new Vaccine(contentString.get(0),contentString.get(2));
            vaccine.setTimeDisplay(contentString.get(1));
            vaccine.setVaccinationTime(DateUtil.stringToDate(contentString.get(1)));
            vaccines.add(vaccine);
        }
        return vaccines;
    }

    @Override
    public void updateVaccination(List<Vaccine> list){
        if (list == null || list.isEmpty()) {
            System.out.println("vaccination record is empty");
            return;
        }
        List<String> contents = Lists.newArrayList();
        for (Vaccine vaccine : list) {
            StringBuilder sb = new StringBuilder();
            sb.append(vaccine.getType()).append(Constants.STRING_DIVIDER);
            sb.append(vaccine.getTimeDisplay()).append(Constants.STRING_DIVIDER);
            sb.append(vaccine.getStudentId());
            contents.add(sb.toString());
        }
        try {
            FileUtil.writeToFile(Constants.VACCINE_FILE_NAME, contents);
        } catch (DatabaseException e) {
            e.printStackTrace();
        }
    }

}
