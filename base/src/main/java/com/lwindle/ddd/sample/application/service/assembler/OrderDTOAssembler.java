package com.lwindle.ddd.sample.application.service.assembler;

import com.lwindle.ddd.sample.domain.entity.Order;
import com.lwindle.ddd.sample.other.OrderDTO;
import java.util.function.Function;

/**
 * Copyright: Copyright (c) 2019 lwindle
 *
 * @author lwindle
 * @description:
 * @version: V1.0.0
 * @date 2020-05-24 12:22
 */

public class OrderDTOAssembler implements Function<Order, OrderDTO> {

    @Override
    public OrderDTO apply(Order order) {
        return null;
    }
}
