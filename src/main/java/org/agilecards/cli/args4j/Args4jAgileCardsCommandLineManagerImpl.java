package org.agilecards.cli.args4j;

import org.agilecards.cli.AgileCardsCommandLineManager;
import org.agilecards.configuration.AgileCardsConfiguration;
import org.kohsuke.args4j.CmdLineException;
import org.kohsuke.args4j.CmdLineParser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by Beewy on 25/02/2017.
 */
public class Args4jAgileCardsCommandLineManagerImpl implements AgileCardsCommandLineManager {

    private static final Logger LOG = LoggerFactory.getLogger(Args4jAgileCardsCommandLineManagerImpl.class);
    private CmdLineParser parser;
    private Args4jCliConfiguration cliConfiguration;

    /**
     * CLI Arguments parsing.
     * @param args
     */
    public void handleCLICommands(String[] args) {
        this.cliConfiguration = new Args4jCliConfiguration();
        parser = new CmdLineParser(cliConfiguration);
        try {
            parser.parseArgument(args);
        } catch (CmdLineException e) {
            LOG.error(e.getMessage());
            this.showUsage();
        }
    }

    /**
     * Flag to show debug logs and stack traces.
     * @return
     */
    public boolean isVerboseActivated() {
        return this.cliConfiguration.isVerbose();
    }

    /**
     * Show usage.
     */
    public void showUsage() {
        System.out.println("Generate your agile cards, and print them !");
        System.out.println("");
        System.out.println("Agile Cards Generator application\n" +
                "Based on your customs templates, you can generate your stories and/or tasks from differents sources,\n" +
                "like a .cvs file, xlsx file or from a third party application.");
        System.out.println("");
        System.out.println("Example : " + AgileCardsConfiguration.APP_NAME + "[action] [options]");
        System.out.println("With verbose mode : " + AgileCardsConfiguration.APP_NAME + "--log [action] [options]");
        System.out.println("Usage : ");
        this.parser.printUsage(System.out);
    }


}
