package org.agilecards.cli.commands;

import org.agilecards.configuration.AgileCardsConfiguration;

/**
 * Created by Beewy on 22/02/2017.
 */
public class InitCommand extends AgileCardsCommand {

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
