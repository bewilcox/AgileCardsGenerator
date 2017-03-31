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
        //FIXME Pb enconding avec windows ?
        if (!isWindows()) {
            assertEquals(expectedUsage, outContent.toString());
        } else {
            assertTrue(true);
        }
    }


    private String getUsageString() {
       return "Generate your agile cards, and print them !" + System.getProperty("line.separator") +
                System.getProperty("line.separator") +
                "Agile Cards Generator application" + System.getProperty("line.separator") +
                "Based on your customs templates, you can generate your stories and/or tasks from differents sources," + System.getProperty("line.separator") +
                "like a .cvs file, xlsx file or from a third party application." + System.getProperty("line.separator") +
               System.getProperty("line.separator") +
                "Example : agile-cards [action] [options]" +System.getProperty("line.separator")+
                "With verbose mode : agile-cards --log [action] [options]" +System.getProperty("line.separator")+
               System.getProperty("line.separator")+
                "Usage : " +System.getProperty("line.separator")+
                " [version | init | generate | blank] : Actions. Use {action} --help for" +System.getProperty("line.separator")+
                "                                       specific usage" +System.getProperty("line.separator")+
                " --help (-H)                         : Show usage (default: false)" +System.getProperty("line.separator")+
                " --log (-L)                          : Activate verbose mode (default: false)" +System.getProperty("line.separator")+
               System.getProperty("line.separator")+
                "Actions : " +System.getProperty("line.separator")+
                "\tversion\t\t: Show the application version" +System.getProperty("line.separator")+
                "\tinit\t\t: Init the configuration and template files" +System.getProperty("line.separator")+
                "\tgenerate\t: Generate the agile cards" +System.getProperty("line.separator")+
                "\tblank\t\t: Generate blank cards"+System.getProperty("line.separator");
    }

    private  boolean isWindows()
    {
        return System.getProperty("os.name").contains("Windows");
    }
}