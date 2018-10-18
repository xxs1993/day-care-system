package csye6200.timer;

import csye6200.service.RegisterService;
import csye6200.service.impl.RegisterServiceImpl;

import java.util.Arrays;
import java.util.List;
import java.util.TimerTask;

public class RegistrationTimer extends TimerTask {

    @Override
    public void run() {
        try {
            RegisterService service = new RegisterServiceImpl();
            List<String> list = service.getUnregisteredStudentsId();
            //TODO:doing something
            System.out.println(Arrays.toString(list.toArray()));

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
