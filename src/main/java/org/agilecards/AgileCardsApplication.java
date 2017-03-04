package org.agilecards;


import ch.qos.logback.classic.Level;
import org.agilecards.cli.AgileCardsCommandLineManager;
import org.agilecards.cli.args4j.Args4jAgileCardsCommandLineManagerImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


/**
 * Command line interface for the agile card generator
 *
 */
public class AgileCardsApplication
{
    private static final Logger LOG = LoggerFactory.getLogger(AgileCardsApplication.class);

    /**
     * Main method. Application start point
     * @param args
     */
    public static void main( String[] args )
    {
        LOG.debug("Initialize application");
        AgileCardsCommandLineManager cli = new Args4jAgileCardsCommandLineManagerImpl();
        cli.handleCLICommands(args);

        if (cli.isVerboseActivated()) {
            activateVerboseMode();
        }

        if (cli.isHelp()) {
            cli.showUsage();
        } else {
            cli.executeAction();
        }
    }

    /**
     * Activate verbose mode (debug mode)
     */
    private static void activateVerboseMode() {
        org.slf4j.Logger rootLogger = org.slf4j.LoggerFactory.getLogger("ROOT");
        if (rootLogger instanceof ch.qos.logback.classic.Logger) {
            ch.qos.logback.classic.Logger root = (ch.qos.logback.classic.Logger) rootLogger;
            root.setLevel(Level.DEBUG);
        }
        LOG.debug("Verbose mode is activated");
    }

}
