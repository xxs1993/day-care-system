package csye6200.timer;

import com.google.common.collect.Lists;
import csye6200.constants.Constants;
import csye6200.entity.Vaccine;
import csye6200.facade.StudentFacadeService;
import csye6200.facade.impl.StudentFacadeServiceImpl;


import csye6200.util.EmailSendUtil;

import java.util.Arrays;
import java.util.List;
import java.util.TimerTask;

public class ImmunityTimer extends TimerTask {

    @Override
    public void run() {
//        try {
//            StudentFacadeService service = new StudentFacadeServiceImpl();
//            String[] vaccineType = {Constants.VACCINE_TYPE_1,Constants.VACCINE_TYPE_2,Constants.VACCINE_TYPE_3};  //need it to be all vaccine type
//            List<Vaccine> result1 = service.getUnimmunizedStudentsId(Constants.VACCINE_TYPE_1,false).getData();
//            Result<List<Vaccine>> result2 = service.getUnimmunizedStudentsId(Constants.VACCINE_TYPE_2,false);
//            Result<List<Vaccine>> result3 = service.getUnimmunizedStudentsId(Constants.VACCINE_TYPE_3,false);
//
//            if(result1 == null || result1.isEmpty()){
//                return;
//            }
//            String subject = "Registration remind";
//            StringBuilder content = new StringBuilder();
//            content.append(result.size()).append(" student(s) is(are) not immunized this year \n");
//            content.append(Arrays.toString(list.toArray()));
//            EmailSendUtil.sendEmail(subject,content.toString());
//            System.out.println(Arrays.toString(list.toArray()));
//
//        } catch (Exception e) {
//            e.printStackTrace();
//        }

        try {
            StudentFacadeService service = new StudentFacadeServiceImpl();

            String subject = "Immunization remind";
            StringBuilder sb = new StringBuilder();
            String[]vaccineTypes = {Constants.VACCINE_TYPE_1, Constants.VACCINE_TYPE_2, Constants.VACCINE_TYPE_3};
            for(String vaccineType: vaccineTypes){
                List<Vaccine>vaccineList = service.getUnimmunizedStudentsId(vaccineType, false).getData();
                if(vaccineList!=null&&!vaccineList.isEmpty()){

                    List<String> idList = Lists.transform(vaccineList,(x)->{return x.getStudentId();  });
                    if(idList!=null&&!idList.isEmpty()){
                        sb.append(vaccineType).append(": ").append(idList.size()).append(" students are not immunized");
                        sb.append(Arrays.toString(idList.toArray())+"\n");
                        System.out.println(Arrays.toString(idList.toArray()));

                    }
                }

            }
            if(sb.toString()!=null&&!sb.toString().isEmpty())
              EmailSendUtil.sendEmail(subject,sb.toString());



        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
