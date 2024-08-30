package org.example.projectapi.Repository;

import org.example.projectapi.model.AppOrder;
import org.example.projectapi.model.Rating;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface OrderRepository extends JpaRepository<AppOrder,Long> {
    @Query("SELECT b.billNumber FROM AppOrder b ORDER BY b.id DESC")
    List<String> findLastBillNumber();
}
