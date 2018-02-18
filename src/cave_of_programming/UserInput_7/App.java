package cave_of_programming.UserInput_7;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        // Scanner object to read file stream
        Scanner input = new Scanner(System.in);

        // Message to user to enter value and press enter
        System.out.println("Enter a line: ");

        // Checks if input has a line and then only prints it.
        if (input.hasNextLine()) {
            System.out.println("You entered line as " + input.nextLine());
        }
    }
}