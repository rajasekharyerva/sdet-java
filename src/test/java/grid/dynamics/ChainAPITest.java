package grid.dynamics;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;


public class ChainAPITest {


    @Test
    public void getObjects() throws IOException {
        baseURI = "https://api.restful-api.dev";
        String objectJSON = "{\n" +
                "   \"name\": \"Apple MacBook Pro 16\",\n" +
                "   \"data\": {\n" +
                "      \"year\": 2019,\n" +
                "      \"price\": 1849.99,\n" +
                "      \"CPU model\": \"Intel Core i9\",\n" +
                "      \"Hard disk size\": \"1 TB\"\n" +
                "   }\n" +
                "}";

        ObjectMapper objectMapper = new ObjectMapper();
        JsonNode node = objectMapper.readTree(new File("json"));
        Response response = given().header("Content-Type", "application/json")
                .body(objectJSON)
                .when()
                .post("/objects")
                .then()
                .assertThat()
                .statusCode(200)
                .extract().response();


        ObjectPOJO responsePOJO = objectMapper.readValue(response.asString(), ObjectPOJO.class);
        String objectId = responsePOJO.id;
        given().when()
                .pathParams("id", objectId)
                .get("/objects/{id}")
                .then()
                .assertThat()
                .statusCode(200)
                .body("id".toString(), equalTo(objectId));

        given().pathParams("id", objectId)
                .when()
                .delete("/objects/{id}")
                .then()
                .assertThat()
                .statusCode(200);


        //Response JSON
        //JSON file with nested json

        //Read JSON using jackson library
        ObjectMapper obj = new ObjectMapper();
        JsonNode jsonNode1 = obj.readTree(new File("test.json"));
        //Api Response
        Response res = given().when().get("/endpoint").then().extract().response();
        JsonNode jsonNode2 = obj.readTree(response.asString());
    }
}
