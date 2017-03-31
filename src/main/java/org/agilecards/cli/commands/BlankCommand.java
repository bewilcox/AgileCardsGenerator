package org.agilecards.cli.commands;

import org.agilecards.configuration.AgileCardsConfiguration;

/**
 * Created by Beewy on 22/02/2017.
 */
public class BlankCommand extends AgileCardsCommand {

    /**
     * Show the specific usage for this action
     */
    public void showSpecificUsage() {
        super.showUsage(this.getName(), AgileCardsConfiguration.BLANK_USAGE);
    }

    @Override
    public String getName() {
        return AgileCardsConfiguration.BLANK_ACTION;
    }

}
