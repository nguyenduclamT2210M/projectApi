package org.example.projectapi.Repository;

import org.example.projectapi.model.AppOrder;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<AppOrder, Long> {
}
