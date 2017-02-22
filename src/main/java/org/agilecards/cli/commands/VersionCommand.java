package org.agilecards.cli.commands;


import org.kohsuke.args4j.CmdLineParser;
import org.kohsuke.args4j.Option;
import org.kohsuke.args4j.OptionDef;
import org.kohsuke.args4j.spi.Setter;
import org.kohsuke.args4j.spi.SubCommand;
import org.kohsuke.args4j.spi.SubCommandHandler;

import java.lang.annotation.Annotation;

/**
 * Created by Beewy on 20/02/2017.
 */
public class VersionCommand {

    @Option(name="-V")
    private boolean showVersion = true;


    public boolean isShowVersion() {
        return showVersion;
    }

}
