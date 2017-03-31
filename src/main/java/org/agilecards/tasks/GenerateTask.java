package org.agilecards.tasks;

import org.agilecards.configuration.AgileCardsConfiguration;
import org.agilecards.configuration.file.ConfigurationFile;
import org.agilecards.exceptions.AgileCardsApplicationException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by Beewy on 14/03/2017.
 */
public class GenerateTask implements AgileCardsTask {

    private static final Logger LOG = LoggerFactory.getLogger(GenerateTask.class);

    @Override
    public void execute() throws AgileCardsApplicationException {
        this.loadConfiguration();
        LOG.error("Action not implemented yet ....");
    }

    /**
     * Load the configuration file
     */
    private void loadConfiguration() throws AgileCardsApplicationException {
        LOG.debug("Loading the configuration file ...");
        ConfigurationFile configurationFile = AgileCardsConfiguration.loadConfigurationFile();
    }

}
