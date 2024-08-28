package org.example.projectapi.model;

import jakarta.persistence.*;
import org.example.projectapi.Enum.StatusOrderEmployee;

@Entity
public class OrderItemEmployee {
    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    private int id;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "order_item_id", nullable = false)
    private OrderItem orderItem;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "employee_id", nullable = false)
    private Employee employee;
    @Enumerated(EnumType.STRING)
    @Column(nullable = false )
    private StatusOrderEmployee status;




    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public OrderItem getOrderItem() {
        return orderItem;
    }

    public void setOrderItem(OrderItem orderItem) {
        this.orderItem = orderItem;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public StatusOrderEmployee getStatus() {
        return status;
    }

    public void setStatus(StatusOrderEmployee status) {
        this.status = status;
    }
}
