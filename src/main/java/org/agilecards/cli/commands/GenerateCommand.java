package org.agilecards.cli.commands;

import org.agilecards.configuration.AgileCardsConfiguration;
import org.kohsuke.args4j.Option;

/**
 * Created by Beewy on 22/02/2017.
 */
public class GenerateCommand extends AgileCardsCommand {

    @Option(name = "--generator", required = true, usage = "Set the generator name", aliases = "-G", metaVar = "{generator name}")
    private String generator;

    public String getGenerator() {
        return generator;
    }

    /**
     * Show the specific usage for this action
     */
    public void showSpecificUsage() {
        super.showUsage(this.getName(),AgileCardsConfiguration.GENERATE_USAGE);
    }

    @Override
    public String getName() {
        return AgileCardsConfiguration.GENERATE_ACTION;
    }
}
