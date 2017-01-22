package org.agilecardsgen;


import com.beust.jcommander.JCommander;
import com.beust.jcommander.ParameterException;
import org.agilecardsgen.cli.commands.BaseParameters;

/**
 * Command line interface for the agile card generator
 *
 */
public class AgileCardsGenApp
{
    private final BaseParameters baseParams = new BaseParameters();

    public static void main( String[] args )
    {
        AgileCardsGenApp agileCardsGenApp = new AgileCardsGenApp();
        agileCardsGenApp.handleCLICommands(args);
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
            System.out.println(AgileCardsGenApp.class.getPackage().getImplementationVersion());
        }
    }

    private void showUsage(JCommander cli) {
        cli.usage();
        System.exit(0);
    }


}
