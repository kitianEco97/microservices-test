package com.tutorial.bikeservice.controller;

import com.tutorial.bikeservice.entity.Bike;
import com.tutorial.bikeservice.service.BikeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/bike")
public class BikeController {

    @Autowired
    BikeService bikeservice;

    @GetMapping
    public ResponseEntity<List<Bike>> getAll() {
        List<Bike> bike = bikeservice.getAll();
        if (bike.isEmpty())
            return ResponseEntity.noContent().build();
        return ResponseEntity.ok(bike);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Bike> getById(@PathVariable("id") int id) {
        Bike bike = bikeservice.getUserById(id);
        if (bike == null)
            return ResponseEntity.notFound().build();
        return ResponseEntity.ok(bike);
    }

    @PostMapping()
    public ResponseEntity<Bike> save(@RequestBody Bike bike) {
        Bike userNew = bikeservice.save(bike);
        return ResponseEntity.ok(userNew);
    }

    @GetMapping("/byuser/{userId}")
    public ResponseEntity<List<Bike>> getByUserId(@PathVariable("userId") int userId) {
        List<Bike> bike = bikeservice.byUserId(userId);
        return ResponseEntity.ok(bike);
    }
}
