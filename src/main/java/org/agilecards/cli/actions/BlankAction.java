package org.agilecards.cli.actions;

import org.agilecards.configuration.AgileCardsConfiguration;

/**
 * Created by Beewy on 22/02/2017.
 */
public class BlankAction extends AgileCardsAction {

    /**
     * Show the specific usage for this action
     */
    public void showSpecificUsage() {
        super.showUsage(AgileCardsConfiguration.BLANK_ACTION,
                AgileCardsConfiguration.BLANK_USAGE);
    }

}
