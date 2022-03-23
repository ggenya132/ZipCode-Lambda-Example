package example;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class StudentService {
    private Map<Integer,Student> students;
    public StudentService(){
        this.students = Students.students;
    }
    public List<Student> getStudents() {
        return new ArrayList<>(students.values());
    }
    public Student getStudentById(int id){
        return students.get(id);
    }
}
