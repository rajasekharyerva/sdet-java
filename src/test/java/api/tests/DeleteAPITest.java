package api.tests;

import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

@Feature("Delete API Feature")
public class DeleteAPITest {
    private static final Logger logger = LoggerFactory.getLogger(DeleteAPITest.class);

    //@Test(testName = "TC6-Delete API testName")
    @Test(description = "TC6-Delete API")
    @Description("Calls delete api-rest-assured endpoint")
    @Story("Story-123")
    public void deleteTest() {
        // Set the base URI for the API
        RestAssured.baseURI = "https://api.restful-api.dev";

        // Perform DELETE request to delete the product with ID 3
        Response response = given()
                .header("Content-Type", "application/json")  // Optional, depending on API
                .when()
                .delete("/objects/6")
                .then()
                //.statusCode(200)  // Validate that the status code is 200 OK
                .extract()
                .response();

        // Print response
        logger.info("Response: {}", response.asString());
    }
}
