package jackson;


import com.fasterxml.jackson.databind.exc.UnrecognizedPropertyException;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

/**
 * https://dzone.com/articles/jackson-json-and-the-proper-handling-of-unknown-fi
 */
public class JacksonDeserializationTest {
    @Test
    public void whenValidJsonMatchingModel_thenDeserializationSucceeds() {
        String json = "{\n" +
                "  \"username\": \"Gaurav\"\n" +
                "}";

        try {
            Person person = new APIResponse().deserialize(Person.class, json);
            Assert.assertEquals(person.userName, "Gaurav");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void whenJSONHavingExtraUnknownField_thenDeserializationFails() {
        String json = "{\n" +
                "  \"username\": \"Gaurav\",\n" +
                "  \"password\": \"Hello world\"\n" +
                "}";

        Assert.assertThrows(UnrecognizedPropertyException.class, () -> {
            new APIResponse().deserialize(Person.class, json);
        });
    }

    @Test
    public void whenJSONHavingExtraUnknownField_andIgnoreEnabled_thenDeserializationSucceeds() {
        String json = "{\n" +
                "  \"username\": \"Gaurav\",\n" +
                "  \"password\": \"Hello world\"\n" +
                "}";

        try {
            Person person = new APIResponse().deserializeWithIgnore(Person.class, json);
            Assert.assertEquals(person.userName, "Gaurav");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
