package util.concurrent.lock.io;

public class PersonData {

    private String firstName;
    private int age;

    public PersonData(String firstName, int age) {
        this.firstName = firstName;
        this.age = age;
    }

    public String getFirstName() {
        return firstName;
    }

    public int getAge() {
        return age;
    }
}
