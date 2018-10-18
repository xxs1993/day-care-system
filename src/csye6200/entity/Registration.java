package csye6200.entity;

import java.time.LocalDate;

public class Registration {
    private String studentId;

    private String timeDisplay;

    private LocalDate registerTime;

    public Registration(String studentId) {
        this.studentId = studentId;
    }

    public Registration() {
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public String getTimeDisplay() {
        return timeDisplay;
    }

    public void setTimeDisplay(String timeDisplay) {
        this.timeDisplay = timeDisplay;
    }

    public LocalDate getRegisterTime() {
        return registerTime;
    }

    public void setRegisterTime(LocalDate registerTime) {
        this.registerTime = registerTime;
    }
}
