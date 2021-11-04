package com.example.Ases.service;

import com.example.Ases.model.Order;

import javax.transaction.Transactional;

public interface EmailService {
    void sendSimpleMassage(Long id , String answer);

    @Transactional
    Order readOrders(Long id, String answer);
}
