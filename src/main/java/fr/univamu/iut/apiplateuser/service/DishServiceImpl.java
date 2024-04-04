package fr.univamu.iut.apiplateuser.service;

import fr.univamu.iut.apiplateuser.entity.Dish;
import fr.univamu.iut.apiplateuser.repository.DishRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;

/**
 * Implementation of the DishService interface for managing dishes.
 */
@Service
public class DishServiceImpl implements DishService {

    /**
     * The repository for accessing dish data.
     */
    private final DishRepository plateRepository;

    /**
     * Constructs a new DishServiceImpl with the specified DishRepository.
     *
     * @param plateRepository The repository for accessing dish data.
     */
    @Autowired
    public DishServiceImpl(DishRepository plateRepository) {
        this.plateRepository = plateRepository;
    }

    /**
     * Retrieves all dishes.
     *
     * @return An ArrayList containing all dishes.
     */
    @Override
    public ArrayList<Dish> getAllPlates() {
        return (ArrayList<Dish>) this.plateRepository.findAll();
    }

    /**
     * Retrieves a dish by its ID.
     *
     * @param id The ID of the dish to retrieve.
     * @return The dish with the specified ID, or null if not found.
     */
    @Override
    public Dish getPlateById(int id) {
        return this.plateRepository.findById(id).orElse(null);
    }

    /**
     * Adds a new dish.
     *
     * @param dish The dish to add.
     * @return The added dish.
     */
    @Override
    public Dish addPlate(Dish dish) {
        return this.plateRepository.save(dish);
    }

    /**
     * Updates an existing dish.
     *
     * @param dish The dish to update.
     * @return The updated dish.
     */
    @Override
    public Dish updatePlate(Dish dish) {
        return this.plateRepository.save(dish);
    }

    /**
     * Deletes a dish by its ID.
     *
     * @param id The ID of the dish to delete.
     * @return true if the dish was successfully deleted, false otherwise.
     */
    @Override
    public boolean deletePlate(int id) {
        this.plateRepository.deleteById(id);
        return (this.plateRepository.findById(id).isEmpty());
    }
}
