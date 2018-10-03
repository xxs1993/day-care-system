package csye6200.entity;

public class Teacher extends Person {
    private int credits;

    public Teacher(String name, int age,int id) {
        super(name, age,id);
    }

    public Teacher(String name, int age,int id,int credits) {
        super(name, age,id);
        this.credits = credits;
    }

    public int getCredits() {
        return credits;
    }

    public void setCredits(int credits) {
        this.credits = credits;
    }
}
