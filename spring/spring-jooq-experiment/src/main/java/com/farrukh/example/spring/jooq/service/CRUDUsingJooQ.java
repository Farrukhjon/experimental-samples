/*
 * Copyright (C) F.D. Sattorov Systems, Inc - All Rights Reserved
 * Unauthorized copying of this file, via any medium is strictly prohibited
 * Proprietary and confidential
 * Written by F.D. Sattorov <farrukhjon.sattorov@gmail.com>, May 2016.
 */

package com.farrukh.example.spring.jooq.service;

import com.farrukh.example.spring.jooq.domain.Order;
import org.jooq.DSLContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CRUDUsingJooQ implements CRUD {

    private final DSLContext create;

    @Autowired
    public CRUDUsingJooQ(final DSLContext create) {
        this.create = create;
    }

    @Override
    public List<Order> getOrdersByCustomer(final long customerId) {
        return null;
    }
}
