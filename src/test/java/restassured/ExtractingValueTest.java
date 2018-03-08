package restassured;

import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import java.util.List;
import java.util.Map;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;
import static io.restassured.path.json.JsonPath.*;

public class ExtractingValueTest {


    /**
     * Below test demonstrates that multiple validations can be chained in Rest Assured
     * Also, we can extract values from response by using extract.path("<path_to_value in dot notation>")
     */
    @Test
    public void extractingValuesFromResponse() {

        int totalPagesCount =
        get("https://reqres.in/api/unknown")
        .then()
                .contentType(ContentType.JSON)
                .body("total_pages", is(4))
        .extract()
                .path("total_pages");
        // here we could also have done .response() to return entire response object
        // for further parsing like response.path("<path_to_value in dot notation>")
        // or response.header("headerName")

        System.out.println("Response total pages value " + totalPagesCount);

    }

    /**
     * Illustrates how to get values out from the response using JSON PATH
     */
    @Test
    public void usingJsonPathForValueExtractionTest() {
        Response resp = get("https://reqres.in/api/unknown").then().extract().response();
        String responseText = resp.getBody().asString();

        int total = from(responseText).getInt("total");
        List<String> names = from(responseText).get("data.name");

        System.out.println("Total from API: " + total);

        for (String name : names)
            System.out.printf("%-2s \n", name);

        // Another efficient way of doing this:

        JsonPath jsonPath = new JsonPath(responseText).setRoot("");
        System.out.println(jsonPath.getInt("total"));
        String name = jsonPath.get("data.name");
        System.out.println(name);
    }

    /**
     * Illustrates how to get header and cookies value from response object
     *
     * For a multi value Header or Cookies, get Headers/Cookies Object from Response followed by
     * Headers/Cookies.getValue() method which would return a List of such values.
     */
    @Test
    public void getHeaderInformationTest() {
        Response response = get("https://reqres.in/api/unknown");
        System.out.println("All headers: \n" + response.getHeaders());
        System.out.println("Single header: \n" + response.getHeader("Content-Type"));

        Map<String, String> allCookies = response.getCookies();
        System.out.println("All cookies as Key value pairs: \n" + allCookies);

        System.out.println("Status line: \n" + response.getStatusLine());
        System.out.println("Status code: \n" + response.getStatusCode());

    }
}
