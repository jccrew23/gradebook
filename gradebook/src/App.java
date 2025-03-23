import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {

        Scanner scanner = new Scanner(System.in);

        //Create a new GradeBook object
        GradeBook gradeBook = new GradeBook();

        // Display the menu to the user
        Menu.displayMenu();
        String option = scanner.nextLine();

        while (!option.equals("4")) {
            // Call the appropriate method based on user input
            Menu.optionCall(Integer.parseInt(option), gradeBook);

            // Display the menu again
            Menu.displayMenu();
            option = scanner.nextLine();
        }
    
        Menu.displayGoodbye();
        scanner.close();

    }
}
