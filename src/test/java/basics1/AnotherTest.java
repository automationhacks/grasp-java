package basics1;

import org.testng.annotations.Test;

public class AnotherTest {

    @Test
    public void thisIsAnotherTest() {
        System.out.println("Hi I am another test in package basics1");
    }

    @Test(groups = {"medium"})
    public void iAmAMediumTest() {
        System.out.println("I am just a medium test");
    }
}
