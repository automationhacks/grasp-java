package examples;

import org.testng.annotations.Test;

public class MultipleGroupsTest {

    @Test( groups = {"functest", "checkintest"})
    public void foo() {
        System.out.println("Foo reporting");
    }

    // Lets try to disable this test using broken
    @Test(groups = {"functest", "broken"})
    public void bar() {
        System.out.println("Bar reporting");
    }

    @Test(groups = {"functest"})
    public void foobar() {
        System.out.println("Foo bar reporting");
    }

    @Test(groups = {"slave"})
    public void barfoo() {
        System.out.println("Well i am a slave");
    }
}
