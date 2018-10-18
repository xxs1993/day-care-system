package csye6200.controller;


import csye6200.service.CourseService;
import csye6200.service.impl.CourseServiceImpl;
import csye6200.timer.RegistrationTimer;

import javax.swing.*;

public class FrameController {
    public static void main(String[] args){
        java.util.Timer timer = new java.util.Timer();
        timer.scheduleAtFixedRate(new RegistrationTimer(), 1000, 10000);
        JFrame jFrame = new JFrame("ssssss");
        jFrame.setVisible(true);
    }
}
