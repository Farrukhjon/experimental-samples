package org.farrukh.experiments.spring;

import org.farrukh.experiments.spring.dao.OrderDao;
import org.farrukh.experiments.spring.model.Order;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

    public static void main(String[] args) {
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("app-context.xml");
        OrderDao order = applicationContext.getBean(OrderDao.class);
        order.submit(new Order());
       
    }

}
