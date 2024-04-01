package fr.univamu.iut.apiplateuser.controller;

import fr.univamu.iut.apiplateuser.entity.Plate;
import fr.univamu.iut.apiplateuser.service.PlateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/plate")
public class PlateController {

    private final PlateService plateService;

    @Autowired
    public PlateController(PlateService plateService) {
        this.plateService = plateService;
    }

    @GetMapping("/all")
    public String getAllPlates() {
        return this.plateService.getAllPlates().toString();
    }

    @GetMapping("{id}")
    public String getPlateById(@PathVariable int id) {
        return this.plateService.getPlateById(id).toString();
    }

    @PostMapping("/add")
    public String addPlate(@RequestBody Plate plate) {
        return this.plateService.addPlate(plate).toString();
    }

    @PutMapping("/update")
    public String updatePlate(@RequestBody Plate plate) {
        return this.plateService.updatePlate(plate).toString();
    }

    @DeleteMapping("/delete/{id}")
    public void deletePlate(@PathVariable int id) {
        this.plateService.deletePlate(id);
    }
}
