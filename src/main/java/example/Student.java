package example;

public class Student {
    Integer id;
    Language preferredLanguage;
    public String firstName;
    public String lastName;

    public Student(Integer id, Language preferredLanguage, String firstName, String lastName) {
        this.id = id;
        this.preferredLanguage = preferredLanguage;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", preferredLanguage=" + preferredLanguage +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                '}';
    }
}
