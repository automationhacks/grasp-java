package examples;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.lang.reflect.Method;

public class DataProviderInjection {

    @DataProvider(name = "dp")
    public Object[][] dataInjection(Method m) {

        // Gets the method name
        System.out.println(m.getName());

        return new Object[][] {
                {"Cedric"}
        };
    }

    @Test(dataProvider = "dp")
    public void testInjection(String name) {
        System.out.println("User name is: " + name);
    }
}
