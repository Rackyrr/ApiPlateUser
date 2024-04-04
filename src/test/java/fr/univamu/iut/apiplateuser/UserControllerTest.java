package fr.univamu.iut.apiplateuser;

import com.google.gson.Gson;
import fr.univamu.iut.apiplateuser.controller.UserController;
import fr.univamu.iut.apiplateuser.entity.User;
import fr.univamu.iut.apiplateuser.service.UserService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

class UserControllerTest {

    @Mock
    private UserService userService;

    private UserController userController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        userController = new UserController(userService);
    }

    @Test
    void testGetUserById() {
        // Arrange
        User user = new User(1, "test", "132", "test.test-test@gmail.com", "Salle 004");
        when(userService.getUserById(1)).thenReturn(user);

        // Act
        ResponseEntity<String> response = userController.getUserById(1);

        // Assert
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals("test", new Gson().fromJson(response.getBody(), User.class).getUsername());
        verify(userService).getUserById(1);
    }

}
