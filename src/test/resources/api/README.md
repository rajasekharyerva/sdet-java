# API Methods
### GET
    Respomse response = RestAssured.given()
                        .header()
                        .when()
                        .get()
                        .then()
                        .statusCode()
                        .extract()
                        .response()
### POST
    Respomse response = RestAssured.given()
                        .header()
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