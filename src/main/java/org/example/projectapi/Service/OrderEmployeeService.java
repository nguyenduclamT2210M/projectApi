package org.example.projectapi.Service;

import org.example.projectapi.Repository.OrderEmployeeRepository;
import org.example.projectapi.model.OrderEmployee;
import org.example.projectapi.model.OrderItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderEmployeeService {
    @Autowired
    private OrderEmployeeRepository orderEmployeeRepository;

    public List<OrderEmployee> findAll() {
        return orderEmployeeRepository.findAll();
    }

    public Optional<OrderEmployee> findById(Long id) {
        return orderEmployeeRepository.findById(id);
    }

    public OrderEmployee save(OrderEmployee customer) {
        return orderEmployeeRepository.save(customer);
    }

    public void deleteById(Long id) {
        orderEmployeeRepository.deleteById(id);
    }
}
