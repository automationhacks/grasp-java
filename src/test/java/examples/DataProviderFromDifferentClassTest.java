package examples;

import org.testng.annotations.Test;

public class DataProviderFromDifferentClassTest {

    @Test(dataProvider = "getUserIncome", dataProviderClass = StaticProvider.class)
    public void consumersStaticProvider(Integer income) {
        System.out.println(income);
    }
}
