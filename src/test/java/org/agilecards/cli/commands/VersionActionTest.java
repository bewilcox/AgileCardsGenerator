package org.agilecards.cli.commands;

import org.junit.Assert;
import org.junit.Test;

/**
 * Tests class for the version action.
 * Created by Beewy on 25/02/2017.
 */
public class VersionActionTest extends BaseActionTest{

    @Test
    public void testVersionAction() throws Exception {
        parser.parseArgument("version");
        Assert.assertTrue(cliConfiguration.getAction() instanceof VersionCommand);
        Assert.assertFalse(cliConfiguration.isVerbose());
    }

    @Test
    public void testVersionActionWithVerbose() throws Exception {
        parser.parseArgument("--log","version");
        Assert.assertTrue(cliConfiguration.getAction() instanceof VersionCommand);
        Assert.assertTrue(cliConfiguration.isVerbose());
    }

    @Test
    public void showSpecificUsage() throws Exception {
        parser.parseArgument("version","--help");
        Assert.assertTrue(cliConfiguration.getAction().isHelp());

        String expectedSpecificUsage =
                "agile-cards version : Show the application version" + System.getProperty("line.separator") +
                System.getProperty("line.separator") +
                "Usage : agile-cards version [options]" + System.getProperty("line.separator") +
                " --help (-H) : Show specific usage (default: false)" + System.getProperty("line.separator");

        cliConfiguration.getAction().showSpecificUsage();
        Assert.assertEquals(expectedSpecificUsage,outContent.toString());
    }

}