package org.example.projectapi.Controller;

import org.example.projectapi.Service.DishService;
import org.example.projectapi.Service.RatingService;
import org.example.projectapi.model.Dish;
import org.example.projectapi.model.Rating;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/dishes")
public class DishController {
    @Autowired
    private DishService dishService;

    @GetMapping
    public List<Dish> getAllDish() {
        return dishService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Dish> getDishById(@PathVariable Long id) {
        Optional<Dish> publisher = dishService.findById(id);
        return publisher.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public Dish createDish(@RequestBody Dish publisher) {
        return dishService.save(publisher);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Dish> updateDish(@PathVariable Long id, @RequestBody Dish publisherDetails) {
        Optional<Dish> publisher = dishService.findById(id);
        if (publisher.isPresent()) {
            Dish updatedPublisher = publisher.get();
            updatedPublisher.setName(publisherDetails.getName());
            updatedPublisher.setImage(publisherDetails.getImage());
            updatedPublisher.setPrice(publisherDetails.getPrice());
            updatedPublisher.setCategory(publisherDetails.getCategory());
            updatedPublisher.setStatus(publisherDetails.getStatus());
//            updatedPublisher.setOrderItems(publisherDetails.getOrderItems());
            updatedPublisher.setDiscount(publisherDetails.getDiscount());
            return ResponseEntity.ok(dishService.save(updatedPublisher));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteDish(@PathVariable Long id) {
        Optional<Dish> publisher = dishService.findById(id);
        if (publisher.isPresent()) {
            dishService.deleteById(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
