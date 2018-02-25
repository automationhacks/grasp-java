package examples;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderTest {

    @DataProvider(name = "userAges")
    public Object[][] dataGenerator() {
        return new Object[][]{
            {"Bob", 26},
            {"Dylan", 27}
        };
    }

    @Test(dataProvider = "userAges")
    public void consumerTest(String user, Integer age) {
        System.out.println(user + " " + age);
    }
}
