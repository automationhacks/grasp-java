package cave_of_programming.Interfaces_23;


/*
Class can implement n no of interfaces but can only extend one
Interface methods must be implemented in the classes.
 */
public class Machine implements Information {

    private int id = 8;

    public void start() {
        System.out.println("Machine started");
    }

    // This annotation is optional for the implemented method.
    @Override
    public void showInfo() {
        System.out.println("Machine id is: " + id);
    }
}
