package restassured;

import io.restassured.RestAssured;
import io.restassured.config.JsonConfig;
import io.restassured.path.json.config.JsonPathConfig;
import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import java.util.List;

import static io.restassured.path.json.JsonPath.from;
import static org.hamcrest.MatcherAssert.assertThat;

public class BasicsTest {

    @Test
    public void simpleGetMethodTest() {
        RestAssured.get("https://reqres.in/api/users?page=2")
                .then()
                .body("total", Matchers.equalTo(12));
    }

    @Test
    public void matchersHasItemsTest() {
        RestAssured.get("https://reqres.in/api/users?page=2")
                .then()
                .body("data.first_name", Matchers.hasItems("Eve", "Charles"));

    }

    @Test
    public void matchersIsTest() {
        RestAssured.get("https://reqres.in/api/users?page=2")
                .then()
                .body("page", Matchers.is(2));
    }

    /**
     * Illustrates updating the config to ensure all numbers are treated
     * as Decimal.
     */
    @Test
    public void updateConfigToReturnBigDecimalTest() {
        RestAssured
                .given()
                .config(RestAssured.config().jsonConfig(
                        JsonConfig.jsonConfig().numberReturnType
                                (JsonPathConfig.NumberReturnType.BIG_DECIMAL)))
                .when()
                .get("https://reqres.in/api/users?page=2")
                .then()
                .body("total_pages", Matchers.is(4));
    }

    @Test
    public void complexParsingAndValidationTest() {
        // This test does not work in JSON, need to find the groovy syntax for how this works.
        // In rest assured wiki, it shows that this would work for XML path

//        RestAssured.get("https://reqres.in/api/users?page=2")
//                .then()
//                .body("data.find { it.last_name == 'Morris' }.item", Matchers.is("Morris"));

        String response = RestAssured.get("https://reqres.in/api/users?page=2").asString();
        List<String> firstNames = from(response).getList("data.findAll { it.first_name == 'Eve' }.item ");

        for (String name : firstNames) {
            System.out.println(name);

        }
    }

    @Test
    public void arbitraryComplexClosureGroovyDemoTest() {
        // displays power of groovy closure and collections.
        RestAssured.when().get("https://reqres.in/api/users?page=2")
                .then()
                .body("data.last_name.collect { it.length() }.sum()", Matchers.greaterThan(10));

        // another way to write this is:
        // In groovy: we can call a function for each element in a list by using `*.` notation and it returns a list
        // Ex: def words = ['ant', 'buffalo']
        // assert [3, 7] == words*.length()

        RestAssured.when()
                .get("https://reqres.in/api/users?page=2")
                .then()
                .body("data.first_name*.length().sum()", Matchers.greaterThan(10));

        // third way to do the same can be. (This way is called using a JSON path)
        String url = "https://reqres.in/api/users?page=2";
        String response = RestAssured.get(url).asString();
        int sumOfAllFirstNameLengths = from(response).getInt("data.first_name*.length().sum()");
        assertThat(sumOfAllFirstNameLengths, Matchers.greaterThan(5));
    }


}
