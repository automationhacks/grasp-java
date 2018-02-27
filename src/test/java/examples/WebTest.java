package examples;

import org.testng.annotations.Test;

public class WebTest {
    private int iter = 0;

    public WebTest(int iterations) {
        iter = iterations;
    }

    @Test
    public void testWebServer() {
        for (int i = 0; i < iter; i++) {
            System.out.println("Testing iteration #: " + i);
        }
    }
}
