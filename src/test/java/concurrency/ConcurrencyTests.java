package concurrency;

import org.junit.Assert;
import org.junit.Test;

// Examples from: http://web.mit.edu/6.031/www/fa17/classes/19-concurrency/
public class ConcurrencyTests {

    @Test
    public void createThreadViaRunnableWithoutAnonymousClass() {
        /*
          We can create a thread by initializing Thread() with an
          instance of a class that implements Runnable interface
         */
        class RunnableDemo implements Runnable {
            @Override
            public void run() {
                System.out.println("Hello from a thread! Yo!");
            }
        }

        RunnableDemo example = new RunnableDemo();
        new Thread(example).start();
    }

    @Test
    public void createThreadViaRunnableWithAnonymousClass() {
        /*
         * Above can be replaced with below instance
         * Can create a new thread by passing an anonymous instance of
         * Runnable class with the threaded code within run method
         */
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("Hello from a thread");
            }
        }).start();
    }

    @Test
    public void createThreadViaRunnableWithLambda() {
        /*
         * Above can be replaced with passing a lambda
         */
        new Thread(() -> System.out.println("Hello from a thread")).start();
    }

    @Test
    public void interleavedThreadOperations() {
        for (int i = 0; i < 5; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    cashMachine();
                }
            }).start();
        }

        // This test fails everytime since multiple threads are trying
        // write on same variable.
        Assert.assertEquals(0, BankBalance.getBalance());
    }

    private void cashMachine() {
        for (int i = 0; i < 10000; ++i) {
            BankBalance.deposit();
            BankBalance.withdraw();
        }
    }
}

class BankBalance {
    private static int balance = 0;

    static void deposit() {
        balance += 1;
    }

    static void withdraw() {
        balance -= 1;
    }

    static int getBalance() {
        return balance;
    }
}