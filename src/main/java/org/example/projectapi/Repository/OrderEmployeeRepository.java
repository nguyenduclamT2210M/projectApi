package org.example.projectapi.Repository;

import org.example.projectapi.model.OrderEmployee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderEmployeeRepository extends JpaRepository<OrderEmployee, Long> {
}
