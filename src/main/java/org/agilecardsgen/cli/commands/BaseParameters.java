package org.agilecardsgen.cli.commands;

import com.beust.jcommander.Parameter;
import com.beust.jcommander.Parameters;

/**
 * Created by Beewy on 22/01/2017.
 */
@Parameters()
public class BaseParameters {

    @Parameter(names = {"--help","-h"}, description = "Show usage", help = true)
    private boolean help;

    @Parameter(names = {"--version","-v"}, description = "Current version of the application")
    private boolean version;

    @Parameter(names = {"--verbose"}, description = "Active verbose mode for all commands")
    private boolean verbose;

    public boolean isVersion() {
        return version;
    }

    public boolean isHelp() {
        return help;
    }

    public boolean isVerbose() {
        return verbose;
    }
}
