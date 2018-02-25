package examples;

import org.testng.annotations.DataProvider;

public class StaticProvider {

    @DataProvider(name = "getUserIncome")
    public static Object[][] staticProviderMethod() {
        Object[][] data = new Object[][] {
            {10000}, {20000}
        };
        return data;
    }
}
