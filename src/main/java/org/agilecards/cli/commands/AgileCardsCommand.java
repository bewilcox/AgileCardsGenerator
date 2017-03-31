package org.agilecards.cli.commands;

import org.agilecards.configuration.AgileCardsConfiguration;
import org.kohsuke.args4j.CmdLineParser;
import org.kohsuke.args4j.Option;

/**
 * Base CLI Actions.
 * Created by Beewy on 25/02/2017.
 */
public abstract class AgileCardsCommand {

    @Option(name = "--help", usage = "Show specific usage", aliases = "-H", help = true, hidden = false)
    private boolean help;

    public abstract void showSpecificUsage();

    public abstract String getName();

    protected void showUsage(String actionName, String actionUsage) {
        System.out.println(AgileCardsConfiguration.APP_NAME + " " +
                actionName + " : " +
                actionUsage);
        System.out.println("");
        System.out.println("Usage : " + AgileCardsConfiguration.APP_NAME + " " +
                actionName + " [options]");
        new CmdLineParser(new VersionCommand()).printUsage(System.out);
    }

    public boolean isHelp() {
        return help;
    }

}
