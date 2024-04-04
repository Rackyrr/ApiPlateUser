package fr.univamu.iut.apiplateuser.controller;

import com.google.gson.Gson;
import fr.univamu.iut.apiplateuser.entity.Dish;
import fr.univamu.iut.apiplateuser.service.DishService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/dish")
public class DishController {

    private final DishService dishService;
    private final Gson gson;

    @Autowired
    public DishController(DishService dishService) {
        this.dishService = dishService;
        this.gson = new Gson();
    }

    @GetMapping("/all")
    public ResponseEntity<String> getAllPlates() {
        return ResponseEntity.ok(this.gson.toJson(this.dishService.getAllPlates()));
    }

    @GetMapping("{id}")
    public ResponseEntity<String> getPlateById(@PathVariable int id) {
        Dish dish = this.dishService.getPlateById(id);
        if (dish != null) {
            return ResponseEntity.ok(this.gson.toJson(dish));
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Dish not found");
        }
    }

    @PostMapping("/add")
    public ResponseEntity<String> addPlate(@RequestBody Dish dish) {
        Dish addedDish = this.dishService.addPlate(dish);
        if (addedDish != null) {
            return ResponseEntity.status(HttpStatus.CREATED).body(this.gson.toJson(addedDish));
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Failed to add dish");
        }
    }

    @PutMapping("/update")
    public ResponseEntity<String> updatePlate(@RequestBody Dish dish) {
        Dish updatedDish = this.dishService.updatePlate(dish);
        if (updatedDish != null) {
            return ResponseEntity.ok(this.gson.toJson(updatedDish));
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Dish not found");
        }
    }

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
