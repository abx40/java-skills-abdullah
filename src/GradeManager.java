import java.util.ArrayList;
import java.util.List;

public class GradeManager {
    // Method to reverse student names in an array
    public static String[] reverseStudentNames(String[] names) {
    // Reverse each individual name (like "John" becomes "nhoJ")
    // Keep the array order the same
    // Return the modified array
        String[] reversedNames = new String[names.length];
        for (int i = 0; i < names.length; i++) {
            StringBuilder sb = new StringBuilder(names[i]);
            reversedNames[i] = sb.reverse().toString();
        }
        return reversedNames;
    }

    // Method to calculate letter grades
    public static char getLetterGrade(int score) {
    // Use if-else conditions:
    // 90-100: 'A', 80-89: 'B', 70-79: 'C', 60-69: 'D', below 60: 'F'
        if (score >= 90 && score <= 100) {
            return 'A';
        } else if (score >= 80 && score < 90) {
            return 'B';
        } else if (score >= 70 && score < 80) {
            return 'C';
        } else if (score >= 60 && score < 70) {
            return 'D';
        } else {
            return 'F';
        }
    }

    // Method to find students who need to retake exam
    public static String[] findFailingStudents(String[] names, int[] scores)
    {
    // Return array of names where score is below 60
    // Use loops to check each student
        List<String> failingStudents = new ArrayList<>();
        for (int i = 0; i < scores.length; i++) {
            if (scores[i] < 60) {
                failingStudents.add(names[i]);
            }
        }
        return failingStudents.toArray(new String[0]);

    }
    public static void main(String[] args) {
        String[] students = {"Alice", "Bob", "Charlie", "Diana"};
        int[] scores = {95, 67, 45, 78};
        // Test all your methods
        // Display results clearly

        String[] reversedNames = reverseStudentNames(students);
        System.out.println("Reversed Names:");
        for (String name : reversedNames) {
            System.out.println(name);
        }
        System.out.println("\nLetter Grades:");
        for (int i = 0; i < scores.length; i++) {
            char grade = getLetterGrade(scores[i]);
            System.out.printf("%s: %c%n", students[i], grade);
        }
        String[] failingStudents = findFailingStudents(students, scores);
        System.out.println("\nFailing Students:");
        if (failingStudents.length == 0) {
            System.out.println("None");
        } else {
            for (String student : failingStudents) {
                System.out.println(student);
            }
        }

    }
}
