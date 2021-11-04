package com.example.Ases.service;

import com.example.Ases.model.Order;
import com.example.Ases.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.Properties;

@Component
@Service
public class EmailServiceImpl implements EmailService{
    @Autowired
    private OrderRepository orderRepository;
    @Autowired
    private JavaMailSender mailSender;

    @Bean
    public JavaMailSender getJavaMailSender(){
        JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
        mailSender.setHost("smtp.gmail.com");
        mailSender.setPort(587);

        mailSender.setUsername("ee79334@gmail.com");
        mailSender.setPassword("zxcvjkl;asdf144");

        Properties props = mailSender.getJavaMailProperties();
        props.put("mail.transport.protocol","smtp");
        props.put("mail.smtp.auth","true");
        props.put("mail.smtp.starttls.enable","true");
        props.put("mail.debug","true");

        return mailSender;
    }

    @Override
    public void sendSimpleMassage(Long id, String answer) {
        SimpleMailMessage massage = new SimpleMailMessage();
        massage.setTo(readOrders(id, answer).getEmail());
        massage.setSubject("You ticket and regulations");
        mailSender.send(massage);
    }

    @Override
    public Order readOrders(Long id, String answer) {
        Order order = orderRepository.findById(id).get();
        order.setRead(true);
        order.setAnswer(answer);
        orderRepository.save(order);
        return order;
    }
}