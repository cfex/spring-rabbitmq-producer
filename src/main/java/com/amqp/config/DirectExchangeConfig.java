package com.amqp.config;

import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DirectExchangeConfig {

    @Bean
    public Queue healthQueue() {
        return new Queue(QueueRouter.HEALTH_QUEUE.getValue(), false);
    }

    @Bean
    public Queue businessQueue() {
        return new Queue(QueueRouter.BUSINESS_QUEUE.getValue(), false);
    }

    @Bean
    public DirectExchange exchange() {
        return new DirectExchange(Exchange.DIRECT_EXCHANGE.getValue());
    }

    @Bean
    public Binding healthBinding(Queue healthQueue, DirectExchange exchange) {
        return BindingBuilder
                .bind(healthQueue)
                .to(exchange)
                .with(RoutingKey.HEALTH_INFO.getValue());
    }

    @Bean
    public Binding businessBinding(Queue businessQueue, DirectExchange exchange) {
        return BindingBuilder
                .bind(businessQueue)
                .to(exchange)
                .with(RoutingKey.BUSINESS_INFO.getValue());
    }

    @Bean
    public MessageConverter messageConverter() {
        return new Jackson2JsonMessageConverter();
    }

    @Bean
    public AmqpTemplate template(ConnectionFactory connectionFactory) {
        RabbitTemplate template = new RabbitTemplate(connectionFactory);
        template.setMessageConverter(messageConverter());
        return template;
    }
}
