package org.example.projectapi.Service;

import jakarta.transaction.Transactional;
import org.example.projectapi.Repository.EmployeeRepository;
import org.example.projectapi.Repository.OrderRepository;
import org.example.projectapi.model.AppOrder;
import org.example.projectapi.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderService {
    @Autowired
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
    @Transactional
    public String createNextBillNumber() {
        List<String> lastBillNumList = orderRepository.findLastBillNumber();
        String lastBillNum = lastBillNumList.isEmpty() ? null : lastBillNumList.get(0);

        String nextBillNum;
        if (lastBillNum == null || lastBillNum.isEmpty()) {
            nextBillNum = "B000000001";
        } else {
            String numberPart = lastBillNum.substring(1);
            int lastNumber = Integer.parseInt(numberPart);
            nextBillNum = "B" + String.format("%09d", ++lastNumber);
        }

        return nextBillNum;
    }
}
