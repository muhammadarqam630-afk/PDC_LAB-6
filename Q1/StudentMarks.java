package Q1;
import java.util.HashMap;
import java.util.Map;

public class StudentMarks {

    public static void main(String[] args) {

        HashMap<String, Integer> marks = new HashMap<>();

        marks.put("Arqam", 85);
        marks.put("Hamza", 78);
        marks.put("Sultan", 88);
        marks.put("Masroor", 81);
        marks.put("Ali", 74);

        System.out.println("All student records:");

        for (Map.Entry<String, Integer> student : marks.entrySet()) {
            System.out.println(
                student.getKey() + ": " + student.getValue()
            );
        }

        marks.put("Hamza", 90);

        System.out.println(
            "Updated marks - Hamza: " + marks.get("Hamza")
        );

        String selectedStudent = "Arqam";

        System.out.println(
            "Retrieved marks - " + selectedStudent + ": "
            + marks.get(selectedStudent)
        );

        System.out.println("Total students: " + marks.size());
    }
}