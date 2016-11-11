package org.farrukh.experiments.spring.tx.dao;

import org.farrukh.experiments.spring.tx.dto.Order;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class OrderDaoImpl implements OrderDao {
    
    private final SessionFactory sessionFactory;
    
    @Autowired
    public OrderDaoImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void insert(Order order) {

    }

}
