package com.amqp.config;

import lombok.Getter;

public enum QueueRouter {
    HEALTH_QUEUE("health-queue"),
    BUSINESS_QUEUE("business-queue");

    @Getter
    private final String value;

    QueueRouter(String value) {
        this.value = value;
    }
}
