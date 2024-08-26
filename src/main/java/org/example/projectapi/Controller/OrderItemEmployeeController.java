package org.example.projectapi.Controller;

import org.example.projectapi.Service.OrderItemEmployeeService;
import org.example.projectapi.Service.OrderItemService;
import org.example.projectapi.model.OrderItem;
import org.example.projectapi.model.OrderItemEmployee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/orderItemEmployees")
public class OrderItemEmployeeController {
    @Autowired
    private OrderItemEmployeeService orderItemEmployeeService;

    @GetMapping
    public List<OrderItemEmployee> getAllCustomer() {
        return orderItemEmployeeService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<OrderItemEmployee> getCustomerById(@PathVariable Long id) {
        Optional<OrderItemEmployee> publisher = orderItemEmployeeService.findById(id);
        return publisher.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public OrderItemEmployee createCustomer(@RequestBody OrderItemEmployee publisher) {
        return orderItemEmployeeService.save(publisher);
    }

    @PutMapping("/{id}")
    public ResponseEntity<OrderItemEmployee> updateCustomer(@PathVariable Long id, @RequestBody OrderItemEmployee publisherDetails) {
        Optional<OrderItemEmployee> publisher = orderItemEmployeeService.findById(id);
        if (publisher.isPresent()) {
            OrderItemEmployee updatedPublisher = publisher.get();
            updatedPublisher.setEmployeeId(publisherDetails.getEmployeeId());
            updatedPublisher.setOrderId(publisherDetails.getOrderId());
            return ResponseEntity.ok(orderItemEmployeeService.save(updatedPublisher));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCustomer(@PathVariable Long id) {
        Optional<OrderItemEmployee> publisher = orderItemEmployeeService.findById(id);
        if (publisher.isPresent()) {
            orderItemEmployeeService.deleteById(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
