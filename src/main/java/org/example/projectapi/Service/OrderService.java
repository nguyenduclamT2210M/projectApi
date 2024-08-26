package org.example.projectapi.Service;

import org.example.projectapi.Repository.EmployeeRepository;
import org.example.projectapi.Repository.OrderRepository;
import org.example.projectapi.model.AppOrder;
import org.example.projectapi.model.Employee;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderService {
    private OrderRepository orderRepository;

    public List<AppOrder> findAll() {
        return orderRepository.findAll();
    }

    public Optional<AppOrder> findById(Long id) {
        return orderRepository.findById(id);
    }

    public AppOrder save(AppOrder customer) {
        return orderRepository.save(customer);
    }

    public void deleteById(Long id) {
        orderRepository.deleteById(id);
    }

}
