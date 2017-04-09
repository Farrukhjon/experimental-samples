package org.farrukh.experiments.spring.dao.impl;

import org.farrukh.experiments.spring.dao.OrderDao;
import org.farrukh.experiments.spring.model.Order;
import org.springframework.jdbc.core.JdbcTemplate;

public class OrderDaoImpl implements OrderDao {

    private JdbcTemplate jdbcTemplate;

    public OrderDaoImpl() {

    }

    public OrderDaoImpl(JdbcTemplate jdbcTemplate) {
        this.setJdbcTemplate(jdbcTemplate);
    }

    public void submit(Order order) {
        jdbcTemplate.execute("select * from regions");
    }

    public JdbcTemplate getJdbcTemplate() {
        return jdbcTemplate;
    }

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
    
    

}
