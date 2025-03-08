package api.tests;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class GetAllObjectsTest {

    @Test
    public void getObjects() throws JSONException {
        String resp = "{\n" +
                "    \"Messages\": [\n" +
                "        {\n" +
                "            \"CreationDate\": \"2021-09-20T16:09:55.683\",\n" +
                "            \"Code\": \"100\",\n" +
                "            \"Description\": \"Document authorized\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"CreationDate\": \"2021-09-20T16:09:45.453\",\n" +
                "            \"Code\": \"904\",\n" +
                "            \"Description\": \"Document sent\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"CreationDate\": \"2021-09-20T16:09:36.03\",\n" +
                "            \"Code\": \"903\",\n" +
                "            \"Description\": \"Document accepted\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"CreationDate\": \"2021-09-20T16:09:31.123\",\n" +
                "            \"Code\": \"902\",\n" +
                "            \"Description\": \"Document validated\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"CreationDate\": \"2021-09-20T16:09:24.33\",\n" +
                "            \"Code\": \"901\",\n" +
                "            \"Description\": \"Document mapped\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"CreationDate\": \"2021-09-20T16:09:17.163\",\n" +
                "            \"Code\": \"900\",\n" +
                "            \"Description\": \"Document imported\"\n" +
                "        }\n" +
                "    ]\n" +
                "}";
        RestAssured.baseURI = "https://api.restful-api.dev";
        Response response = given()
                .body("String").when().put("/path").then().extract().response();

        JSONObject jsonObject = new JSONObject(resp);
        if (jsonObject.get("Messages") instanceof JSONArray) {
            JSONArray array = jsonObject.getJSONArray("Messages");
            for (int i = 0; i < array.length(); i++) {
                JSONObject jobj = (JSONObject) array.get(i);
                System.out.println(jobj.get("Description"));
            }
        }
        ObjectMapper om = new ObjectMapper();
        try {
            JsonNode jn = om.readTree(resp);
            JsonNode jnp = jn.path("Messages");
            if (jnp.isArray()) {
                for (JsonNode node : jnp) {
                    System.out.println(node.path("Description").asText());
                }
            }
            //System.out.println(jn.path("Messages").path("Description"));
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }
}