package examples;

import org.testng.annotations.Test;

@Test( groups = "functest")
public class PartialGroupsTest {

    @Test( groups = "checkintest")
    public void method1() {
        System.out.println("This method belong to both functest and checkin test");
    }

    public void method2() {
        System.out.println("This method belongs to only functest");
    }
}
