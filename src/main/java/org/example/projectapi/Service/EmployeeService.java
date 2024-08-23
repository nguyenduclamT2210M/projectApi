package org.example.projectapi.Service;

import org.example.projectapi.Repository.DishRepository;
import org.example.projectapi.Repository.EmployeeRepository;
import org.example.projectapi.model.Dish;
import org.example.projectapi.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {
@Autowired
private EmployeeRepository employeeRepository;

    public List<Employee> findAll() {
        return employeeRepository.findAll();
    }

    public Optional<Employee> findById(Long id) {
        return employeeRepository.findById(id);
    }

    public Employee save(Employee customer) {
        return employeeRepository.save(customer);
    }

    public void deleteById(Long id) {
        employeeRepository.deleteById(id);
    }
}
