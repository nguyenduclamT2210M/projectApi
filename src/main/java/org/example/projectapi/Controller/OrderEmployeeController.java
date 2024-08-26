package org.example.projectapi.Controller;

import org.example.projectapi.Service.OrderEmployeeService;
import org.example.projectapi.Service.OrderItemService;
import org.example.projectapi.model.OrderEmployee;
import org.example.projectapi.model.OrderItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/orderEmployees")
public class OrderEmployeeController {

    @Autowired
    private OrderEmployeeService orderEmployeeService;

    @GetMapping
    public List<OrderEmployee> getAllCustomer() {
        return orderEmployeeService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<OrderEmployee> getCustomerById(@PathVariable Long id) {
        Optional<OrderEmployee> publisher = orderEmployeeService.findById(id);
        return publisher.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public OrderEmployee createCustomer(@RequestBody OrderEmployee publisher) {
        return orderEmployeeService.save(publisher);
    }

    @PutMapping("/{id}")
    public ResponseEntity<OrderEmployee> updateCustomer(@PathVariable Long id, @RequestBody OrderEmployee publisherDetails) {
        Optional<OrderEmployee> publisher = orderEmployeeService.findById(id);
        if (publisher.isPresent()) {
            OrderEmployee updatedPublisher = publisher.get();
            updatedPublisher.setOrder(publisherDetails.getOrder());
            updatedPublisher.setEmployee(publisherDetails.getEmployee()                              );
            return ResponseEntity.ok(orderEmployeeService.save(updatedPublisher));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCustomer(@PathVariable Long id) {
        Optional<OrderEmployee> publisher = orderEmployeeService.findById(id);
        if (publisher.isPresent()) {
            orderEmployeeService.deleteById(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
