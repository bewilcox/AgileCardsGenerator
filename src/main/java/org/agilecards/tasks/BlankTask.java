package org.agilecards.tasks;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by Beewy on 14/03/2017.
 */
public class BlankTask implements AgileCardsTask {

    private static final Logger LOG = LoggerFactory.getLogger(BlankTask.class);

    @Override
    public void execute() {
        LOG.error("Action not implemented yet ....");
    }

}
