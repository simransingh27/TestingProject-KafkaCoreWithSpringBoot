package model;

public class User {
    private String firstName;
    private String lastName;
    private String age;
    private String university;

    public String getFirstName() {
        return firstName;
    }

    public User(String firstName, String lastName, String age, String university) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.university = university;
    }

    public User() {

    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }


    public String getUniversity() {
        return university;
    }

    public void setUniversity(String university) {
        this.university = university;
    }


}
