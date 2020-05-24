package com.lwindle.ddd.sample.domain.service;

import com.lwindle.ddd.sample.application.service.assembler.OrderDTOAssembler;
import com.lwindle.ddd.sample.domain.entity.Order;
import com.lwindle.ddd.sample.other.StockFacade;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Copyright: Copyright (c) 2019 lwindle
 *
 * @author lwindle
 * @description:
 * @version: V1.0.0
 * @date 2020-05-24 12:11
 */
public class StockDomainService {

    @Autowired
    private StockFacade stockFacade;

    @Autowired
    private OrderDTOAssembler orderDTOAssembler;

    public void decrease(Order order) {
        stockFacade.decrease(orderDTOAssembler.apply(order));
    }

}
