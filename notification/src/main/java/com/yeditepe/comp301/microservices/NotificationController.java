package com.yeditepe.comp301.microservices;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/notification")
public class NotificationController {

    @GetMapping("/new/{message}")
    public String newNotification(@PathVariable("message")String message){
        return null;
    }

    @RabbitListener(queues = {"firstqueue"})
    public void getMessage(String message){
        System.out.println(" a new message come to queue:"+message.toUpperCase());
    }
}
