package com.tutorial.carservice.service;

import com.tutorial.carservice.entity.Car;
import com.tutorial.carservice.repository.CarReposiory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarService {

    @Autowired
    CarReposiory carReposiory;

    public List<Car> getAll() {
        return carReposiory.findAll();
    }

    public Car getUserById(int id) {
        return carReposiory.findById(id).orElse(null);
    }

    public Car save(Car user) {
        Car userNew = carReposiory.save(user);
        return userNew;
    }

    public List<Car> byUserId(int userId) {
        return carReposiory.findByUserId(userId);
    }
}
