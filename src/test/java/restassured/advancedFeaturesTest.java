package restassured;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class advancedFeaturesTest {

    /**
     * .log() and associated functions can be used to print request or response
     * values. .all() will print all information
     *
     * Note: This filter will only log RequestSpecification related details
     */
    @Test
    public void loggingTest() {
        baseURI = "https://reqres.in/api";

        given()
                .log().all()
                .when()
                .get("users?page=2")
                .then()
                .body("page", is(2));

        given()
                .when()
                .get("users?page=2")
                .then()
                .log().all();

        // There are other flags here like
        /*
        log().ifError() : If an error occurred then only print response body
        .all() will print all info.

        Or other like ifStatusCodeIsEqualTo(200), then only print log
        Read about all the combinations here:
        https://github.com/rest-assured/rest-assured/wiki/Usage#response-logging
         */
    }
}
