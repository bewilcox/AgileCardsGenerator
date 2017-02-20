package org.agilecards;


import com.beust.jcommander.JCommander;
import com.beust.jcommander.ParameterException;
import org.agilecards.cli.commands.BaseParameters;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Command line interface for the agile card generator
 *
 */
public class AgileCardsApplication
{
    private static final Logger LOG = LoggerFactory.getLogger(AgileCardsApplication.class);
    private final BaseParameters baseParams = new BaseParameters();

    public static void main( String[] args )
    {
        LOG.debug("This is debug trace");
        LOG.info("This is a info trace");
        LOG.warn("A warn one");
        LOG.error("And a error ");
        AgileCardsApplication agileCardsApplication = new AgileCardsApplication();
        agileCardsApplication.handleCLICommands(args);
    }

    private void handleCLICommands(String[] args) {

        JCommander cli =  new JCommander(baseParams);
        cli.setProgramName("Agile Cards Generator");

        if (args.length == 0) {
            this.showUsage(cli);
        } else {
            try {
                cli.parse(args);
            } catch (ParameterException exception) {
                System.out.println(exception.getMessage());
                this.showUsage(cli);
            }
        }

        // Show Usage ?
        if (baseParams.isHelp()) {
            this.showUsage(cli);
        }

        // Show Application version ?
        if (baseParams.isVersion()) {
            System.out.println(AgileCardsApplication.class.getPackage().getImplementationVersion());
        }
    }

    private void showUsage(JCommander cli) {
        cli.usage();
        System.exit(0);
    }


}
