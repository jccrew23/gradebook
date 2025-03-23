import java.util.ArrayList;
import java.util.List;

public class GradeBook {

    private List<Student> _students = new ArrayList<>();
    private List<Assignment> _assignments = new ArrayList<>();
    public GradeBook() {
        // Initialize with some default assignments if needed
        _assignments.add(new Assignment("Assignment 1", 100));
        _assignments.add(new Assignment("Assignment 2", 100));
        _assignments.add(new Assignment("Assignment 3", 100));
        _assignments.add(new Assignment("Assignment 4", 100));
        _assignments.add(new Assignment("Assignment 5", 100));

    }

    public List<Student> getStudents() {
        return _students;
    }

    public List<Assignment> getAssignments() {
        return _assignments;
    }

    public void addStudent(Student student) {
        if (student != null) {
            _students.add(student);
        }
    }

    public void viewGrades() {
        _students.forEach(student -> {
            System.out.println("Student: " + student.getName());
            System.out.println("Average Percentage: " + student.getAveragePercentage() + "%");
            System.out.println("Letter Grade: " + student.getLetterGrade());
            System.out.println();
        });
    }

}
