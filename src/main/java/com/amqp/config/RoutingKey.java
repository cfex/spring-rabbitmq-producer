package com.amqp.config;

import lombok.Getter;

public enum RoutingKey {
    HEALTH_INFO("health-info"),
    BUSINESS_INFO("business-info");

    @Getter
    private final String value;

    RoutingKey(String value) {
        this.value = value;
    }
}
