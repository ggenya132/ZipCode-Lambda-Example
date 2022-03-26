package example;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class StudentService {
    private Map<Integer, Student> students;

    public StudentService() {
        this.students = Students.students;
    }

    public List<Student> getStudents() {
        return new ArrayList<>(students.values());
    }

    public Student getStudentById(int id) {
        return students.get(id);
    }

    public List<Student> addStudent(Map<String, String> jsonProperties) {

        String firstName = (String) jsonProperties.get("firstName");
        String lastName = (String) jsonProperties.get("lastName");
        String preferredLanguage = (String) jsonProperties.get("preferredLanguage");
        Student newStudent = createStudent(firstName, lastName, preferredLanguage);
        List<Student> students = getStudents();
        students.add(newStudent);
        return students;
    }

    private Student createStudent(String firstName, String lastName, String preferredLanguage) {
        int currentStudentId = getStudents().size() + 1;
        return new Student(currentStudentId, Language.valueOf(preferredLanguage), firstName, lastName);
    }
}
