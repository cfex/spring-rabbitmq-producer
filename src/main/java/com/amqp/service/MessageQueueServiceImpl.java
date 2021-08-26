package com.amqp.service;

import com.amqp.payload.MessagePayload;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.UUID;

@Slf4j
@RequiredArgsConstructor
@Service
public class MessageQueueServiceImpl implements MessageQueueService {

    private final AmqpTemplate template;

    @Override
    public String produce(String exchange, String routingKey, MessagePayload payload) {
        payload.setId(UUID.randomUUID().toString());
        payload.setDate(new Date());
        log.info("Sending message with ID {} to {}", payload.getId(), exchange);
        template.convertAndSend(exchange, routingKey, payload);

        return "Message successfully send to " + exchange;
    }
}
