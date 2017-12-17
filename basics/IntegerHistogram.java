// As part of Notes/languages/java/2_data_types.md
// Write a program that reads from a file which has integer (0-9) on each line and 
// then prints a histogram, stating how many occurence of a no is present

import java.util.Scanner;
import java.util.ArrayList;
import java.io.File;
import java.io.IOException;

public class IntegerHistogram {
    public static void main(String[] args) {
        Scanner data = null;
        ArrayList<Integer> histogram;
        Integer idx;

        // Example of simple for loop
        // Initialize empty Array List with 0's
        histogram = new ArrayList<Integer>(10);
        for (Integer i=0; i < 10; i++) {
            histogram.add(i, 0);
        }

        // Example of try catch block
        // Get Scanner object which reads from a file
        try {
            data = new Scanner(new File("test.dat"));    
        } catch (IOException e) {
            System.out.println("Oops, error reading file");
            e.printStackTrace();
            System.exit(0);
        }

        // Example of while loop
        // Till file has integer, keep incrementing count of no's in histogram
        // array list
        while(data.hasNextInt()) {
            idx = data.nextInt();
            histogram.set(idx, histogram.get(idx) + 1);
        }

        idx = 0;
        for(Integer i : histogram) {
            System.out.println(idx + " occurred " + i + " times");
            idx++;
        }

    }
}