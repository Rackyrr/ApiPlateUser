package fr.univamu.iut.apiplateuser.service;

import fr.univamu.iut.apiplateuser.entity.Dish;
import java.util.ArrayList;

/**
 * Service interface for managing dishes.
 */
public interface DishService {

    /**
     * Retrieves all dishes.
     *
     * @return An ArrayList containing all dishes.
     */
    public ArrayList<Dish> getAllPlates();

    /**
     * Retrieves a dish by its ID.
     *
     * @param id The ID of the dish to retrieve.
     * @return The dish with the specified ID, or null if not found.
     */
    public Dish getPlateById(int id);

    /**
     * Adds a new dish.
     *
     * @param dish The dish to add.
     * @return The added dish.
     */
    public Dish addPlate(Dish dish);

    /**
     * Updates an existing dish.
     *
     * @param dish The dish to update.
     * @return The updated dish.
     */
    public Dish updatePlate(Dish dish);

    /**
     * Deletes a dish by its ID.
     *
     * @param id The ID of the dish to delete.
     * @return true if the dish was successfully deleted, false otherwise.
     */
    public boolean deletePlate(int id);
}
