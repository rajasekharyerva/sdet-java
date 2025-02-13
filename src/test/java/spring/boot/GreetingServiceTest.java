package spring.boot;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GreetingServiceTest {

    private GreetingService greetingService;

    @BeforeEach
    void setUp() {
        // Initialize the service before each test
        greetingService = new GreetingService();
    }

    @Test
    void testGreet() {
        // Arrange
        String name = "John";

        // Act
        String result = greetingService.greet(name);

        // Assert
        assertEquals("Hello, John!", result);
    }
}