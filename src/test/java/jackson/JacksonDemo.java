package jackson;


import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.exc.UnrecognizedPropertyException;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

interface IAPIResponse {
    <T> T deserialize(Class<T> cls, String json) throws IOException;
}

class Person {
    @JsonProperty("username")
    String userName;
}

class APIResponse implements IAPIResponse {
    public <T> T deserialize(Class<T> cls, String json) throws IOException {
        return new ObjectMapper().readValue(json, cls);
    }

    public <T> T deserializeWithIgnore(Class<T> cls, String json) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(DeserializationFeature.FAIL_ON_IGNORED_PROPERTIES, false);
        return mapper.readValue(json, cls);
    }
}

/**
 * https://dzone.com/articles/jackson-json-and-the-proper-handling-of-unknown-fi
 */
public class JacksonDemo {
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
