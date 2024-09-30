package gatling;

import io.gatling.javaapi.core.*;
import io.gatling.javaapi.http.*;

import static io.gatling.javaapi.core.CoreDsl.*;
import static io.gatling.javaapi.http.HttpDsl.*;

public class MyFirstSimulation extends Simulation {

    // Define the HTTP protocol
    HttpProtocolBuilder httpProtocol = http
            .baseUrl("https://jsonplaceholder.typicode.com") // Base URL for your API
            .acceptHeader("application/json") // Accept header
            .contentTypeHeader("application/json"); // Content-Type header

    // Define the scenario
    ScenarioBuilder scn = scenario("My First Scenario")
            .exec(http("Get Posts") // Name of the request
                    .get("/posts") // API endpoint
                    .check(status().is(200))); // Check for a 200 OK status

    // Setup the simulation
    {
        setUp(
                scn.injectOpen(
                        atOnceUsers(10), // Inject 10 users at once
                        rampUsers(50).during(10) // Ramp up to 50 users over 30 seconds
                )
        ).protocols(httpProtocol);
    }
}

