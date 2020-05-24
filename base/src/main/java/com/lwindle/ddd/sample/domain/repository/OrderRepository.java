package com.lwindle.ddd.sample.domain.repository;

import com.lwindle.ddd.sample.domain.repository.dao.OrderDao;
import com.lwindle.ddd.sample.other.OrderDTO;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Copyright: Copyright (c) 2019 lwindle
 *
 * @author lwindle
 * @description:
 * @version: V1.0.0
 * @date 2020-05-24 12:30
 */
public class OrderRepository {

    @Autowired
    private OrderDao orderDao;


}
