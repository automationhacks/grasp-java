// As part of Notes/languages/java/2_data_types.md
// Write a program that reads from a file which has integer (0-9) on each line and 
// then prints a histogram, stating how many occurence of a no is present
// only this time use "Array" instead of "Array List"

import java.util.Scanner;
import java.io.File;
import java.io.IOException;

public class IntegerHistogramArray {
    public static void main(String[] args) {
        Scanner data = null;
        Integer[] histogram = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        Integer idx;

        try {
            data = new Scanner(new File("test.dat"));                        
        }
        catch(IOException e) {
            System.out.println("Oops! Unable to read file");
            e.printStackTrace();
            System.exit(0);
        }

        while(data.hasNextInt()) {
            idx = data.nextInt();
            histogram[idx] = histogram[idx] + 1;
        }

        idx = 0;
        for (Integer i : histogram) {
            System.out.println(idx + " occured " + i + " times");
            idx++;
        }

    }
}