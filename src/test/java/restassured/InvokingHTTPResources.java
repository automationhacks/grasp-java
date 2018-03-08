package restassured;

import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.ResponseSpecification;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class InvokingHTTPResources {

    /**
     * Basic HTTP method invocation can be done via .request()
     */
    @Test
    public void invokingHttpResourcesTest() {
        when()
                .request("GET", "https://reqres.in/api/unknown") // Valid as of RestAssured 3.0.0
        .then()
                .statusCode(200);
    }

    /**
     * Illustrates that we can pass a payload as a POST request by using body in given clause
     */
    @Test
    public void queryAndFormParamsTest() {
        given()
                // Below is commented as we need to check more about form and query params
//                .param("name", "Smith")
//                .param("job", "Vulcan")
                .body("{\n" +
                        "    \"name\": \"morpheus\",\n" +
                        "    \"job\": \"leader\"\n" +
                        "}")

        .when()
                .request("POST", "https://reqres.in/api/users")
        .then()
                .statusCode(201)
                .body("name", is("morpheus"))
                .body("job", is("leader"));
    }

    /**
     * This test will fail since reqres does not persist POST data that is created
     * But this shows that we can use /{}/{}, param1, param2 to pass parameters in request URL
     */
    @Test
    public void pathParameterTest() {
        baseURI = "https://reqres.in/api";
        String payload = "{\\n\" +\n" +
                "                        \"    \\\"name\\\": \\\"morpheus\\\",\\n\" +\n" +
                "                        \"    \\\"job\\\": \\\"leader\\\"\\n\" +\n" +
                "                        \"}";


        String userId = given()
                .body(payload)
                .when()
                    .request("POST", "/users")
                .then()
                    .extract().path("id");


        String getURL = "/unknown/{userId}";

        given()
               .get(getURL, userId)
        .then()
               .body("data.id", is(userId));
    }

    @Test
    public void verifyingResponseData() {
        baseURI = "https://reqres.in/api";

        //.cookie or .cookies can be used to verify the response for cookie values
        get("/users?page=2").then().assertThat().cookie("__cfduid", notNullValue());

        // can assert on status Code and status Line as well.
        get("/users?page=2").then().assertThat().statusCode(200);
        get("/users?page=2").then().assertThat().statusLine(containsString("200 OK"));

        // use of a mapping function to convert a header into int type and then validate
        // NTS: need to check on method references in java
        get("/users?page=2").then().assertThat().header("Content-Length", Integer::parseInt, greaterThan(25));


    }

    /**
     * Illustrates how response time's can be captured for a particular API call.
     * These would only be a vague representation of server processing time
     * since it would include time for HTTP round trip and Rest Assured processing time as well.
     */
    @Test
    public void verifyResponseTimeTest() {
        baseURI = "https://reqres.in/api";

        long time = get("users?page=2").time();
        long timeInSec = get("users?page=2").timeIn(TimeUnit.SECONDS); // Standard TimeUnit

        System.out.println(time);
        System.out.println(timeInSec);

        // we can also verify this using DSL
        given()
                .get("users/page=2")
                .then()
                .time(lessThan(2000L));
    }

    /**
     * Illustrates how Hash map can be converted to JSON and used in request
     * body
     * Read about how to deserialize a JSON to a Java object from below link:
     * https://github.com/rest-assured/rest-assured/wiki/Usage#deserialization
     */
    @Test
    public void verifyHashMapToJSON() {
        baseURI = "https://reqres.in/api";

        Map<String, String> payload = new HashMap<>();
        payload.put("name", "morpheus");
        payload.put("job", "leader");

        given()
                .contentType(ContentType.JSON)
                .body(payload)
                .when()
                    .request("POST", "/users")
                .then()
                    .statusCode(201);
    }

    /**
     * This illustrates how request and response which conform a certain fixed pattern
     * can use a predefined spec instead of repeating the same validation again.
     */
    @Test
    public void requestAndResponseSpecBuilderTest() {
        baseURI = "https://reqres.in/api";

        // Here the data defined in the Response Spec is merged with additional
        // body expectations

        ResponseSpecBuilder builder = new ResponseSpecBuilder();
        builder.expectStatusCode(200);
        builder.expectBody("data.avatar.size()", greaterThan(1));

        ResponseSpecification rSpec = builder.build();

        given()
                .get("users?page=2")
                .then()
                .spec(rSpec);


        // The same way we can also have a RequestSpecBuilder which
        // can be added as a spec in given() to be used by multiple tests.
    }


}
