package org.example.projectapi.Controller;

import org.example.projectapi.Service.OrderItemService;
import org.example.projectapi.Service.RatingService;
import org.example.projectapi.model.OrderItem;
import org.example.projectapi.model.Rating;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/orderItems")
public class OrderItemController {
    @Autowired
    private OrderItemService orderItemService;

    @GetMapping
    public List<OrderItem> getAllCustomer() {
        return orderItemService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<OrderItem> getCustomerById(@PathVariable Long id) {
        Optional<OrderItem> publisher = orderItemService.findById(id);
        return publisher.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public OrderItem createCustomer(@RequestBody OrderItem publisher) {
        return orderItemService.save(publisher);
    }

    @PutMapping("/{id}")
    public ResponseEntity<OrderItem> updateCustomer(@PathVariable Long id, @RequestBody OrderItem publisherDetails) {
        Optional<OrderItem> publisher = orderItemService.findById(id);
        if (publisher.isPresent()) {
            OrderItem updatedPublisher = publisher.get();
            updatedPublisher.setOrder(publisherDetails.getOrder());
            updatedPublisher.setPrice(publisherDetails.getPrice());
            updatedPublisher.setDish(publisherDetails.getDish());
            updatedPublisher.setQuantity(publisherDetails.getQuantity());
            return ResponseEntity.ok(orderItemService.save(updatedPublisher));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCustomer(@PathVariable Long id) {
        Optional<OrderItem> publisher = orderItemService.findById(id);
        if (publisher.isPresent()) {
            orderItemService.deleteById(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
