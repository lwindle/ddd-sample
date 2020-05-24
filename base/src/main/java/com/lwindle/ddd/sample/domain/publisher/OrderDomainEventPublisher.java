package com.lwindle.ddd.sample.domain.publisher;

import com.lwindle.ddd.sample.domain.DomainEventBus;
import com.lwindle.ddd.sample.domain.entity.Order;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Copyright: Copyright (c) 2019 lwindle
 *
 * @author lwindle
 * @description:
 * @version: V1.0.0
 * @date 2020-05-24 12:01
 */
public class OrderDomainEventPublisher implements DomainEventPublisher<Order> {

    @Autowired
    private DomainEventBus domainEventBus;


    @Override
    public void publish(Order event) {
        //组装参数
        domainEventBus.send(convert(event));
    }

    private Object convert(Order event) {
        return null;
    }
}
