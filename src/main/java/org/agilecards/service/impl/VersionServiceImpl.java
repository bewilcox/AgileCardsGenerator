package org.agilecards.service.impl;

import org.agilecards.configuration.AgileCardsConfiguration;
import org.agilecards.service.VersionService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by Beewy on 12/03/2017.
 */
public class VersionServiceImpl extends BaseService implements VersionService {

    private static final Logger LOG = LoggerFactory.getLogger(VersionService.class);

    public VersionServiceImpl(AgileCardsConfiguration configuration) {
        super(configuration);
    }

    /**
     * Return the application version.
     * @return
     */
    public String getApplicationVersion(){
        return this.configuration.getApplicationVersion();
    }

}
