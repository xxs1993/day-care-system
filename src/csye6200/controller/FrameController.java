package csye6200.controller;


import csye6200.service.CourseService;
import csye6200.service.impl.CourseServiceImpl;

import javax.swing.*;

public class FrameController {
    public static void main(String[] args){
        CourseService courseService = new CourseServiceImpl();
        JFrame jFrame = new JFrame("ssssss");
        jFrame.setVisible(true);
    }
}
