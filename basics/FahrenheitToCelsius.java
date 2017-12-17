// As part of Notes/languages/java/2_data_types.md
// write java program to convert fahrenheit to celsius

import java.util.Scanner;

public class FahrenheitToCelsius {
    
    public static double convert(double temperature) {
        double celsius = (temperature - 32) * 5/9; 
        return celsius;
    }

    public static void main(String[] args) {
        // init an input stream to take user input
        Scanner in = new Scanner(System.in);
        System.out.println("Enter temperature in fahrenheit: ");
        double fahrenheit = in.nextDouble();
        in.close(); // close input stream

        double converted  = convert(fahrenheit);
        System.out.println("Temperature in celsius " + converted);
    }
}