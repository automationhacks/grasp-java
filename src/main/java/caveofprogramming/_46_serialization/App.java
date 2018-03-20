package caveofprogramming._46_serialization;

import java.util.ArrayList;

public class App {
    public static void main(String[] args) {
        Person person1 = new Person(1, "Robert");
        Person person2 = new Person(2, "Dylan");

        ArrayList<Person> persons = new ArrayList<>();
        persons.add(person1);
        persons.add(person2);

        WriteToFile.write(persons);
        ReadFromFile.read();
    }
}
