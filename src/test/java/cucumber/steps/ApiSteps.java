package cucumber.steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;

import static org.hamcrest.Matchers.equalTo;

public class ApiSteps {

    private String endpoint;
    private Response response;

    @Given("I set the API endpoint to {string}")
    public void i_set_the_api_endpoint_to(String endpoint) {
        this.endpoint = endpoint;
    }

    @When("I send a GET request")
    public void i_send_a_get_request() {
        response = RestAssured.get(endpoint);
    }

    @Then("the response status code should be {int}")
    public void the_response_status_code_should_be(int statusCode) {
        response.then().statusCode(statusCode);
    }

    @And("the user name should be {string}")
    public void the_user_name_should_be(String userName) {
        response.then().body("name", equalTo(userName));
    }

    @When("user logs abc")
    public void userLogsAbc() {
        System.out.println("User logs abc");
    }

    @Then("user should see abc")
    public void userShouldSeeAbc() {
        System.out.println("User should see ABC");
    }

    @Given("User is on the home page")
    public void userIsOnTheHomePage() {
        System.out.println("Background");
    }
}

