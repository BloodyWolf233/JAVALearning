package part3.demo6;

public class Student implements java.io.Serializable {
    private String name;
    private int age;
    //transient element won't into serial steam
    private transient String address;
    // overwrite class will change UID
    private static final long serialVersionUID = 1L;

    @Override
    public String toString() {
        return "Student{ name: " + this.name + ", age: " + this.age + ", address:" + this.address + "}";
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Student() {
    }

    public Student(String name, String address, int age) {
        this.name = name;
        this.address = address;
        this.age = age;
    }

}
