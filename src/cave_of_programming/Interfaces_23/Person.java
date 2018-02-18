package cave_of_programming.Interfaces_23;

public class Person implements Information {

    private String name;

    public Person(String name) {
        this.name = name;
    }

    public void greet() {
        System.out.println("Hello there! I am " + name);
    }

    public void showInfo() {
        System.out.println("I am a person with name as " + name);
    }
}
