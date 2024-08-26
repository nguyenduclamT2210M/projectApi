package org.example.projectapi.Controller;

import org.example.projectapi.Service.EmployeeService;
import org.example.projectapi.Service.OrderService;
import org.example.projectapi.model.AppOrder;
import org.example.projectapi.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/orders")
public class OrderController {
    @Autowired
    private OrderService orderService;

    @GetMapping
    public List<AppOrder> getAllCustomer() {
        return orderService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<AppOrder> getCustomerById(@PathVariable Long id) {
        Optional<AppOrder> publisher = orderService.findById(id);
        return publisher.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public AppOrder createEmployee(@RequestBody AppOrder publisher) {
        return orderService.save(publisher);
    }

    @PutMapping("/{id}")
    public ResponseEntity<AppOrder> updateCustomer(@PathVariable Long id, @RequestBody AppOrder publisherDetails) {
        Optional<AppOrder> publisher = orderService.findById(id);
        if (publisher.isPresent()) {
            AppOrder updatedPublisher = publisher.get();
            updatedPublisher.setCustomer(publisherDetails.getCustomer());
            updatedPublisher.setCoupon(publisherDetails.getCoupon());
            updatedPublisher.setOrderItems(publisherDetails.getOrderItems());
            updatedPublisher.setStatus(publisherDetails.getStatus());
            updatedPublisher.setBookingTime(publisherDetails.getBookingTime());
            updatedPublisher.setCreate_at(publisherDetails.getCreate_at());
            updatedPublisher.setOriginalPrice(publisherDetails.getOriginalPrice());
            updatedPublisher.setTotalPrice(publisherDetails.getTotalPrice());
            updatedPublisher.setRestaurantTable(publisherDetails.getRestaurantTable());
            updatedPublisher.setPayment(publisherDetails.getPayment());
            updatedPublisher.setTotalDiscount(publisherDetails.getTotalDiscount());
            return ResponseEntity.ok(orderService.save(updatedPublisher));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCustomer(@PathVariable Long id) {
        Optional<AppOrder> publisher = orderService.findById(id);
        if (publisher.isPresent()) {
            orderService.deleteById(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
