package com.yeditepe.comp301.microservices.customer;

import org.springframework.amqp.core.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQConfiguration {
    @Value("${spring.rabbitmq.queue.name}")
    String queue;
    @Value("${spring.rabbitmq.exchange.name}")
    String exchange;
    @Value("${spring.rabbitmq.routing.key}")
    private String routingKey;

    public Queue queue(){
        return new Queue(queue);
    }

    public DirectExchange exchange(){
        return new DirectExchange(exchange);
    }

    public Binding binding(){
        return BindingBuilder
                .bind(queue())
                .to(exchange())
                .with(routingKey);
    }
}
