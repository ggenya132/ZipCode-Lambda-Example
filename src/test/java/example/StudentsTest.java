package example;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;

public class StudentsTest {

    private static final Gson gson = new GsonBuilder().setPrettyPrinting().create();


    @Test
    public void studentsAreNotNull(){
        Map<Integer,Student> studentList = Students.getStudents();
        Assertions.assertNotNull(studentList);
    }

    @Test
    public void studentsAreMarshalledIntoJsonSuccessfully(){
        Map<Integer,Student> studentList = Students.getStudents();
        String result = gson.toJson(studentList);
        Assertions.assertNotNull(result);

    }

}
