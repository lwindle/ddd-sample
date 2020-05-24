package com.lwindle.ddd.sample.application.service;

import com.lwindle.ddd.sample.application.service.vo.req.OrderReq;
import com.lwindle.ddd.sample.application.service.vo.resp.OrderResp;
import com.lwindle.ddd.sample.domain.entity.Order;
import com.lwindle.ddd.sample.domain.factory.OrderFactory;
import com.lwindle.ddd.sample.domain.publisher.OrderDomainEventPublisher;
import com.lwindle.ddd.sample.domain.service.OrderDomainService;
import com.lwindle.ddd.sample.domain.service.StockDomainService;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Copyright: Copyright (c) 2019 lwindle
 *
 * @author lwindle
 * @description:
 * @version: V1.0.0
 * @date 2020-05-24 10:53
 */
public class OrderAppService {

    @Autowired
    private OrderDomainService orderDomainService;

    @Autowired
    private StockDomainService stockDomainService;

    @Autowired
    private OrderDomainEventPublisher orderDomainEventPublisher;

    public OrderResp placeOrder(OrderReq orderReq) {
        Order order = OrderFactory.create(orderReq);
        //1.普通校验
        //2.数据库校验
        order.placeOrderCheck();

        //
        //3.修改订单状态
        //
        //4.计算入库
        orderDomainService.placeOrder(order);

        //
        //5.调取库存服务接口
        stockDomainService.decrease();
        //
        //6.短信事件
        orderDomainEventPublisher.publish(order);
        return new OrderResp();
    }
}
