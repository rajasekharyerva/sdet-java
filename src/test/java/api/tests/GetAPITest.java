package api.tests;

import io.qameta.allure.Feature;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.notNullValue;

@Feature("Get API")
public class GetAPITest {
    private static final Logger logger = LoggerFactory.getLogger(GetAPITest.class);
    @Test(groups = {"api"}, testName = "TC4-Get API TEST")
    public void testGetAPI() {
        // Base URI for Rest Assured
        RestAssured.baseURI = "https://api.restful-api.dev";

        // Perform GET request
        Response response = given()
                .header("Content-Type", "application/json")
                .when()
                .get("/objects/7")
                .then()
                .assertThat()
                .statusCode(200) // Verify status code is 200
                .body("id", equalTo("7")) // Validate id in response body
                .body("name", equalTo("Apple MacBook Pro 16")) // Validate name field
                .body("data.year", notNullValue()) // Ensure the title is not null
                .extract().response();

        // Print the response for debugging purposes
        logger.info("Response Body: {}", response.asString());
    }
}

