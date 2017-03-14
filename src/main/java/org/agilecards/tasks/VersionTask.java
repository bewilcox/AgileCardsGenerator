package org.agilecards.tasks;

import org.agilecards.configuration.AgileCardsConfiguration;

/**
 * Created by Beewy on 14/03/2017.
 */
public class VersionTask implements AgileCardsTask {

    @Override
    public void execute() {
        System.out.println(
                AgileCardsConfiguration.APP_NAME + " " +
                VersionTask.class.getPackage().getImplementationVersion());
    }

}
