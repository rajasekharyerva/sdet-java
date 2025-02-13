package spring.boot;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

class UserServiceTest {

    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private UserService userService;

    @BeforeEach
    void setUp() {
        // Initialize mocks
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testGetUserDetails() {
        // Arrange
        Long userId = 1L;
        User mockUser = new User(1L, "John Doe");
        when(userRepository.findById(userId)).thenReturn(Optional.of(mockUser));

        // Act
        String result = userService.getUserDetails(userId);

        // Assert
        assertEquals("User: John Doe", result);
    }

    @Test
    void testGetUserDetails_UserNotFound() {
        // Arrange
        Long userId = 2L;
        when(userRepository.findById(userId)).thenReturn(Optional.empty());

        // Act & Assert
        assertThrows(RuntimeException.class, () -> userService.getUserDetails(userId));
    }
}