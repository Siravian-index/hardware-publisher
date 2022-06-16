package com.sofka.hardwarepublisher.infra.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

public class RabbitProductConfig {
    public final static String EXCHANGE = "hardware";

//    product
    public final static String CREATE_PRODUCT_QUEUE = "action.create.product";
    public final static String CREATE_PRODUCT_ROUTING_KEY = "publish.product.create";



    public TopicExchange getTopicExchange() {
        return new TopicExchange(EXCHANGE);
    }

    public Queue getProductQueue() {
        return new Queue(CREATE_PRODUCT_QUEUE);
    }

    public Binding bindToCreateProduct() {
        return BindingBuilder.bind(getProductQueue()).to(getTopicExchange()).with(CREATE_PRODUCT_ROUTING_KEY);
    }


}
