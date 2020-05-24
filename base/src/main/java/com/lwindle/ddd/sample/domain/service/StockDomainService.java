package com.lwindle.ddd.sample.domain.service;

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

    public void decrease() {
        stockFacade.decrease();
    }


    private interface StockFacade {
        void decrease();
    }
}
