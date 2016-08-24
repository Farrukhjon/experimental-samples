/*
 * Copyright (C) F.D. Sattorov Systems, Inc - All Rights Reserved
 * Unauthorized copying of this file, via any medium is strictly prohibited
 * Proprietary and confidential
 * Written by F.D. Sattorov <farrukhjon.sattorov@gmail.com>, May 2016.
 */

package com.farrukh.example.spring.jooq.service;

import com.farrukh.example.spring.jooq.domain.Order;

import java.util.List;

public interface CRUD {

    List<Order> getOrdersByCustomer(long customerId);

}
