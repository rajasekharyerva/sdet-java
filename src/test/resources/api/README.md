# API Methods
**Defining a Request Specification:**  
You can create a request specification that includes common elements such as base URI, headers, authentication, or query parameters.

**Example in Java (using RestAssured):**

```java
import io.restassured.specification.RequestSpecification;
import io.restassured.RestAssured;

public class RequestSpec {
public static RequestSpecification requestSpec;

    static {
        requestSpec = RestAssured.given()
                                 .baseUri("https://api.example.com")  // Base URI for the API
                                 .header("Authorization", "Bearer <token>")  // Common authorization header
                                 .contentType("application/json");  // Common content type for requests
    }
}
```

**Example Test Step Using Request Specification:**

```java
import io.restassured.RestAssured;
import io.restassured.response.Response;

public class LoginSteps {

    @Given("the user makes a login request")
    public void theUserMakesALoginRequest() {
        Response response = RestAssured.given()
                                      .spec(RequestSpec.requestSpec)  // Reusing the request specification
                                      .body("{\"username\": \"user1\", \"password\": \"pass123\"}")
                                      .post("/login");
        
        // Further assertions or validations can be done on the response
    }
}
```
### GET
    Respomse response = RestAssured.given()
                        .header("Authorization", "Bearer <token>")
                        .contentType("application/json")
                        .when()
                        .get()
                        .then()
                        .statusCode()
                        .extract()
                        .response()
### POST
    Respomse response = RestAssured.given()
                        .header()
                        .contentType("text/plain")
                        .body("This is a plain text message.")
                        .when()
                        .post()
                        .then()
                        .statusCode()
                        .extract()
                        .response()
### DELETE
    Respomse response = RestAssured.given()
                        .header()
                        .when()
                        .delete()
                        .then()
                        .statusCode()
                        .extract()
                        .response()
### PUT
    Respomse response = RestAssured.given()
                        .header()
                        .redirects().follow(false) // Disable following redirects
                        .when()
                        .put()
                        .then()
                        .statusCode()
                        .extract()
                        .response()

### Status Codes
    1xx - Informational
    2xx - Success
    3xx - Redirects
    4xx - Client
    5xx - Server

### HTTP request consists:
    Request Line: HTTP Method, Request URI, and HTTP Version
    Headers: Key-value pairs providing additional information
    Body: (Optional) Contains data being sent to the server (not present in all requests)
    Query String: (Optional) Parameters sent in the URL for GET requests

### HTTP response contains
    Status Line: Indicates the HTTP version, status code, and reason phrase
    Headers: Key-value pairs providing metadata about the response
    Response Body: The actual data returned to the client, which may include HTML, JSON, or other content types

### API Testing
    Functional Testing
    Performance Testing
    Security Testing
    Error Handling and Validation
    Compatibility Testing
    Documentation Testing
    Usability Testing
    **Dependency Management
    **Logging and Monitoring