package org.agilecards.cli.actions;


import org.agilecards.configuration.AgileCardsConfiguration;
import org.kohsuke.args4j.CmdLineParser;

/**
 * CLI Config for the action "version"
 * Created by Beewy on 20/02/2017.
 */
public class VersionAction extends AgileCardsAction {

    /**
     * Show the specific usage for this action
     */
    public void showSpecificUsage() {
        System.out.println(AgileCardsConfiguration.APP_NAME + " " +
                AgileCardsConfiguration.VERSION_ACTION + " : " +
                AgileCardsConfiguration.VERSION_USAGE);
        System.out.println("");
        System.out.println("Usage : " + AgileCardsConfiguration.APP_NAME + " " +
                AgileCardsConfiguration.VERSION_ACTION + " [options]");
        new CmdLineParser(new VersionAction()).printUsage(System.out);
    }
}
