package example;

import java.util.*;
import java.util.stream.Collectors;

public class Students {
    public static final Map<Integer, Student> students;

    public static Map<Integer, Student> getStudents() {
        return students;
    }

    static  {
        students = createStudents();
    }

    private static Map<Integer,Student> createStudents(){
        Map<Integer,Student> studentHashMap = new HashMap<>();
        List<String> languages = Arrays.stream(Language.values()).map(Enum::name).collect(Collectors.toList());
        int numberOfLanguages = languages.size();
        List<String> names = new ArrayList<>();
        names.add("Broderick Clyde");
        names.add("Brown Meredith");
        names.add("Cho Yun");
        names.add("Chung Allen");
        names.add("Coney Miles");
        names.add("Cun David");
        names.add("Ekhator Vera");
        names.add("Kowalski Joseph");
        names.add("Lee Jason");
        names.add("Maiorini Ethan");
        names.add("Neha Nusera");
        names.add("Powell Daniel");
        names.add("Mike Prentice");
        names.add("Rockandla Madhavi");
        names.add("Shivanaikar Vandana");
        names.add("Walker Alissa");
        names.add("Zheng Wei");
        int studentId = 0;
        for(String name : names){
            String[] firstAndLastName = name.split(" ");
            String firstName = firstAndLastName[1];
            String lastName = firstAndLastName[0];
            Language preferredLanguage = Language.valueOf(languages.get((int)Math.floor(Math.random() * numberOfLanguages)));
            Student student = new Student(++studentId, preferredLanguage, firstName, lastName);
            studentHashMap.put(studentId, student);
        }
        return  studentHashMap;
    }
}
