package examples;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class ParametersTest {

    @Parameters({"serverName", "dbName"})
    @BeforeMethod
    public void setUpTest(String serverName, String dbName) {
        String logger = String.format("Connecting to Server %s with DB %s", serverName, dbName);
        System.out.println(logger);
    }

    /**
     * Illustrates how to pass simple parameters from testng.xml
     * @param userName a parameter
     */
    @Parameters({"userName"})
    @Test
    public void acceptsSimpleParametersTest(String userName) {
        System.out.println("Current logged user " + userName);

    }

    @Parameters({"db"})
    @Test
    public void nonExistentParametersTest(@Optional("default DB") String db) {
        System.out.println("Default value if not found in testng.xml is: " + db);
    }
}
