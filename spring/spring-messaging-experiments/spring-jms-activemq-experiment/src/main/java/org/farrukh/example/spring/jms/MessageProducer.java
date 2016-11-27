/*
 * Copyright (C) F.D. Sattorov Systems, Inc - All Rights Reserved
 * Unauthorized copying of this file, via any medium is strictly prohibited
 * Proprietary and confidential
 * Written by F.D. Sattorov <farrukhjon.sattorov@gmail.com>, May 2016.
 */

package org.farrukh.example.spring.jms;

import org.springframework.boot.CommandLineRunner;
import org.springframework.jms.core.JmsMessagingTemplate;

import javax.jms.Queue;

public class MessageProducer implements CommandLineRunner {

    private final JmsMessagingTemplate jmsMessagingTemplate;

    private final Queue queue;

    public MessageProducer(final JmsMessagingTemplate jmsMessagingTemplate, final Queue queue) {
        this.jmsMessagingTemplate = jmsMessagingTemplate;
        this.queue = queue;
    }


    @Override
    public void run(final String... args) throws Exception {
        for (String arg : args) {
            jmsMessagingTemplate.convertAndSend(this.queue, arg);
        }
    }

}
