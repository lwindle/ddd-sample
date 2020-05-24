package com.lwindle.ddd.sample.domain.service;

import com.lwindle.ddd.sample.domain.entity.Order;
import javafx.scene.layout.VBox;

/**
 * Copyright: Copyright (c) 2019 lwindle
 *
 * @author lwindle
 * @description:
 * @version: V1.0.0
 * @date 2020-05-24 11:46
 */
public class OrderDomainService {

    public void placeOrder(Order order) {
        //compute 业务逻辑
        order.save();

    }
}
