package org.example.projectapi.model;

import jakarta.persistence.*;
import org.example.projectapi.Enum.Start;
import org.hibernate.sql.ast.tree.expression.Star;

import java.util.List;

@Entity
public class Rating {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false )
    private Start start;

    @Column(nullable = false )
    public String description;
    @Column(nullable = false )
    @OneToMany(fetch = FetchType.EAGER)
    private List<Customer> customer;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Start getStart() {
        return start;
    }

    public void setStart(Start start) {
        this.start = start;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Customer> getCustomer() {
        return customer;
    }

    public void setCustomer(List<Customer> customer) {
        this.customer = customer;
    }
}
