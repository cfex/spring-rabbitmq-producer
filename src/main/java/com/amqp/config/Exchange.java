package com.amqp.config;

import lombok.Getter;

public enum Exchange {
    DIRECT_EXCHANGE("amqp.news.direct-exchange"),
    TOPIC_EXCHANGE("amqp.news.topic-exchange"),
    FANOUT_EXCHANGE("amqp.news.fanout-exchange");

    @Getter
    private final String value;

    Exchange(String value) {
        this.value = value;
    }
}
