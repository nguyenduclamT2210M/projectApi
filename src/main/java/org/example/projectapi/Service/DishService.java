package org.example.projectapi.Service;

import org.example.projectapi.Repository.DishRepository;
import org.example.projectapi.Repository.RestaurantTableRepository;
import org.example.projectapi.model.Dish;
import org.example.projectapi.model.RestaurantTable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class DishService {
    @Autowired
    private DishRepository dishRepository;

    public List<Dish> findAll() {
        return dishRepository.findAll();
    }

    public Optional<Dish> findById(Long id) {
        return dishRepository.findById(id);
    }

    public Dish save(Dish customer) {
        return dishRepository.save(customer);
    }

    public void deleteById(Long id) {
        dishRepository.deleteById(id);
    }
}
