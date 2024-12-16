package api.tests;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginAPITest {

    @Test
    public void testLoginAPI() {
        // Base URI
        RestAssured.baseURI = "https://dummyjson.com";

        // Payload
        String payload = "{\"username\": \"emilys\", \"password\": \"emilyspass\"}";

        // Perform POST request
        Response response = RestAssured.given()
                .header("Content-Type", "application/json")
                .body(payload)
                .post("/user/login");

        System.out.println(response.jsonPath().getString("username"));

        // Assertions
        // Verify status code is 200
        Assert.assertEquals(response.getStatusCode(), 200, "Status code mismatch!");

        // Verify 'token' key is present in the response body
        Assert.assertTrue(response.jsonPath().getMap("$").containsKey("token"), "Token key is missing in the response body!");

        // Print response for debugging
        System.out.println("Response: " + response.asPrettyString());
    }
}
