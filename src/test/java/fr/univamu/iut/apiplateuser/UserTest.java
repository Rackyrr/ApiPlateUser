package fr.univamu.iut.apiplateuser;

import fr.univamu.iut.apiplateuser.entity.User;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class UserTest {


    @Test
    public void testUser() {
        User user = new User(1, "JohnDoe", "password", "email@example.com", "7 rue de la Paix");
        assertEquals(1, user.getId());
        assertEquals("JohnDoe", user.getUsername());
        assertEquals("password", user.getPassword());
    }
}
