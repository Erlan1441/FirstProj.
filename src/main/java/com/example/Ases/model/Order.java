package com.example.Ases.model;

import javax.persistence.*;

@Entity
@Table( name = "order_1")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "order")
    private Order order;

    public Order() {
    }

    public Order(Long id, Order order) {
        this.id = id;
        this.order = order;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", order=" + order +
                '}';
    }

    public void setRead(boolean b) {
    }

    public void setAnswer(String answer) {
    }

    public String getEmail() {
    }
}
