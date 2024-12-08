package api.tests;

import io.qameta.allure.Feature;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.Test;
import api.pojo.Data;
import api.pojo.Product;

@Feature("Post API Feature")
public class PostAPITest {
    private static final Logger log = LoggerFactory.getLogger(PostAPITest.class);

    @Test(groups = {"api-rest-assured"}, description = "TC5-Post API TEST")
    public void postObject() {
        RestAssured.baseURI = "https://api.restful-api.dev";

        // Creating the nested data object
        Data data = new Data();
        data.setColor("Cloudy White");
        data.setCapacityGB(512);

        // Creating the main product object
        Product product = new Product();
        product.setId("3");
        product.setName("Apple.txt iPhone 12 Pro Max");
        product.setData(data);

        Response response = RestAssured.given()
                .contentType(ContentType.JSON)
                .body(product)
                .when()
                .post("/objects")
                .then()
                .statusCode(200)
                .extract()
                .response();

        // Deserialize JSON response to POJO
        Product productPOJO = response.as(Product.class);
        log.info("Response Status Code: {}", response.getStatusCode());
        Assert.assertEquals(productPOJO.getName(), "Apple.txt iPhone 12 Pro Max");

    }
}
