package org.example.projectapi.Service;

import org.example.projectapi.Repository.OrderItemEmployeeRepository;
import org.example.projectapi.model.OrderItem;
import org.example.projectapi.model.OrderItemEmployee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderItemEmployeeService {
    @Autowired
    private OrderItemEmployeeRepository orderItemEmployeeRepository;
    public List<OrderItemEmployee> findAll() {
        return orderItemEmployeeRepository.findAll();
    }

    public Optional<OrderItemEmployee> findById(Long id) {
        return orderItemEmployeeRepository.findById(id);
    }

    public OrderItemEmployee save(OrderItemEmployee customer) {
        return orderItemEmployeeRepository.save(customer);
    }


    public void deleteById(Long id) {
        orderItemEmployeeRepository.deleteById(id);
    }
}
