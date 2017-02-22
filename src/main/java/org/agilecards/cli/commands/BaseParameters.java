package org.agilecards.cli.commands;

import com.beust.jcommander.Parameter;
import com.beust.jcommander.Parameters;

/**
 *
 * Created by Beewy on 22/01/2017.
 */
@Parameters()
public class BaseParameters {

    @Parameter(names = {"--help","-H"}, description = "Show usage", help = true)
    private boolean help;

    @Parameter(names = {"--verbose","-V"}, description = "Activate verbose mode for all commands")
    private boolean verbose;

    public boolean isHelp() {
        return help;
    }

    public boolean isVerbose() {
        return verbose;
    }
}
