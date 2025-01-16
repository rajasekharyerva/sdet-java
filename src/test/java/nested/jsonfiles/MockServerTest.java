package nested.jsonfiles;

import com.github.tomakehurst.wiremock.WireMockServer;

import static com.github.tomakehurst.wiremock.client.WireMock.*;

public class MockServerTest {
    public static void main(String[] args) {
        // Step 1: Start WireMock server
        WireMockServer wireMockServer = new WireMockServer(8080); // Default port is 8080
        wireMockServer.start();

        System.out.println("WireMock server started on port 8080");

        // Step 2: Mock an API response
        wireMockServer.stubFor(get(urlEqualTo("/api/v1/users"))
                .willReturn(aResponse()
                        .withHeader("Content-Type", "application/json")
                        .withStatus(200)
                        .withBody("{ \"id\": 1, \"name\": \"John Doe\", \"email\": \"john.doe@example.com\" }")));

        System.out.println("API mocked at: http://localhost:8080/api/v1/users");

        // To keep the server running
        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            wireMockServer.stop();
            System.out.println("WireMock server stopped.");
        }));
    }
}
