package org.farrukh.experiments.spring.tx.dao;

import static java.sql.Types.DOUBLE;

import org.farrukh.experiments.spring.tx.dto.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreatorFactory;
import org.springframework.stereotype.Component;

@Component
public class OrderDaoImpl implements OrderDao {
    
    private final JdbcTemplate jdbcTemplate;
    
    @Autowired
    public OrderDaoImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public void insert(Order order) {
        Number[] params = new Number[]{2.1};
        String sql = "insert into orders(summa) values(?)";
        PreparedStatementCreatorFactory prepStatCreatorFactory = new PreparedStatementCreatorFactory(sql, DOUBLE);
        jdbcTemplate.update(prepStatCreatorFactory.newPreparedStatementCreator(params));
    }

}
