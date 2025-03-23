import java.util.ArrayList;
import java.util.List;

public class Student {
    private String _firstName;
    private String _lastName;
    private List<Assignment> _assignments;
    // private Grade _letterGrade;
    private GradeBook _gradeBook;

    public Student(String firstName, String lastName, GradeBook gradeBook) {
        _firstName = firstName;
        _lastName = lastName;
        _gradeBook = gradeBook;

        _assignments = new ArrayList<>();

        addAssignments();
    }

    public String getName() {
        return _firstName + " " + _lastName;
    }

    public float getAveragePercentage() {
        if (_assignments.isEmpty()) {
            return 0; // Avoid division by zero
        }
        float totalPercentage = 0;
        for (Assignment assignment : _assignments) {
            totalPercentage += assignment.getPercentage();
        }
        return totalPercentage / _assignments.size();
    }

    public String getLetterGrade() {
        float averagePercentage = getAveragePercentage();
        if (averagePercentage == 0) {
            return "No grades available"; // Handle case where no grades are set
        }
        
        return Grade.CalculateLetterGrade(averagePercentage);
    }

    // ask for assignment grades
    public void setAssignmentGrade() {
        _assignments.forEach(assignment -> {

            String assignmentName = assignment.getName();
            int pointsAvailable = assignment.getPointsAvailable();

            System.out.println("Please enter the points earned for " + assignmentName + ". There are " + pointsAvailable + "points available. :");
            int pointsEarned = Menu.getScanner().nextInt();
            assignment.setPointsEarned(pointsEarned);
        });
    }

    // public Grade getGrade() {
    //     if (_letterGrade == null) {
    //         _letterGrade = new Grade();
    //     }
    //     return _letterGrade;
    // }

    public void addAssignments() {
        for (Assignment assignment : _gradeBook.getAssignments()) {
            _assignments.add(assignment);
        }
    }
}
