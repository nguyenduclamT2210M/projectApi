package org.example.projectapi.model;

import jakarta.persistence.*;
import org.example.projectapi.Enum.StatusTable;

import java.util.List;

@Entity
public class RestaurantTable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false )
    private String qrCode;
    @Column(nullable = false )
    private int chairs;
    @Enumerated(EnumType.STRING)
    @Column(nullable = false )
    private StatusTable status;

//    @OneToMany(fetch = FetchType.LAZY,cascade = CascadeType.ALL,mappedBy = "restaurantTable")
//    private List<AppOrder> order;




    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getQrCode() {
        return qrCode;
    }

    public void setQrCode(String qrCode) {
        this.qrCode = qrCode;
    }

    public int getChairs() {
        return chairs;
    }

    public void setChairs(int chairs) {
        this.chairs = chairs;
    }

    public StatusTable getStatus() {
        return status;
    }

    public void setStatus(StatusTable status) {
        this.status = status;
    }

//    public List<AppOrder> getOrder() {
//        return order;
//    }
//
//    public void setOrder(List<AppOrder> order) {
//        this.order = order;
//    }
}
