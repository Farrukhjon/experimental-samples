/*
 * Copyright (C) F.D. Sattorov Systems, Inc - All Rights Reserved
 * Unauthorized copying of this file, via any medium is strictly prohibited
 * Proprietary and confidential
 * Written by F.D. Sattorov <farrukhjon.sattorov@gmail.com>, May 2016.
 */

package org.farrukh.examples.kafka;

import org.apache.kafka.clients.producer.KafkaProducer;

import java.util.Properties;

public class KafkaProducerDemo {

    public static void main(String[] args) {
        Properties properties = new Properties();
        KafkaProducer producer = new KafkaProducer(properties);
    }

}
