package com.sofka.hardwarepublisher.infra.config;

import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitProductConfig {
    public final static String EXCHANGE = "hardware";

//    product
    public final static String CREATE_PRODUCT_QUEUE = "action.create.product";
    public final static String CREATE_PRODUCT_ROUTING_KEY = "publish.product.create";


    @Bean
    public TopicExchange getTopicExchange() {
        return new TopicExchange(EXCHANGE);
    }

    @Bean
    public Queue getQueue() {
        return new Queue(CREATE_PRODUCT_QUEUE);
    }

    @Bean
    public BindingBuilder bindToCreateProduct() {
        return null;
//        return BindingBuilder.bind(getQueue()).to(getTopicExchange()).with(CREATE_PRODUCT_ROUTING_KEY);
    }



}
