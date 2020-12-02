package com.hotstrip.week7_work1.service;

import com.hotstrip.week7_work1.model.Order;

import java.util.Collection;

public interface OrderService {

    /**
     * insert batch
     * @param collection
     */
    void insertBatch(final Collection<Order> collection);
}
