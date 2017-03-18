package org.agilecards.cli.args4j;

import org.agilecards.cli.actions.VersionAction;
import org.agilecards.exceptions.AgileCardsException;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * CLI Manager Test dor Args4J.
 * Created by Beewy on 05/03/2017.
 */
public class Args4jAgileCardsCommandLineManagerImplTest {

    private Args4jAgileCardsCommandLineManagerImpl manager;
    private ByteArrayOutputStream outContent;

    @Before
    public void setUp() throws Exception {
        manager = new Args4jAgileCardsCommandLineManagerImpl();

        // To test console output
        // Output stream to test console output
        outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
    }


    @Test(expected = AgileCardsException.class)
    public void executeEmptyArgs() throws AgileCardsException {
        String[] args = {""};
        manager.handleCLICommands(args);
        assertTrue(outContent.toString().contains(getUsageString()));
    }

    @Test
    public void executeAction_Version() throws Exception {
        String[] args = {"version"};
        manager.handleCLICommands(args);
        manager.executeAction();
        assertTrue(outContent.toString().contains("agile-cards null"));
    }

    @Test
    public void executeActionWithUsage_Version() throws Exception {
        VersionAction versionAction = new VersionAction();
        versionAction.showSpecificUsage();
        String specificUsage = outContent.toString();
        outContent.reset();

        String[] args = {"version","--help"};
        manager.handleCLICommands(args);
        manager.executeAction();

        assertTrue(outContent.toString().contains(specificUsage));
    }

    @Test
    public void isVerboseActivated() throws Exception {
        String[] args = {"--log","version"};
        manager.handleCLICommands(args);
        assertTrue(manager.isVerboseActivated());
    }

    @Test
    public void isHelp() throws Exception {
        String[] args = {"--help"};
        manager.handleCLICommands(args);
        assertTrue(manager.isHelp());
    }

    @Test
    public void showUsage() throws Exception {
        String expectedUsage = getUsageString();
        String[] args = {"version"};
        manager.handleCLICommands(args);
        outContent.reset();
        manager.showUsage();
        assertEquals(expectedUsage,outContent.toString());

    }


    private String getUsageString() {
       return "Generate your agile cards, and print them !\n" +
                "\n" +
                "Agile Cards Generator application\n" +
                "Based on your customs templates, you can generate your stories and/or tasks from differents sources,\n" +
                "like a .cvs file, xlsx file or from a third party application.\n" +
                "\n" +
                "Example : agile-cards [action] [options]\n" +
                "With verbose mode : agile-cards --log [action] [options]\n" +
                "\n" +
                "Usage : \n" +
                " [version | init | generate | blank] : Actions. Use {action} --help for\n" +
                "                                       specific usage\n" +
                " --help (-H)                         : Show usage (default: false)\n" +
                " --log (-L)                          : Activate verbose mode (default: false)\n" +
                "\n" +
                "Actions : \n" +
                "\tversion\t\t: Show the application version\n" +
                "\tinit\t\t: Init the configuration and template files\n" +
                "\tgenerate\t: Generate the agile cards\n" +
                "\tblank\t\t: Generate blank cards\n";
    }

}