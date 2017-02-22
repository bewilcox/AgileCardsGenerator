package org.agilecards;


import ch.qos.logback.classic.Level;
import ch.qos.logback.classic.encoder.PatternLayoutEncoder;
import ch.qos.logback.classic.spi.ILoggingEvent;
import ch.qos.logback.core.Appender;
import ch.qos.logback.core.ConsoleAppender;
import ch.qos.logback.core.Context;
import ch.qos.logback.core.LogbackException;
import ch.qos.logback.core.filter.Filter;
import ch.qos.logback.core.spi.FilterReply;
import ch.qos.logback.core.status.Status;
import com.beust.jcommander.JCommander;
import com.beust.jcommander.ParameterException;
import com.sun.tools.doclets.formats.html.SourceToHTMLConverter;
import org.agilecards.cli.commands.BaseOptions;
import org.agilecards.cli.commands.BaseParameters;
import org.agilecards.cli.commands.GenerateCommand;
import org.agilecards.cli.commands.VersionCommand;
import org.kohsuke.args4j.CmdLineException;
import org.kohsuke.args4j.CmdLineParser;
import org.kohsuke.args4j.OptionHandlerFilter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;


/**
 * Command line interface for the agile card generator
 *
 */
public class AgileCardsApplication
{
    private static final Logger LOG = LoggerFactory.getLogger(AgileCardsApplication.class);
//    private final BaseParameters baseParams = new BaseParameters();
//    private final VersionCommand versionCommand = new VersionCommand();
    private final String APP_NAME ="agile-cards";
    private CmdLineParser parser;

    /**
     * Main method. Application start point
     * @param args
     */
    public static void main( String[] args )
    {
        LOG.debug("Initialize application");
        AgileCardsApplication agileCardsApplication = new AgileCardsApplication();
        agileCardsApplication.handleCLICommands(args);
    }

    /**
     * Handle parameters
     * @param args
     */
    private void handleCLICommands(String[] args) {

//        JCommander cli =  new JCommander(baseParams);
//        cli.setProgramName(APP_NAME);
//
//        if (args.length == 0) {
//            LOG.debug("No parameter found");
//            this.showUsage(cli);
//        } else {
//            try {
//                // Add version command
//                cli.addCommand("version",versionCommand);
//                cli.parse(args);
//            } catch (ParameterException exception) {
//                LOG.error(exception.getMessage());
//                this.showUsage(cli);
//            }
//        }
//
//        // Show Usage ?
//        if (baseParams.isHelp()) {
//            this.showUsage(cli);
//        }
//
//        if (baseParams.isVerbose()) {
//            LOG.info("Verbose mode activated");
//            this.activateVerbose();
//        }
//
//        if (this.versionCommand.isShowVersion()) {
//            LOG.debug("Read version from the Manifest");
//            System.out.println(APP_NAME + " " + AgileCardsApplication.class.getPackage().getImplementationVersion());
//        }

        BaseOptions baseOptions = new BaseOptions();
        parser = new CmdLineParser(baseOptions);
        try {
            parser.parseArgument(args);
        } catch (CmdLineException e) {
            LOG.error(e.getMessage());
            parser.printUsage(System.err);
            System.err.println("\n\tExample: " + APP_NAME + parser.printExample(OptionHandlerFilter.ALL));
            System.exit(0);
        }

        if (baseOptions.isVerbose()) {
            this.activateVerboseMode();
        }

        if (baseOptions.isHelp()) {
            this.showUsage();
        }

    }

    /**
     * Activate verbose mode (debug mode)
     */
    private void activateVerboseMode() {
        org.slf4j.Logger rootLogger = org.slf4j.LoggerFactory.getLogger("ROOT");
        if (rootLogger instanceof ch.qos.logback.classic.Logger) {
            ch.qos.logback.classic.Logger root = (ch.qos.logback.classic.Logger) rootLogger;
            root.setLevel(Level.DEBUG);
        }
        LOG.debug("Verbose mode is activated");
    }

    /**
     * Show usage
     */
    private void showUsage() {
        System.out.println("Generate your agile cards, and print them !");
        System.out.println("");
        System.out.println("Agile Cards Generator application\n" +
                "Based on your customs templates, you can generate your stories and/or tasks from differents sources,\n" +
                "like a .cvs file, xlsx file or from a third party application.");
        System.out.println("");
        System.out.println("Example : " + APP_NAME + " [action] [options]");
        System.out.println("Usage : ");
        this.parser.printUsage(System.out);
        System.out.println("");
        System.out.println("Action : ");
        //TODO Refactorer
        new CmdLineParser(new GenerateCommand()).printUsage(System.out);
    }


}
