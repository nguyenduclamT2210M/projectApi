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
    public List<AppOrder> getAllOrder() {
        return orderService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<AppOrder> getOrderById(@PathVariable Long id) {
        Optional<AppOrder> publisher = orderService.findById(id);
        return publisher.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public AppOrder createOrder(@RequestBody AppOrder order) {
        AppOrder newOrder = new AppOrder();
        newOrder.setBillNumber(orderService.createNextBillNumber());
        newOrder.setPayment(order.getPayment());
        newOrder.setStatus(order.getStatus());
        newOrder.setCreate_at(order.getCreate_at());
        newOrder.setRestaurantTable(order.getRestaurantTable());
        newOrder.setOriginalPrice(order.getOriginalPrice());
        newOrder.setTotalPrice(order.getTotalPrice());
        newOrder.setCoupon(order.getCoupon());
        newOrder.setOriginalPrice(order.getOriginalPrice());
        newOrder.setBookingTime(order.getBookingTime());
        return orderService.save(newOrder);
    }

    @PutMapping("/{id}")
    public ResponseEntity<AppOrder> updateOrder(@PathVariable Long id, @RequestBody AppOrder publisherDetails) {
        Optional<AppOrder> publisher = orderService.findById(id);
        if (publisher.isPresent()) {
            AppOrder updatedPublisher = publisher.get();
            updatedPublisher.setCustomer(publisherDetails.getCustomer());
            updatedPublisher.setCoupon(publisherDetails.getCoupon());
//            updatedPublisher.setOrderItems(publisherDetails.getOrderItems());
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
    public ResponseEntity<Void> deleteOrder(@PathVariable Long id) {
        Optional<AppOrder> publisher = orderService.findById(id);
        if (publisher.isPresent()) {
            orderService.deleteById(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
