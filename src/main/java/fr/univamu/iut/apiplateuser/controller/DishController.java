package fr.univamu.iut.apiplateuser.controller;

import com.google.gson.Gson;
import fr.univamu.iut.apiplateuser.entity.Dish;
import fr.univamu.iut.apiplateuser.service.DishService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * Controller for handling dish-related operations.
 */
@RestController
@RequestMapping("/dish")
public class DishController {

    /**
     * The service for managing dishes.
     */
    private final DishService dishService;

    /**
     * Gson instance for JSON serialization/deserialization.
     */
    private final Gson gson;

    /**
     * Constructs a new DishController with the specified DishService.
     *
     * @param dishService The service for managing dishes.
     */
    @Autowired
    public DishController(DishService dishService) {
        this.dishService = dishService;
        this.gson = new Gson();
    }

    /**
     * Retrieves all dishes.
     *
     * @return ResponseEntity with the JSON representation of all dishes.
     */
    @GetMapping("/all")
    public ResponseEntity<String> getAllPlates() {
        return ResponseEntity.ok(this.gson.toJson(this.dishService.getAllPlates()));
    }

    /**
     * Retrieves a dish by its ID.
     *
     * @param id The ID of the dish to retrieve.
     * @return ResponseEntity with the JSON representation of the dish if found, or an error message otherwise.
     */
    @GetMapping("{id}")
    public ResponseEntity<String> getPlateById(@PathVariable int id) {
        Dish dish = this.dishService.getPlateById(id);
        if (dish != null) {
            return ResponseEntity.ok(this.gson.toJson(dish));
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Dish not found");
        }
    }

    /**
     * Adds a new dish.
     *
     * @param dish The dish to add.
     * @return ResponseEntity with the JSON representation of the added dish if successful, or an error message otherwise.
     */
    @PostMapping("/add")
    public ResponseEntity<String> addPlate(@RequestBody Dish dish) {
        Dish addedDish = this.dishService.addPlate(dish);
        if (addedDish != null) {
            return ResponseEntity.status(HttpStatus.CREATED).body(this.gson.toJson(addedDish));
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Failed to add dish");
        }
    }

    /**
     * Updates an existing dish.
     *
     * @param dish The updated dish.
     * @return ResponseEntity with the JSON representation of the updated dish if successful, or an error message otherwise.
     */
    @PutMapping("/update")
    public ResponseEntity<String> updatePlate(@RequestBody Dish dish) {
        Dish updatedDish = this.dishService.updatePlate(dish);
        if (updatedDish != null) {
            return ResponseEntity.ok(this.gson.toJson(updatedDish));
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Dish not found");
        }
    }

    /**
     * Deletes a dish by its ID.
     *
     * @param id The ID of the dish to delete.
     * @return ResponseEntity indicating success or failure of the deletion operation.
     */
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deletePlate(@PathVariable int id) {
        boolean deleted = this.dishService.deletePlate(id);
        if (deleted) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
