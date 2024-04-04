package fr.univamu.iut.apiplateuser.controller;

import com.google.gson.Gson;
import fr.univamu.iut.apiplateuser.entity.Dish;
import fr.univamu.iut.apiplateuser.service.DishService;
import org.springframework.beans.factory.annotation.Autowired;
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
    public String getAllPlates() {
        return this.gson.toJson(this.dishService.getAllPlates());
    }

    @GetMapping("{id}")
    public String getPlateById(@PathVariable int id) {
        return this.gson.toJson(this.dishService.getPlateById(id));
    }

    @PostMapping("/add")
    public String addPlate(@RequestBody Dish dish) {
        return this.gson.toJson(this.dishService.addPlate(dish));
    }

    @PutMapping("/update")
    public String updatePlate(@RequestBody Dish dish) {
        return this.gson.toJson(this.dishService.updatePlate(dish));
    }

    @DeleteMapping("/delete/{id}")
    public void deletePlate(@PathVariable int id) {
        this.dishService.deletePlate(id);
    }
}
