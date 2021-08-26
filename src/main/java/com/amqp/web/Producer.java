package com.amqp.web;

import com.amqp.payload.MessagePayload;
import com.amqp.service.MessageQueueService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RequiredArgsConstructor
@RestController
public class Producer {

    private final MessageQueueService messageQueueService;

    @PostMapping("/exchange")
    public String exchange(@RequestParam("exchange") String exchange,
                           @RequestParam(value = "routingKey") String routingKey,
                           @RequestBody MessagePayload payload) {

        return messageQueueService.produce(exchange, routingKey, payload);
    }
}
