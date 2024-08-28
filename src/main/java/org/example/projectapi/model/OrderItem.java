package org.example.projectapi.model;


import jakarta.persistence.*;

@Entity
public class OrderItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.EAGER,optional = false)
    @JoinColumn(name = "order_id")
    private AppOrder order;

    @ManyToOne(fetch = FetchType.EAGER,optional = false)
    @JoinColumn(name = "dish_id")
    private Dish dish;

    @Column(nullable = false )
    private int quantity;
    @Column(nullable = false )
    private Double price;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public AppOrder getOrder() {
        return order;
    }

    public void setOrder(AppOrder order) {
        this.order = order;
    }

    public Dish getDish() {
        return dish;
    }

    public void setDish(Dish dish) {
        this.dish = dish;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

}
