package api.tests;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class PutAPITest {
    private static final Logger logger = LoggerFactory.getLogger(PutAPITest.class);
    public void putAPITest(){

        // Base URI of the API
        RestAssured.baseURI = "https://jsonplaceholder.typicode.com";

        // Body content as JSON
        String requestBody = "This is a plain text body content";

        // Sending PUT request with JSON string body
        Response initialResponse = RestAssured
                .given()
                .redirects().follow(false) // Disable automatic redirects
                .header("Content-Type", "text/plain") // Set Content-Type to JSON
                .body(requestBody)
                .when()
                .put("/posts/1"); // Endpoint to update post with ID 1

        if (initialResponse.getStatusCode() == 301 || initialResponse.getStatusCode() == 302) {
            String redirectUrl = initialResponse.getHeader("Location");

            // Follow the redirect manually
            Response finalResponse = RestAssured
                    .given()
                    .get(redirectUrl);

            System.out.println("Response Status Code: " + finalResponse.getStatusCode());
            System.out.println("Response Body: " + finalResponse.asString());
        }else {
            System.out.println("Response Status Code: " + initialResponse.getStatusCode());
            System.out.println("Response Body: " + initialResponse.asString());
        }
    }
}
