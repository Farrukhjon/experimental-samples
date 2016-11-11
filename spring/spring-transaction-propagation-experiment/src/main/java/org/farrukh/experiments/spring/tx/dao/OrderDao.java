package org.farrukh.experiments.spring.tx.dao;

import org.farrukh.experiments.spring.tx.dto.Order;

public interface OrderDao {
    
    void insert(final Order order);

}
