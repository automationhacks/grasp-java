package examples;

import org.testng.annotations.Test;

public class ReturnValueTest {

    /**
     * This would not be picked unless we set allow-return-values="true" in either suite or test
     * Strangely this works at suite level only. Need to check why?
     * @return string message
     */
    @Test
    public String iReturnSomething() {
        String msg = "This is a message";
        System.out.println(msg);
        return msg;
    }
}
