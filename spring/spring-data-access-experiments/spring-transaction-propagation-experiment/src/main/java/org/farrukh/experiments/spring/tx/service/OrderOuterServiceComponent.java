package org.farrukh.experiments.spring.tx.service;

import org.farrukh.experiments.spring.tx.dto.Order;

public interface OrderOuterServiceComponent {
    
    void save(final Order order);

    void saveNew(final Order order);

}
