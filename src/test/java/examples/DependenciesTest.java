package examples;

import org.testng.annotations.Test;

public class DependenciesTest {

    @Test
    public void serverStarted() {
        System.out.println("Server initialized");
    }

    @Test(dependsOnMethods = {"serverStarted"})
    public void makeHTTPRequest() {
        System.out.println("Making HTTP request");
    }

    @Test(groups = {"Modern"})
    public void barFoo() {
        System.out.println("barFoo: Modern");
    }

    @Test(groups = {"Classic"})
    public void foo() {
        System.out.println("boo: Classic");
    }

    @Test(groups = {"Classic"})
    public void bar() {
        System.out.println("bar: Classic");
    }

    @Test(dependsOnGroups = {"Classic"})
    public void fooBar() {
        System.out.println("fooBar : Classic");
    }
}
