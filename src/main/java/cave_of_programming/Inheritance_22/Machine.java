package cave_of_programming.Inheritance_22;

public class Machine {

    private String model = "Hyper loop";
    protected String baseModel = "Falcon X";

    public void start() {
        System.out.println("Machine started");
    }

    public void stop() {
        System.out.println("Machine stopped");
    }
}
