package org.example.projectapi.model;

import jakarta.persistence.*;

@Entity
public class OrderEmployee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @ManyToOne(fetch = FetchType.EAGER,optional = false)
    @JoinColumn(name = "employee_id")
    private Employee employee;

    @ManyToOne(fetch = FetchType.EAGER,optional = false)
    @JoinColumn(name = "order_id")
    private AppOrder order;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public AppOrder getOrder() {
        return order;
    }

    public void setOrder(AppOrder order) {
        this.order = order;
    }
}
