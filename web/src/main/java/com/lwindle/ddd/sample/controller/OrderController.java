package com.lwindle.ddd.sample.controller;

import com.lwindle.ddd.sample.application.service.OrderAppService;
import com.lwindle.ddd.sample.application.service.vo.req.OrderReq;
import com.lwindle.ddd.sample.application.service.vo.resp.OrderResp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Copyright: Copyright (c) 2019 lwindle
 *
 * @author lwindle
 * @description:
 * @version: V1.0.0
 * @date 2020-05-24 10:58
 */
@RestController
@RequestMapping
public class OrderController {

    @Autowired
    private OrderAppService orderAppService;

    public OrderResp placeOrder(OrderReq orderReq) {

        return orderAppService.placeOrder(orderReq);
    }


}
