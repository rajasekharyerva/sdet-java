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