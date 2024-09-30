package api;

import io.restassured.RestAssured;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class DeleteAPITest {

    public static void main(String[] args) {
        // Set the base URI for the API
        RestAssured.baseURI = "https://api.restful-api.dev";

        // Perform DELETE request to delete the product with ID 3
        Response response = given()
                .header("Content-Type", "application/json")  // Optional, depending on API
                .when()
                .delete("/objects/6")
                .then()
                .statusCode(200)  // Validate that the status code is 200 OK
                .extract()
                .response();

        // Print response
        System.out.println("Response: " + response.asString());
    }
}
