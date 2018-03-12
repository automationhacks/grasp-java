package caveofprogramming._41_writingfiles;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class App {

    public static void main(String[] args) {

        File file = new File("src/main/java/caveofprogramming/_41_writingfile/syslog.txt");
        try(BufferedWriter bw = new BufferedWriter(new FileWriter(file))) {
            bw.write("Hello World!");
            bw.newLine();
            bw.write("Welcome to world of java programming");
        }
        catch (IOException e) {
            System.out.println("Error while writing to file " + file.toString());
            e.printStackTrace();
        }
    }
}
