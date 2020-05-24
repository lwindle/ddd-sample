package com.lwindle.ddd.sample.domain.factory;

import com.lwindle.ddd.sample.application.service.vo.req.OrderReq;
import com.lwindle.ddd.sample.domain.dataObject.OrderDO;
import com.lwindle.ddd.sample.domain.entity.Order;
import org.springframework.beans.BeanUtils;

/**
 * Copyright: Copyright (c) 2019 lwindle
 *
 * @author lwindle
 * @description:
 * @version: V1.0.0
 * @date 2020-05-24 11:33
 */
public class OrderFactory {

    private OrderDO orderDO;

    public static Order create(OrderReq orderReq) {
        Order order = init();
//        BeanUtils.copyProperties();
        //copy property
        return order;
    }

    private static Order init() {
        //query from db
        return null;
    }
}
