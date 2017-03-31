package org.agilecards.cli.commands;


import org.agilecards.configuration.AgileCardsConfiguration;

/**
 * CLI Config for the action "version"
 * Created by Beewy on 20/02/2017.
 */
public class VersionCommand extends AgileCardsCommand {

    /**
     * Show the specific usage for this action
     */
    public void showSpecificUsage() {
        super.showUsage(this.getName(),
                AgileCardsConfiguration.VERSION_USAGE);
    }

    @Override
    public String getName() {
        return AgileCardsConfiguration.VERSION_ACTION;
    }

}
