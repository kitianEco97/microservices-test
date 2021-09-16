package com.tutorial.bikeservice.service;

import com.tutorial.bikeservice.entity.Bike;
import com.tutorial.bikeservice.repository.BikeReposiory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BikeService {

    @Autowired
    BikeReposiory bikeReposiory;

    public List<Bike> getAll() {
        return bikeReposiory.findAll();
    }

    public Bike getUserById(int id) {
        return bikeReposiory.findById(id).orElse(null);
    }

    public Bike save(Bike bike) {
        Bike bikeNew = bikeReposiory.save(bike);
        return bikeNew;
    }

    public List<Bike> byUserId(int userId) {
        return bikeReposiory.findByUserId(userId);
    }
}
