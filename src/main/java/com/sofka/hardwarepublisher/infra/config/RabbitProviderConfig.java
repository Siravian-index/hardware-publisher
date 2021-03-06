package com.sofka.hardwarepublisher.infra.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

public class RabbitProviderConfig {
    public final static String EXCHANGE = "hardware";


    //    Provider
    public final static String CREATE_PROVIDER_QUEUE = "action.create.provider";
    public final static String CREATE_PROVIDER_ROUTING_KEY = "publish.provider.create";


    public TopicExchange getTopicExchange() {
        return new TopicExchange(EXCHANGE);
    }

    public Queue getProviderQueue() {
        return new Queue(CREATE_PROVIDER_QUEUE);
    }

    public Binding bindToCreateProvider() {
        return BindingBuilder.bind(getProviderQueue()).to(getTopicExchange()).with(CREATE_PROVIDER_ROUTING_KEY);
    }
}
