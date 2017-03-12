package org.agilecards.service.impl;

import org.agilecards.configuration.AgileCardsConfiguration;

/**
 * Created by Beewy on 12/03/2017.
 */
public class BaseService {

    AgileCardsConfiguration configuration;

    public BaseService(AgileCardsConfiguration configuration) {
        this.configuration = configuration;
    }

}
