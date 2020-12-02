package com.hotstrip.week7_work1.service;

import com.hotstrip.week7_work1.mapper.OrderMapper;
import com.hotstrip.week7_work1.model.Order;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.sql.SQLDataException;
import java.sql.SQLException;
import java.util.Collection;

@Service
public class OrderServiceImpl implements OrderService {

    @Resource
    private OrderMapper orderMapper;

    @Override
    public void insertBatch(final Collection<Order> collection) {
        if (collection.size() <= 0) {
            // TODO...
            return;
        }
        if (orderMapper.insertBatch(collection) < 1) {
            throw new RuntimeException("insert batch error");
        }
    }
}
