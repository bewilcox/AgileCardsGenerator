package org.agilecards.cli.commands;

import org.kohsuke.args4j.Argument;
import org.kohsuke.args4j.Option;
import org.kohsuke.args4j.spi.SubCommand;
import org.kohsuke.args4j.spi.SubCommandHandler;
import org.kohsuke.args4j.spi.SubCommands;

/**
 * Created by Beewy on 21/02/2017.
 */
public class BaseOptions {

    @Option(name = "--log", usage = "Activate verbose mode", aliases = "-L")
    private boolean verbose = false;

    @Option(name = "--help", usage = "Show usage", aliases = "-H", help = true)
    private boolean help;

    @Argument(required = true,
            index = 0,
            metaVar = "action",
            usage = "Actions. Use {action} --help for specific usage",
            handler = SubCommandHandler.class)
    @SubCommands({
            @SubCommand(name = "version", impl=VersionCommand.class),
            @SubCommand(name = "init", impl=InitCommand.class),
            @SubCommand(name = "generate", impl=GenerateCommand.class),
            @SubCommand(name = "blank", impl=BlankCommand.class),
    })
    private SubCommand action;


    public boolean isVerbose() {
        return verbose;
    }

    public boolean isHelp() {
        return help;
    }
}
