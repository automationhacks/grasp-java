package concurrency.threadsafe.confinement;


// This class has a race condition in it
// This is actually a way to lazy initialize and create singleton object
// https://www.journaldev.com/1377/java-singleton-design-pattern-best-practices-examples
public class PinballSimulator {
    private static PinballSimulator simulator = null;

    private PinballSimulator() {
        System.out.println("created a PinballSimulator object");
    }

    // Factory method that returns the sole Pinball Simulator object
    // creating it if it doesn't exist
    // To make this Thread safe, you need to add synchronized modifier to this method
    public static PinballSimulator getInstance() {
        if (simulator == null) {
            simulator = new PinballSimulator();
        }
        return simulator;
    }

    public static void main(String[] args) {
        /*
        Below code is prone to race conditions since
        Both threads do not get the same instance and can end up creating
        Two copies of the PinballSimulator object
         */
        new Thread(new Runnable() {
            @Override
            public void run() {
                PinballSimulator instance = PinballSimulator.getInstance();
                System.out.println(instance);
            }
        }).start();

        PinballSimulator anotherInstance = PinballSimulator.getInstance();
        System.out.println(anotherInstance);
    }
}


