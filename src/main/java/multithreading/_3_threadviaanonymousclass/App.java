package multithreading._3_threadviaanonymousclass;

public class App {
    public static void main(String[] args) {
        Thread aThread = new Thread(new Runnable() {
            @Override
            public void run() {
               for (int i = 0; i < 10; i++) {
                   System.out.println("Job: " + i);
               }
            }
        });

        aThread.start();
    }
}
