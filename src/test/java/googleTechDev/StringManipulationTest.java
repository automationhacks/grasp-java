package googleTechDev;

import org.testng.Assert;
import org.testng.annotations.Test;

public class StringManipulationTest {
    String msg = "Hello world";

    @Test
    public void iterateThruEachCharTest() {
        char[] chars = msg.toCharArray();
        for (char c : chars) {
            System.out.println(c);
        }
    }

    @Test
    public void replaceCharsTest() {
        String afterReplace = msg.replace('o', '0');
        Assert.assertEquals("Hell0 w0rld", afterReplace);
    }

    @Test
    public void setCaseOfAString() {
        Assert.assertEquals("HELLO WORLD", msg.toUpperCase());
        Assert.assertEquals("hello world", msg.toLowerCase());
    }

}
