package org.agilecards.cli.args4j;

import org.agilecards.exceptions.AgileCardsException;
import org.agilecards.cli.AgileCardsCommandLineManager;
import org.agilecards.cli.BaseManager;
import org.agilecards.cli.actions.VersionAction;
import org.agilecards.configuration.AgileCardsConfiguration;
import org.kohsuke.args4j.CmdLineException;
import org.kohsuke.args4j.CmdLineParser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by Beewy on 25/02/2017.
 */
public class Args4jAgileCardsCommandLineManagerImpl extends BaseManager implements AgileCardsCommandLineManager {

    private static final Logger LOG = LoggerFactory.getLogger(Args4jAgileCardsCommandLineManagerImpl.class);
    private CmdLineParser parser;
    private Args4jCliConfiguration cliConfiguration;

    /**
     * CLI Arguments parsing.
     * @param args
     */
    public void handleCLICommands(String[] args) throws AgileCardsException {
        this.cliConfiguration = new Args4jCliConfiguration();
        parser = new CmdLineParser(cliConfiguration);
        try {
            parser.parseArgument(args);
        } catch (CmdLineException e) {
            throw new AgileCardsException();
        }
    }

    /**
     * Execute the action launch by the user
     */
    public void executeAction() {
        LOG.debug("Start executing the current action");
        if (this.cliConfiguration.getAction().isHelp()) {
            LOG.debug("Show specific usage is asked");
            this.cliConfiguration.getAction().showSpecificUsage();
        } else {
            LOG.debug("Run the following action : {}",this.cliConfiguration.getAction().getClass().getCanonicalName());

            // Version
            if (this.cliConfiguration.getAction() instanceof VersionAction) {
                System.out.println(AgileCardsConfiguration.APP_NAME + " " + this.getVersionService().getApplicationVersion());
            }


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
     * Flag to show the main usage
     * @return
     */
    public boolean isHelp() {
        return this.cliConfiguration.isHelp();
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
        System.out.println("Example : " + AgileCardsConfiguration.APP_NAME + " [action] [options]");
        System.out.println("With verbose mode : " + AgileCardsConfiguration.APP_NAME + " --log [action] [options]");
        System.out.println("");
        System.out.println("Usage : ");
        this.parser.printUsage(System.out);
        System.out.println("");
        System.out.println("Actions : ");
        System.out.println("\t" + AgileCardsConfiguration.VERSION_ACTION + "\t\t: " + AgileCardsConfiguration.VERSION_USAGE);
        System.out.println("\t" + AgileCardsConfiguration.INIT_ACTION + "\t\t: "  + AgileCardsConfiguration.INIT_USAGE);
        System.out.println("\t" + AgileCardsConfiguration.GENERATE_ACTION + "\t: " + AgileCardsConfiguration.GENERATE_USAGE);
        System.out.println("\t" + AgileCardsConfiguration.BLANK_ACTION + "\t\t: "  + AgileCardsConfiguration.BLANK_USAGE);
    }


}
