package com.ecommerce.orderservice.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Table(name = "orders")
public class Order implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int productId;
    private int quantity;
    @Enumerated(EnumType.STRING)
    private TypeModalite typeModalite;
    @Temporal(TemporalType.DATE)
    Date orderDate;
    String emailUser;
    private Boolean orderStatus;
    private String deliveryAddress;
    private float amount;

    public Order(int quantity, TypeModalite typeModalite, Date orderDate, String emailUser, Boolean orderStatus, String deliveryAddress, float amount) {
        this.quantity = quantity;
        this.typeModalite = typeModalite;
        this.orderDate = orderDate;
        this.emailUser = emailUser;
        this.orderStatus = orderStatus;
        this.deliveryAddress = deliveryAddress;
        this.amount = amount;
    }

    public Order() {
        super();
    }

    public long getProductId() {
        return productId;
    }


    public int getQuantity() {
        return quantity;
    }

    public Order setQuantity(int quantity) {
        this.quantity = quantity;
        return this;
    }

    public TypeModalite getTypeModalite() {
        return typeModalite;
    }

    public Order setTypeModalite(TypeModalite typeModalite) {
        this.typeModalite = typeModalite;
        return this;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public Order setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
        return this;
    }

    public String getEmailUser() {
        return emailUser;
    }

    public Order setEmailUser(String emailUser) {
        this.emailUser = emailUser;
        return this;
    }

    public Boolean getOrderStatus() {
        return orderStatus;
    }

    public Order setOrderStatus(Boolean orderStatus) {
        this.orderStatus = orderStatus;
        return this;
    }

    public String getDeliveryAddress() {
        return deliveryAddress;
    }

    public Order setDeliveryAddress(String deliveryAddress) {
        this.deliveryAddress = deliveryAddress;
        return this;
    }

    public float getAmount() {
        return amount;
    }

    public Order setAmount(float amount) {
        this.amount = amount;
        return this;
    }

    public void setProductId(int id) {
    }
}






