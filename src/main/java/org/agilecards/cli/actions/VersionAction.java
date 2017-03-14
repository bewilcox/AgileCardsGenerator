package org.agilecards.cli.actions;


import org.agilecards.configuration.AgileCardsConfiguration;

/**
 * CLI Config for the action "version"
 * Created by Beewy on 20/02/2017.
 */
public class VersionAction extends AgileCardsAction {

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
