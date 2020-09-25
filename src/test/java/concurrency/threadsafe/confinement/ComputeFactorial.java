package concurrency.threadsafe.confinement;

import java.math.BigInteger;

public class ComputeFactorial {
    /*
    Local variables are on their individual stack and hence in this example
    n, i and result are not shared between the two threads (main and thread for factorial of 99)
     */
    private static void computeFactorial(final int n) {
        BigInteger result = new BigInteger("1");
        System.out.println("working on factorial for " + n);
        for (int i = 1; i <= n; ++i) {
            result = result.multiply(new BigInteger(String.valueOf(i)));
        }
        System.out.printf("factorial(%d)=%d%n", n, result);
    }

    public static void main(String[] args) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                computeFactorial(99);
            }
        }).start();

        computeFactorial(100);
    }

}
