package caveofprogramming._46_serialization;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;

public class ReadFromFile {

    private static final String PATH = "src/main/java/caveofprogramming/_46_serialization/people.dat";

    public static void read() {

        try(FileInputStream fs = new FileInputStream(PATH)) {
            ObjectInputStream os = new ObjectInputStream(fs);

            Person person1 = (Person) os.readObject();
            Person person2 = (Person) os.readObject();

            System.out.println(person1);
            System.out.println(person2);

            os.close();
        } catch (FileNotFoundException e) {
            System.out.println("File not found at path: " + PATH);
            e.printStackTrace();
        } catch (IOException e) {
            System.out.println("Not able to read file " + PATH);
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            System.out.println("Person class not found in program. Please fix access.");
            e.printStackTrace();
        }
    }
}
