import java.util.Scanner;

public class Menu {

    private Scanner scanner;


    public Menu() {
        this.scanner = new Scanner(System.in);
    }

    public static void displayMenu() {
        System.out.println("Welcome to the Student Grade Management System");
        System.out.println("1. Add Assignments");
        System.out.println("2. Add Student");
        System.out.println("3. View Grades");
        System.out.println("4. Exit");
        System.out.print("Please select an option (1-4): ");
    }

    //create a scanner object to read user input
    public static Scanner getScanner() {
        return new Scanner(System.in);
    }

    public static void displayGoodbye() {
        System.out.println("Thank you for using the Student Grade Management System. Goodbye!");
    }

    //call methods and classes for appropriate options
    public static void optionCall(int option, GradeBook gradeBook) {
        switch (option) {

            //add new assignment
            case 1:
                System.out.println("Adding a new assignment...");
                System.out.println();
                
                System.out.println("Please enter the assignment name:");
                Scanner scanner1 = getScanner();
                String assignmentName = scanner1.nextLine();
                System.out.println("Please enter the possible points: ");
                int possiblePoints = scanner1.nextInt();

                Assignment newAssignment = new Assignment(assignmentName, possiblePoints);
                gradeBook.getAssignments().add(newAssignment);

                break;

            //add new student
            case 2:
                Scanner scanner2 = getScanner();
                System.out.println("Adding a new student...");
                System.out.println();


                System.out.println("Please enter the student's first name:");
                String firstName = scanner2.nextLine();

                System.out.println("Please enter the student's last name:");
                String lastName = scanner2.nextLine();

                // create a new student object
                Student newStudent = new Student(firstName, lastName, gradeBook);
                gradeBook.addStudent(newStudent);
                
                System.out.println("Student " + newStudent.getName() + " has been added.");
                System.out.println("Please enter the student's assignment details...");
                newStudent.setAssignmentGrade(); // ask for assignment grades
                System.out.println("Grades have been recorded for " + newStudent.getName() + ".");
                
                break;

            //view grades
            case 3:
                System.out.println("Viewing grades...");
                System.out.println();

                gradeBook.viewGrades();
                break;

            //exit the system
            case 4:
                System.out.println("Exiting the system...");
                break;

            //invalid option
            //if user enters anything other than 1-4
            default:
                System.out.println("Invalid option. Please try again.");
        }
    }

    public static void closeScanner() {
        Scanner scanner = getScanner();
        scanner.close();
    }
}
