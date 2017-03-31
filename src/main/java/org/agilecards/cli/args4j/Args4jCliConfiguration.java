package org.agilecards.cli.args4j;

import org.agilecards.cli.commands.*;
import org.agilecards.configuration.AgileCardsConfiguration;
import org.kohsuke.args4j.Argument;
import org.kohsuke.args4j.Option;
import org.kohsuke.args4j.spi.SubCommand;
import org.kohsuke.args4j.spi.SubCommandHandler;
import org.kohsuke.args4j.spi.SubCommands;

/**
 * Base configuration class for the command line interface.
 * Created by Beewy on 21/02/2017.
 */
public class Args4jCliConfiguration {

    /**
     * Show DEBUG logs and stack traces.
     */
    @Option(name = "--log", usage = "Activate verbose mode", aliases = "-L")
    private boolean verbose = false;

    /**
     * Show the usage.
     */
    @Option(name = "--help", usage = "Show usage", aliases = "-H", help = true)
    private boolean help;

    /**
     * Declaration of the application commands.
     */
    @Argument(required = true,
            metaVar = "action",
            usage = "Actions. Use {action} --help for specific usage",
            handler = SubCommandHandler.class)
    @SubCommands({
            @SubCommand(name = AgileCardsConfiguration.VERSION_ACTION, impl=VersionCommand.class),
            @SubCommand(name = AgileCardsConfiguration.INIT_ACTION, impl=InitCommand.class),
            @SubCommand(name = AgileCardsConfiguration.GENERATE_ACTION, impl=GenerateCommand.class),
            @SubCommand(name = AgileCardsConfiguration.BLANK_ACTION, impl=BlankCommand.class),
    })
    private AgileCardsCommand action;


    public boolean isVerbose() {
        return verbose;
    }

    public boolean isHelp() {
        return help;
    }

    public AgileCardsCommand getAction() {
        return action;
    }
}
