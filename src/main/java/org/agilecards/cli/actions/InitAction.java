package org.agilecards.cli.actions;

import org.agilecards.configuration.AgileCardsConfiguration;

/**
 * Created by Beewy on 22/02/2017.
 */
public class InitAction extends AgileCardsAction {

    /**
     * Show the specific usage for this action
     */
    public void showSpecificUsage() {
        super.showUsage(this.getName(),AgileCardsConfiguration.INIT_USAGE);
    }

    @Override
    public String getName() {
        return AgileCardsConfiguration.INIT_ACTION;
    }

}
