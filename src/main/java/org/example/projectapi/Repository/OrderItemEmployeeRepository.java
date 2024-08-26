package org.example.projectapi.Repository;

import org.example.projectapi.model.OrderItemEmployee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderItemEmployeeRepository extends JpaRepository<OrderItemEmployee, Long> {
}
