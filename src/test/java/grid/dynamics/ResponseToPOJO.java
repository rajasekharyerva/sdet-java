package grid.dynamics;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.RestAssured;

public class ResponseToPOJO {
    public static void main(String[] args) throws JsonProcessingException {
        RestAssured.baseURI = "http://exampleurl.com";
        EmployeeContainer employees = new ObjectMapper().readValue(RestAssured.given().header("Content-Type", "application/json").body("data")
                .when().post("/path").then().statusCode(200).extract().response().getBody().asString(), EmployeeContainer.class);
//Response
    }
}
