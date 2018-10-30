package csye6200.timer;

import csye6200.service.RegisterService;
import csye6200.service.impl.RegisterServiceImpl;
import csye6200.util.EmailSendUtil;

import java.util.Arrays;
import java.util.List;
import java.util.TimerTask;

public class RegistrationTimer extends TimerTask {

    @Override
    public void run() {
        try {
            RegisterService service = new RegisterServiceImpl();
            List<String> list = service.getUnregisteredStudentsId();
            if(list == null || list.isEmpty()){
                return;
            }
            String subject = "Registration remind";
            StringBuilder content = new StringBuilder();
            content.append(list.size()).append(" student(s) is(are) not registered this year \n");
            content.append(Arrays.toString(list.toArray()));
            EmailSendUtil.sendEmail(subject,content.toString());
            System.out.println(Arrays.toString(list.toArray()));

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
