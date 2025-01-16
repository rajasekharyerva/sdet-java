package nested.jsonfiles;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Serialization {
    public static void main(String[] args) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        String jsonResponse = "{\"name\":\"Jane Doe\",\"age\":25,\"email\":\"jane.doe@example.com\"}";

        System.out.println("Serialization: JSON String to POJO");
        User userObject = objectMapper.readValue(jsonResponse, User.class);
        System.out.println(userObject.toString());
        System.out.println("De-Serialization: POJO to JSON String");
        String deserialObject = objectMapper.writeValueAsString(userObject);
        System.out.println(deserialObject);
    }
}
