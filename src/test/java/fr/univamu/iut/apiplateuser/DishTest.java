package fr.univamu.iut.apiplateuser;

import fr.univamu.iut.apiplateuser.entity.Dish;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class DishTest {

    @Test
    public void testDish() {
        Dish dish = new Dish(1, "Pizza", 10.0, "A delicious pizza");
        assertEquals(1, dish.getId());
        assertEquals("Pizza", dish.getName());
        assertEquals(10.0, dish.getPrice());
        assertEquals("A delicious pizza", dish.getDescription());
    }

    @Test
    public void testDishDefaultConstructor() {
        Dish dish = new Dish();
        assertEquals(0, dish.getId());
        assertEquals(null, dish.getName());
        assertEquals(0.0, dish.getPrice());
        assertEquals(null, dish.getDescription());
    }

    @Test
    public void testDishSetters() {
        Dish dish = new Dish();
        dish.setId(1);
        dish.setName("Pizza");
        dish.setPrice(10.0);
        dish.setDescription("A delicious pizza");
        assertEquals(1, dish.getId());
        assertEquals("Pizza", dish.getName());
        assertEquals(10.0, dish.getPrice());
        assertEquals("A delicious pizza", dish.getDescription());
    }
}
