package basics;// As part of Notes/languages/java/2_data_types.md
// Implement program to find frequency of each word in a file.

import java.util.Scanner;
import java.util.TreeMap;
import java.io.File;
import java.io.IOException;

public class TreeMapDemo {
    public static void main(String[] args) {
        Scanner data = null;
        TreeMap<String, Integer> wordFrequency;
        String word = null;
        Integer wordCount = null;


        // Read file
        try {
            data = new Scanner(new File("words.dat"));
        }
        catch (IOException e) {
            System.out.println("Oops! Unable to read file.");
            e.printStackTrace();
            System.exit(0);
        }

        // Build frequency Tree Map
        wordFrequency = new TreeMap<String, Integer>();

        while(data.hasNext()) {
            word = data.next().toLowerCase();
            wordCount = wordFrequency.get(word);
            if (wordCount == null) {
                wordCount = 0;
            }
            wordFrequency.put(word, ++wordCount);
        }

        // Print mapping of how many times a word occurred.
        for(String i : wordFrequency.keySet()) {
            System.out.printf("%-20s occured %5d times \n", i, wordFrequency.get(i));
        }
    }   
}