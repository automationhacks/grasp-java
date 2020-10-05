package google.techdev;

import org.testng.Assert;
import org.testng.annotations.Test;

public class ArrayBasicsTest {

    @Test
    public void indexingInArraysTest() {
        int[] numbers = {2, 5, 9, 10};
        Assert.assertEquals(numbers[2], 9);
    }

    @Test(expectedExceptions = ArrayIndexOutOfBoundsException.class)
    public void iterateThruAndArrayTest() {
        boolean[] student = new boolean[4];
        student[0] = true;
        student[1] = false;
        student[2] = true;
        student[3] = false;

        for (int i = 0; i < student.length; i++) {
            System.out.print(" " + student[i]);
        }

        System.out.println();
        System.out.println(student[4]); // ArrayIndexOutOfBoundsException
        System.out.println("Exception statement caught by testng...");
    }

}
