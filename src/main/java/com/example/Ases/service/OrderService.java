package com.example.Ases.service;

import com.example.Ases.model.Order;

import java.util.List;

public interface OrderService {
    Order create (Order order);
    Order update (Order order);
    void readOrder (Long id);
    List<Order> getAllOrders ();
    Order getOrderById (Long id);
    void delete (Long id);
}
