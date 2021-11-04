package com.example.Ases.controller;

import com.example.Ases.model.Order;
import com.example.Ases.service.EmailService;
import com.example.Ases.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/order")
public class OrderController {
    @Autowired
    private OrderService orderService;
    @Autowired
    private EmailService emailService;

    @PostMapping("/create")
    public  Order create(@RequestBody Order order){
        return orderService.create(order);
    }
    @PutMapping("/update")
    public  Order update(@RequestBody Order order){
        return orderService.update(order);
    }
    @PostMapping("/mailSender/{id}")
    public void sendMail (@PathVariable Long id,@RequestBody String answer){
        emailService.sendSimpleMassage(id, answer);
    }
    @GetMapping("/read/{id}")
    public void readOrder(@PathVariable Long id){
        orderService.readOrder(id);
    }
    @GetMapping("/getAll")
    public List<Order> getAllOrders(){
        return orderService.getAllOrders();
    }
    @GetMapping("/getById/{id}")
    public Order gitOrderById (@PathVariable Long id){
        return orderService.getOrderById(id);
    }
    @DeleteMapping("/delete/{id}")
    public void deleteById(@PathVariable Long id){
        orderService.delete(id);
    }
}
