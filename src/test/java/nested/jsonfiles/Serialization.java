package nested.jsonfiles;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.RestAssured;

import java.io.File;
import java.io.IOException;

public class Serialization {
    public static void main(String[] args) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        String jsonResponse = "{\"name\":\"Jane Doe\",\"age\":25,\"email\":\"jane.doe@example.com\"}";

        System.out.println("Serialization: JSON String to POJO");
        User userObject = objectMapper.readValue(jsonResponse, User.class);
        User userObject2 = objectMapper.readValue(new File(System.getProperty("user.dir") + "/src/test/java/nested/jsonfiles/file2.json"), User.class);
        System.out.println(userObject2.toString());
        System.out.println("De-Serialization: POJO to JSON String");
        String deserialObject = objectMapper.writeValueAsString(userObject);
        System.out.println(deserialObject);


        RestAssured.given().body(userObject).post("/api/get/users").then().extract().response();
    }
}
