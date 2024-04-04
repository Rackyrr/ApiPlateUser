package fr.univamu.iut.apiplateuser;

import fr.univamu.iut.apiplateuser.controller.DishController;
import fr.univamu.iut.apiplateuser.service.DishService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

class DishControllerTest {

    @Mock
    private DishService dishService;

    private DishController dishController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        dishController = new DishController(dishService);
    }

    @Test
    void testGetAllPlates() {
        // Arrange
        when(dishService.getAllPlates()).thenReturn(new ArrayList<>());

        // Act
        ResponseEntity<String> response = dishController.getAllPlates();

        // Assert
        assertEquals(HttpStatus.OK, response.getStatusCode());
        verify(dishService).getAllPlates();
    }

}
