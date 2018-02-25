package examples;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class SimpleTest {

    @BeforeClass
    public void setUp() {
        System.out.println("Ran before tests");
    }

    /**
     * "@Test" tells which functions are Test's and function names can be any
     * test method can below to several groups.
     */
    @Test(groups = { "fast" })
    public void aFastTest() {
        System.out.println("Fast test");
    }

    @Test(groups = { "slow" })
    public void aSlowTest() {
        System.out.println("Slow test");
    }

    @Test
    public void aMediumTest() {
        System.out.println("Medium Test");
    }
}
