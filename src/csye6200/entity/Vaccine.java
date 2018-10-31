package csye6200.entity;
import java.time.LocalDate;
public class Vaccine {
    private String type;
    private String timeDisplay;
    private LocalDate vaccinationTime;
    private String studentId;
    public Vaccine(){
    }
    public Vaccine(String type, String studentId){
        this.type = type;
        this.studentId = studentId;
    }
    public String getType(){
        return type;
    }
    public void setType(String type){this.type = type;}

    public String getTimeDisplay() {
        return timeDisplay;
    }

    public void setTimeDisplay(String timeDisplay) {
        this.timeDisplay = timeDisplay;
    }

    public LocalDate getVaccinationTime() {
        return vaccinationTime;
    }

    public void setVaccinationTime(LocalDate vaccinationTime) {
        this.vaccinationTime = vaccinationTime;
    }

    public void setStudentId(String id){this.studentId=id;}

    public String getStudentId(){return studentId;}
}
