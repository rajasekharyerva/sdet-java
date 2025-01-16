package nested.jsonfiles;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.annotations.Test;

public class GetAPI {
    @Test
    public void testMockAPI() {
        RestAssured.baseURI = "http://localhost:8080";
        Response response = RestAssured.given().get("/api/v1/users").then().extract().response();
        System.out.println(response.asString());
    }
}
