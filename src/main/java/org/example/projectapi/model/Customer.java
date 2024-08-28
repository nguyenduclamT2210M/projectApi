package org.example.projectapi.model;

import jakarta.persistence.*;

import java.util.Date;
import java.util.Set;

@Entity
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false )
    private String name;
    @Column(nullable = false )
    private String phone;
    @Column(nullable = false )
    private Date birthday;
    @Column(nullable = false )
    private Date created_at;

//    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL,mappedBy = "customer")
//    private Set<AppOrder> orders;
//
//    public Set<AppOrder> getOrders() {
//        return orders;
//    }

//    public void setOrders(Set<AppOrder> orders) {
//        this.orders = orders;
//    }

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

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public Date getCreated_at() {
        return created_at;
    }

    public void setCreated_at(Date created_at) {
        this.created_at = created_at;
    }

}
