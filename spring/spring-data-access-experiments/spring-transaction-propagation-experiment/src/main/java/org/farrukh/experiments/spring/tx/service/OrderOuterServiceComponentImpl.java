package org.farrukh.experiments.spring.tx.service;

import org.farrukh.experiments.spring.tx.dao.OrderDao;
import org.farrukh.experiments.spring.tx.dto.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class OrderOuterServiceComponentImpl implements OrderOuterServiceComponent {

    private final OrderDao orderDao;

    private final SomeInnerServiceComponent innerServiceComponent;

    @Autowired
    public OrderOuterServiceComponentImpl(OrderDao orderDao, SomeInnerServiceComponent innerServiceComponent) {
        this.orderDao = orderDao;
        this.innerServiceComponent = innerServiceComponent;
    }

    @Transactional
    @Override
    public void save(Order order) {
        orderDao.insert(order);
        try {
            innerServiceComponent.testRequired();
        } catch (RuntimeException e) {
            // handle exception
        }
    }

    @Override
    public void saveNew(Order order) {
        orderDao.insert(order);
        try {
            innerServiceComponent.testRequiresNew();
        } catch (RuntimeException e) {
            // handle exception
        }
    }

}
