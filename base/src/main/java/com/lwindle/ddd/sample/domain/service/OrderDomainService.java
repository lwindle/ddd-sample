package com.lwindle.ddd.sample.domain.service;

import com.lwindle.ddd.sample.domain.entity.Order;
import com.lwindle.ddd.sample.domain.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Copyright: Copyright (c) 2019 lwindle
 *
 * @author lwindle
 * @description:
 * @version: V1.0.0
 * @date 2020-05-24 11:46
 */
public class OrderDomainService {
    @Autowired
    private OrderRepository orderRepository;

    public void placeOrder(Order order) {
        //compute 业务逻辑
        order.save();

    }
}
