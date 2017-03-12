package org.agilecards.cli;

import org.agilecards.configuration.AgileCardsConfiguration;
import org.agilecards.service.VersionService;
import org.agilecards.service.impl.VersionServiceImpl;

/**
 * Created by Beewy on 12/03/2017.
 */
public abstract class BaseManager {

    private final VersionService versionService;
    private final AgileCardsConfiguration applicationConfiguration;

    public BaseManager() {
        this.applicationConfiguration = new AgileCardsConfiguration();
        this.versionService = new VersionServiceImpl(applicationConfiguration);
    }

    public VersionService getVersionService() {
        return versionService;
    }

    public AgileCardsConfiguration getApplicationConfiguration() {
        return applicationConfiguration;
    }
}
