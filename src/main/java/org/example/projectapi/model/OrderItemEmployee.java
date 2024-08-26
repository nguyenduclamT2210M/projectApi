package org.example.projectapi.model;

import jakarta.persistence.*;

@Entity
public class OrderItemEmployee {
    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    private int id;
    @ManyToOne(fetch = FetchType.EAGER)
    private OrderItem orderId;
    @ManyToOne(fetch = FetchType.EAGER)
    private Employee employeeId;
    @Enumerated(EnumType.STRING)
    @Column(nullable = false )
    private Status status;

    public enum Status {
        Done,Wait
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public OrderItem getOrderId() {
        return orderId;
    }

    public void setOrderId(OrderItem orderId) {
        this.orderId = orderId;
    }

    public Employee getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Employee employeeId) {
        this.employeeId = employeeId;
    }


}
