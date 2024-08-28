package org.example.projectapi.model;

import jakarta.persistence.*;

import java.util.List;
import java.util.Set;

@Entity
public class Coupon {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false )
    private String name;
    private double discount;
    //    @ManyToOne(fetch = FetchType.EAGER,optional = false)
//    @JoinColumn(name = "order_id")
//    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "coupon")
//    private List<AppOrder> orders;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getDiscount() {
        return discount;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }

//    public List<AppOrder> getOrders() {
//        return orders;
//    }
//
//    public void setOrders(List<AppOrder> orders) {
//        this.orders = orders;
//    }
}
