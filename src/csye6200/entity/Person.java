package csye6200.entity;

public abstract class Person {

   private String name;

   private int age;

   private int id;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    protected Person(String name, int age, int id) {
        this.name = name;
        this.age = age;
        this.id = id;
    }

}
