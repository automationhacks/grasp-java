package cave_of_programming.Variables_1;

public class App {

    public static void main(String[] args) {
        // primitive data types in java

        // Numbers

        byte myByte = 127;
        short myShort = 99;
        int myInt = 1000;
        long myLong = 100000;

        // Fractional numbers
        double myDouble = 34.678;
        float myFloat = 12.34f; // to denote float need to append with an 'f'

        // Character types
        char myChar = 'x';
        boolean myBool = true;
        boolean myBoolNegative = false;

        // Non primitive data types

        String firstName = "Gaurav";
        String lastName = "Singh";

        System.out.println(myByte);
        System.out.println(myShort);
        System.out.println(myInt);
        System.out.println(myLong);
        System.out.println(myDouble);
        System.out.println(myFloat);
        System.out.println(myChar);
        System.out.println(myBool);
        System.out.println(myBoolNegative);

        System.out.println(firstName + " " + lastName); // Example of string concatenation
        System.out.println("My integer is " + myInt); // Can concat nos with strings as well.

    }
}