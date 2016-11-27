/*
 * Copyright (C) F.D. Sattorov Systems, Inc - All Rights Reserved
 * Unauthorized copying of this file, via any medium is strictly prohibited
 * Proprietary and confidential
 * Written by F.D. Sattorov <farrukhjon.sattorov@gmail.com>, May 2016.
 */

package org.farrukh.example.spring.jms;

import org.apache.activemq.command.ActiveMQQueue;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.jms.annotation.EnableJms;
import org.springframework.jms.core.JmsMessagingTemplate;

import javax.jms.Queue;

@EnableJms
@EnableConfigurationProperties(AppProperties.class)
@SpringBootApplication
public class Application {

    @Bean
    public Queue queue(AppProperties properties) {
        return new ActiveMQQueue(properties.getQueueName());
    }

    @Bean
    public MessageProducer messageProducer(final JmsMessagingTemplate jmsMessagingTemplate, final Queue queue) {
        return new MessageProducer(jmsMessagingTemplate, queue);
    }

    @Bean
    public MessageConsumer messageConsumer() {
        return new MessageConsumer();
    }

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

}
