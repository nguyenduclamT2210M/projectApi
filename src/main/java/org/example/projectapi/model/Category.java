package org.example.projectapi.model;

import jakarta.persistence.*;

import java.util.List;
import java.util.Set;

@Entity
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false )
    private String name;

//   @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL,mappedBy = "category")
//   private Set<Dish> dishes;

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

//   public Set<Dish> getDishes() {
//        return dishes;
//    }
//
//    public void setDishes(Set<Dish> dishes) {
//        this.dishes = dishes;
//    }

}
