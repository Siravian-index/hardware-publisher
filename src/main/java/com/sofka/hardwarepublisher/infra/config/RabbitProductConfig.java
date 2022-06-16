package com.sofka.hardwarepublisher.infra.config;

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

}
