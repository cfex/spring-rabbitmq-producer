package com.amqp.service;

import com.amqp.payload.MessagePayload;

public interface MessageQueueService {
     String produce(String exchange, String routingKey, MessagePayload payload);
}
