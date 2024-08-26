package org.example.projectapi.Service;

import org.example.projectapi.Repository.EmployeeRepository;
import org.example.projectapi.Repository.OrderItemRepository;
import org.example.projectapi.model.Employee;
import org.example.projectapi.model.OrderItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderItemService {
    @Autowired
    private OrderItemRepository orderItemRepository;

    public List<OrderItem> findAll() {
        return orderItemRepository.findAll();
    }

    public Optional<OrderItem> findById(Long id) {
        return orderItemRepository.findById(id);
    }

    public OrderItem save(OrderItem customer) {
        return orderItemRepository.save(customer);
    }

    public void deleteById(Long id) {
        orderItemRepository.deleteById(id);
    }

}
