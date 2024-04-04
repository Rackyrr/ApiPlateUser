package fr.univamu.iut.apiplateuser;

import fr.univamu.iut.apiplateuser.entity.User;
import fr.univamu.iut.apiplateuser.repository.UserRepository;
import fr.univamu.iut.apiplateuser.service.UserService;
import fr.univamu.iut.apiplateuser.service.UserServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

class UserServiceTest {

    @Mock
    private UserRepository userRepository;

    private UserService userService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        userService = new UserServiceImpl(userRepository);
    }
    @Test
    void testGetAllUsersReturnsCorrectData() {
        User user1 = new User(1, "utilisateur1", "123", "test.test@gmail.com", "addresse1");
        User user2 = new User(2, "utilisateur2", "123soleil", "test2.test@gmail.com", "addresse2");
        when(userRepository.findAll()).thenReturn(Arrays.asList(user1, user2));

        List<User> users = userService.getAllUsers();

        assertEquals(2, users.size(), "La taille de la liste des utilisateurs doit être de 2");
        assertEquals("utilisateur1", users.get(0).getUsername(), "Le nom du premier utilisateur doit être 'utilisateur1'");
        assertEquals("utilisateur2", users.get(1).getUsername(), "Le nom du deuxième utilisateur doit être 'utilisateur2'");
    }
}
